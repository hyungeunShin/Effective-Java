package chapter09.item61;

import java.util.Comparator;

public class BrokenComparator {
    public static void main(String[] args) {
        //61-1
        //잘못 구현된 비교자 - 문제를 찾아보자!
        //359P
        Comparator<Integer> naturalOrderV1 = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);

        //61-2
        //문제를 수정한 비교자
        //359P
        Comparator<Integer> naturalOrderV2 = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed; //오토박싱
            return i < j ? -1 : (i == j ? 0 : 1);
        };

        int result1 = naturalOrderV1.compare(new Integer(42), new Integer(42));
        System.out.println(result1);

        int result2 = naturalOrderV2.compare(new Integer(42), new Integer(42));
        System.out.println(result2);
    }
}