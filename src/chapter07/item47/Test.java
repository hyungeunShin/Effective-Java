package chapter07.item47;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Test {
    public static void main(String[] args) {
        //47-1
        //자바 타입 추론의 한계로 컴파일되지 않는다.
        //284P
//        for(ProcessHandle ph : ProcessHandle.allProcesses()::iterator) {
//            //프로세스 처리
//        }

        //47-2
        //스트림을 반복하기 위한 끔찍한 우회 방법
        //285P
        for(ProcessHandle ph : (Iterable<ProcessHandle>) ProcessHandle.allProcesses()::iterator) {
            System.out.println(ph);
        }

        for(ProcessHandle ph : iterableOf(ProcessHandle.allProcesses())) {
            System.out.println(ph);
        }

        streamOf(iterableOf(ProcessHandle.allProcesses())).forEach(System.out::println);
    }

    //47-3
    //Stream<E>를 Iterable<E>로 중개해주는 어댑터
    //285P
    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }

    //47-4
    //Iterable<E>를 Stream<E>로 중개해주는 어댑터
    //286P
    public static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
