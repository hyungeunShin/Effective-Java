package chapter11.item79;

import java.util.HashSet;

public class Test2 {
    public static void main(String[] args) {
        //ObservableSetV1<Integer> set = new ObservableSetV1<>(new HashSet<>());
        //ObservableSetV2<Integer> set = new ObservableSetV2<>(new HashSet<>());
        ObservableSetV3<Integer> set = new ObservableSetV3<>(new HashSet<>());

        set.addObserver(new SetObserver<>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if(e == 23) {
                    //값이 23이면 자신을 구독해지한다.
                    s.removeObserver(this);
                }
            }
        });

        for(int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}