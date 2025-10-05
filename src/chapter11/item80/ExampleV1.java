package chapter11.item80;

public class ExampleV1 {
    public static void main(String[] args) {
        for(int i = 1; i <= 5; i++) {
            int num = i;
            new Thread(() -> System.out.println("Number " + num + " (run by " + Thread.currentThread().getName() + ")")).start();
        }
    }
}