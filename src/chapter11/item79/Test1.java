package chapter11.item79;

import java.util.HashSet;

public class Test1 {
    public static void main(String[] args) {
        ObservableSetV1<Integer> set = new ObservableSetV1<>(new HashSet<>());

        set.addObserver((s, e) -> System.out.println(e));

        for(int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}