package chapter09.item62;

import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        for(Iterator<Integer> i = list.iterator(); i.hasNext();) {
            //62-1
            //혼합 타입을 문자열로 처리한 부적절한 예
            //362P
            System.out.println("#" + i.next());
        }
    }
}
