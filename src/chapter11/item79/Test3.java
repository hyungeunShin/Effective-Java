package chapter11.item79;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test3 {
    public static void main(String[] args) {
        //ObservableSetV1<Integer> set = new ObservableSetV1<>(new HashSet<>());
        //ObservableSetV2<Integer> set = new ObservableSetV2<>(new HashSet<>());
        ObservableSetV3<Integer> set = new ObservableSetV3<>(new HashSet<>());

        //79-2
        //쓸데없이 백그라운드 스레드를 사용하는 관찰자
        //423P
        set.addObserver(new SetObserver<>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if(e == 23) {
                    ExecutorService exec = Executors.newSingleThreadExecutor();
                    try {
                        exec.submit(() -> s.removeObserver(this)).get();
                    } catch(ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex);
                    } finally {
                        exec.shutdown();
                    }
                }
            }
        });

        for(int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}