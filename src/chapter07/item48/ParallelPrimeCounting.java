package chapter07.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class ParallelPrimeCounting {
    //47-2
    //소수 계산 스트림 파이프라인 - 병렬화에 적합하다.
    //295P
    static long piV1(long n) {
        return LongStream.rangeClosed(2, n)
                         .mapToObj(BigInteger::valueOf)
                         .filter(i -> i.isProbablePrime(50))
                         .count();
    }

    //48-3
    //소수 계산 스트림 파이프라인 - 병렬화 버전
    //295P
    static long piV2(long n) {
        return LongStream.rangeClosed(2, n)
                         .parallel()
                         .mapToObj(BigInteger::valueOf)
                         .filter(i -> i.isProbablePrime(50))
                         .count();
    }

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        System.out.println(piV1(10_000_000));
        long end1 = System.currentTimeMillis();
        System.out.println("piV1 time: " + (end1 - start1) + " ms");

        long start2 = System.currentTimeMillis();
        System.out.println(piV2(10_000_000));
        long end2 = System.currentTimeMillis();
        System.out.println("piV2 time: " + (end2 - start2) + " ms");
    }
}