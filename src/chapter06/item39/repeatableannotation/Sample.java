package chapter06.item39.repeatableannotation;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    //39-9
    //반복 가능 애너테이션을 두 번 단 코드
    //244P
    @ExceptionTest(IndexOutOfBoundsException.class)
    @ExceptionTest(NullPointerException.class)
    public static void doublyBad() {
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }
}