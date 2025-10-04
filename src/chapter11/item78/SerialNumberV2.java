package chapter11.item78;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

//78-5
//java.util.concurrent.atomic을 이용한 락-프리 동기화
//418P
public class SerialNumberV2 {
    private static final AtomicLong nextSerialNumber = new AtomicLong();

    public static long generateSerialNumber() {
        return nextSerialNumber.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
        Map<Long, Integer> numCnt = new ConcurrentHashMap<>();

        Runnable task = () -> {
            for(int i = 0; i < 1_000_000; i++) {
                long num = generateSerialNumber();
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
