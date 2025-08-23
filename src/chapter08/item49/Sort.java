package chapter08.item49;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        long[] data = {10, 50, 30, 20, 40, 60};
        sort(data, 1, 4);
        System.out.println(Arrays.toString(data));
    }

    //49-2
    //재귀 정렬용 private 도우미 함수
    //300P
    private static void sort(long[] a, int offset, int length) {
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;

        Arrays.sort(a, offset, offset + length);
    }
}
