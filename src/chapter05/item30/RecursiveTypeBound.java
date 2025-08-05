package chapter05.item30;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class RecursiveTypeBound {
    //30-7
    //컬렉션에서 최댓값을 반환한다. - 재귀적 타입 한정 사용
    //179P
    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if(c.isEmpty()) {
            throw new IllegalArgumentException("컬렉션이 비어 있습니다.");
        }

        E result = null;
        for(E e : c) {
            if(result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(max(list));
    }
}