package chapter05.item26;

import java.util.Set;

//26-6
//비한정적 와일드카드 타입을 사용하라 - 타입 안전하며 유연하다.
//158P
public class WildcardExample {
    public static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for(Object o1 : s1) {
            if(s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Set<String> s1 = Set.of("a", "b");
        Set<String> s2 = Set.of("b", "c");
        Set<Integer> s3 = Set.of(1, 2, 3);
        Set<Object> s4 = Set.of("b", 2);

        System.out.println("s1 ∩ s2 = " + numElementsInCommon(s1, s2));
        System.out.println("s2 ∩ s3 = " + numElementsInCommon(s2, s3));
        System.out.println("s3 ∩ s4 = " + numElementsInCommon(s3, s4));
    }
}