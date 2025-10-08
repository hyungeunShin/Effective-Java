package chapter11.item84;

import java.util.concurrent.CountDownLatch;

public class Test {
    private static final int THREADS = 500;

    public static void main(String[] args) throws InterruptedException {
        long slowTime = testSlowLatch();
        long fastTime = testFastLatch();

        System.out.println("SlowCountDownLatch: " + slowTime + "ms");
        System.out.println("CountDownLatch:     " + fastTime + "ms");
    }

    private static long testSlowLatch() throws InterruptedException {
        SlowCountDownLatch latch = new SlowCountDownLatch(THREADS);

        long start = System.currentTimeMillis();

        for(int i = 0; i < THREADS; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }).start();
        }

        latch.await();
        return System.currentTimeMillis() - start;
    }

    private static long testFastLatch() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(THREADS);

        long start = System.currentTimeMillis();

        for(int i = 0; i < THREADS; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            }).start();
        }

        latch.await();
        return System.currentTimeMillis() - start;
    }
}
