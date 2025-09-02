package chapter09.item64;

import java.util.LinkedHashSet;
import java.util.Set;

public class Test {
    //좋은 예 - 인터페이스를 타입으로 사용했다.
    //368P
    Set<Son> set1 = new LinkedHashSet<>();

    //나쁜 예 - 클래스를 타입으로 사용했다!
    //368P
    LinkedHashSet<Son> set2 = new LinkedHashSet<>();
}
