package chapter05.item31;

import java.util.Arrays;
import java.util.List;

public class Swap {
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        swap(list, 0, list.size() - 1);
        System.out.println(list);
    }
}