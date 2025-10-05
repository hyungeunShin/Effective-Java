package chapter11.item80;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExampleV2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for(int i = 1; i <= 5; i++) {
            int num = i;
            executor.submit(() -> System.out.println("Number " + num + " (run by " + Thread.currentThread().getName() + ")"));
        }

        executor.shutdown();
    }
}