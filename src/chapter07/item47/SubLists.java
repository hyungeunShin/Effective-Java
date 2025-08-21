package chapter07.item47;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubLists {
    //47-6
    //입력 리스트의 모든 부분리스트를 스트림으로 반환한다.
    //288P ~ 289P
    public static <E> Stream<List<E>> ofV1(List<E> list) {
        return Stream.concat(Stream.of(Collections.emptyList()), prefixes(list).flatMap(SubLists::suffixes));
    }

    private static <E> Stream<List<E>> prefixes(List<E> list) {
        return IntStream.rangeClosed(1, list.size())
                        .mapToObj(end -> list.subList(0, end));
    }

    private static <E> Stream<List<E>> suffixes(List<E> list) {
        return IntStream.range(0, list.size())
                        .mapToObj(start -> list.subList(start, list.size()));
    }

    //47-7
    //입력 리스트의 모든 부분리스트를 스트림으로 반환한다.
    //289P
    public static <E> Stream<List<E>> ofV2(List<E> list) {
        return IntStream.range(0, list.size())
                        .mapToObj(start -> IntStream.rangeClosed(start + 1, list.size())
                                                        .mapToObj(end -> list.subList(start, end)))
                        .flatMap(x -> x);
    }

    public static void main(String[] args) {
        List<String> list = List.of("1", "2", "3");
        SubLists.ofV1(list).forEach(System.out::println);
        SubLists.ofV2(list).forEach(System.out::println);
    }
}