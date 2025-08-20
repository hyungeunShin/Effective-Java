package chapter07.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//46-3
//빈도표에서 가장 흔한 단어 10개를 뽑아내는 파이프라인
//279P
public class FreqV3 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("temp/word2.txt");

        Map<String, Long> freq;
        try(Stream<String> words = new Scanner(file).tokens()) {
            freq = words.collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        }

        List<String> topTen = freq.keySet().stream()
                                  .sorted(Comparator.comparing(freq::get).reversed())
                                  .limit(10)
                                  .collect(Collectors.toList());

        System.out.println(topTen);
    }
}
