package chapter09.Item58;

import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        //58-1
        //컬렉션 순회하기 - 더 나은 방법이 있다.
        //347P
        for(Iterator<Integer> i = list.iterator(); i.hasNext();) {
            Integer e = i.next();
        }

        Integer[] a = {1, 2, 3, 4, 5};
        //58-2
        //배열 순회하기 - 더 나은 방법이 있다.
        //347P
        for(int i = 0; i < a.length; i++) {
            //...
        }

        //58-3
        //컬렉션과 배열을 순회하는 올바른 관용구
        //348P
        for(Integer i : list) {
            //...
        }
    }
}
