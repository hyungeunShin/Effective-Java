package chapter03.item14;

import java.util.*;

public class HashCodeComparatorExample {
    static class Person {
        int age;

        public Person(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(10),
                new Person(30),
                new Person(50),
                new Person(20),
                new Person(-1),
                new Person(Integer.MAX_VALUE)
        );

        //14-4
        //해시코드 값의 차를 기준으로 하는 비교자 - 추이성을 위배한다!
        //93P
        Comparator<Person> hashCodeOrder1 = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.hashCode() - o2.hashCode();
            }
        };

        //14-5
        //정적 compare 메서드를 활용한 비교자
        //94P
        Comparator<Person> hashCodeOrder2 = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.hashCode(), o2.hashCode());
            }
        };

        //14-6
        //비교자 생성 메서드를 활용한 비교자
        //94P
        Comparator<Person> hashCodeOrder3 = Comparator.comparingInt(Object::hashCode);

        //people.sort(hashCodeOrder1);
        //people.sort(hashCodeOrder2);
        people.sort(hashCodeOrder3);

        System.out.println(people);
    }
}