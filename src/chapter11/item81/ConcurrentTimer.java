package chapter11.item81;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentTimer {
    //81-3
    //동시 실행 시간을 재는 간단한 프레임워크
    //433P ~ 434P
    public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for(int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                //타이머에게 준비를 마쳤음을 알린다.
                ready.countDown();
                try {
                    //모든 작업자 스레드가 준비될 때까지 기다린다.
                    start.await();
                    action.run();
                } catch(InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    //타이머에게 작업을 마쳤음을 알린다.
                    done.countDown();
                }
            });
        }

        //모든 작업자가 준비될 때까지 기다린다.
        ready.await();
        long startNanos = System.nanoTime();
        //작업자들을 깨운다.
        start.countDown();
        //모든 작업자가 일을 끝마치기를 기다린다.
        done.await();
        return System.nanoTime() - startNanos;
    }

    public static void main(String[] args) throws InterruptedException {
        int concurrency = 8;
        int size = 100_000_000;
        String[] strings = new String[size];
        for(int i = 0; i < size; i++) {
            strings[i] = "str" + (i % 10_000);
        }

        ExecutorService executor = Executors.newFixedThreadPool(concurrency);

        Intern.getMap().clear();
        long timeV1 = time(executor, concurrency, () -> {
            for(String s : strings) {
                Intern.internV1(s);
            }
        });
        System.out.println("internV1 concurrent time: " + timeV1 / 1_000_000 + " ms");

        Intern.getMap().clear();
        long timeV2 = time(executor, concurrency, () -> {
            for(String s : strings) {
                Intern.internV2(s);
            }
        });
        System.out.println("internV2 concurrent time: " + timeV2 / 1_000_000 + " ms");

        executor.shutdown();
    }
}
