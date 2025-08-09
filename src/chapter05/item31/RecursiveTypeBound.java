package chapter05.item31;

import java.util.Arrays;
import java.util.List;

public class RecursiveTypeBound {
    public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
        if(list.isEmpty()) {
            throw new IllegalArgumentException("빈 리스트");
        }

        E result = null;
        for(E e : list) {
            if(result == null || e.compareTo(result) > 0) {
                result = e;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(max(list));
    }
}