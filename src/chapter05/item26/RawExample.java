package chapter05.item26;

import java.util.HashSet;
import java.util.Set;

//26-5
//잘못된 예 - 모르는 타입의 원소도 받는 로 타입을 사용했다.
//157P
public class RawExample {
    public static int numElementsInCommon(Set s1, Set s2) {
        int result = 0;
        for(Object o1 : s1) {
            if(s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Set s1 = new HashSet();
        Set s2 = new HashSet();

        s1.add("a");
        s1.add("b");
        s2.add("b");
        s2.add("c");

        s2.add(123);

        System.out.println("공통 요소 수: " + numElementsInCommon(s1, s2));
    }
}