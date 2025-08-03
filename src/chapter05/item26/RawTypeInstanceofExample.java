package chapter05.item26;

import java.util.List;
import java.util.Set;

public class RawTypeInstanceofExample {
    public static void main(String[] args) {
        Object obj1 = Set.of("a", "b", "c");
        Object obj2 = List.of(1, 2, 3);

        checkSet(obj1); // Set 인스턴스
        checkSet(obj2); // Set 아님
    }

    //26-7
    //로 타입을 써도 좋은 예 - instanceof 연산자
    //159P
    public static void checkSet(Object obj) {
        if(obj instanceof Set) {
            Set<?> s = (Set<?>) obj;
            System.out.println("Set contains: " + s);
        } else {
            System.out.println("Not a Set");
        }
    }
}