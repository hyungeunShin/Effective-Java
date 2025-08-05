package chapter05.item30;

import java.util.HashSet;
import java.util.Set;

public class Union {
    //30-1
    //로 타입 사용 - 수용 불가!
    //176P
//    public static Set union(Set s1, Set s2) {
//        Set result = new HashSet(s1);
//        result.addAll(s2);
//        return result;
//    }

    //30-2
    //제네릭 메서드
    //177P
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    //30-3
    //제네릭 메서드를 활용하는 간단한 프로그램
    //177P
    public static void main(String[] args) {
        Set<String> guys = Set.of("톰", "딕", "해리");
        Set<String> stooges = Set.of("래리", "모에", "컬리");
        Set<String> aflCio = union(guys, stooges);
        System.out.println(aflCio);
    }
}