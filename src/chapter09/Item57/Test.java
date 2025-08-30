package chapter09.Item57;

import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        //57-1
        //컬렉션이나 배열을 순회하는 권장 관용구
        //345P
        for(Integer i : list) {
            //...
        }

        //57-2
        //반복자가 필요할 때의 관용구
        //345P
        for(Iterator<Integer> i = list.iterator(); i.hasNext();) {
            Integer e = i.next();
        }
    }
}
