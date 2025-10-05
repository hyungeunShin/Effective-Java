package chapter11.item80;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ExampleV3 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        IntStream.rangeClosed(1, 5)
                 .mapToObj(num -> CompletableFuture.runAsync(() -> System.out.println("Number " + num + " (run by " + Thread.currentThread().getName() + ")"), executor))
                 .forEach(CompletableFuture::join);

        executor.shutdown();
    }
}