package chapter08.item55;

import java.util.*;

public class Max {
    //55-1
    //컬렉션에서 최댓값을 구한다. - 컬렉션이 비었으면 예외를 던진다.
    //327P
    public static <E extends Comparable<E>> E maxV1(Collection<E> c) {
        if(c.isEmpty()) {
            throw new IllegalArgumentException("빈 컬렉션");
        }

        E result = null;
        for(E e : c) {
            if(result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }

        return result;
    }

    //55-2
    //컬렉션에서 최댓값을 구해 Optional<E>로 반환한다.
    //327P
    public static <E extends Comparable<E>> Optional<E> maxV2(Collection<E> c) {
        if(c.isEmpty()) {
            return Optional.empty();
        }

        E result = null;
        for(E e : c) {
            if(result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }

        return Optional.of(result);
    }

    //55-3
    //컬렉션에서 최댓값을 구해 Optional<E>로 반환한다. - 스트림 버전
    //328P
    public static <E extends Comparable<E>> Optional<E> maxV3(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }

    public static void main(String[] args) {
        List<String> words = List.of("C", "A", "B", "D", "E");

        System.out.println(maxV1(words));
        System.out.println(maxV2(words));
        System.out.println(maxV3(words));

        //55-4
        //옵셔널 활용 1 - 기본값을 정해둘 수 있다.
        //328P
        String lastWordInLexicon = maxV3(words).orElse("단어 없음...");

        //55-5
        //옵셔널 활용 2 - 원하는 예외를 던질 수 있다.
        //328P
        maxV3(words).orElseThrow(CustomException::new);

        //55-6
        //옵셔널 활용 3 - 항상 값이 채워져 있다고 가정한다.
        //328P
        maxV3(words).get();
    }
}