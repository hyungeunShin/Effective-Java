package chapter11.item78;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//78-4
//잘못된 코드 - 동기화가 필요하다!
//417P
public class SerialNumberV1 {
    private static volatile int nextSerialNumber = 0;

    public static int generateSerialNumber() {
        return nextSerialNumber++;
    }

    public static void main(String[] args) throws InterruptedException {
        Map<Integer, Integer> numCnt = new ConcurrentHashMap<>();

        Runnable task = () -> {
            for(int i = 0; i < 1_000_000; i++) {
                int num = generateSerialNumber();
                numCnt.merge(num, 1, Integer::sum);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        numCnt.forEach((num, count) -> {
            if(count > 1) {
                System.out.println(num + ": " + count + "번 생성");
            }
        });
    }
}
