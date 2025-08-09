package chapter05.item31;

import java.util.HashSet;
import java.util.Set;

public class Union {
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<>();
        integers.add(1); 
        integers.add(3); 
        integers.add(5); 

        Set<Double> doubles =  new HashSet<>();
        doubles.add(2.0); 
        doubles.add(4.0); 
        doubles.add(6.0); 

        //Set<Number> numbers = union(integers, doubles);

        //31-6
        //자바 7까지는 명시적 타입 인수를 사용해야 한다.
        //186P
        Set<Number> numbers = Union.<Number>union(integers, doubles);

        System.out.println(numbers);
    }
}