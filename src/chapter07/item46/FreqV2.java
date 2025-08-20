package chapter07.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//46-2
//스트림을 제대로 활용해 빈도표를 초기화한다.
//278P
public class FreqV2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("temp/word2.txt");

        Map<String, Long> freq;
        try(Stream<String> words = new Scanner(file).tokens()) {
            freq = words.collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        }

        System.out.println(freq);
    }
}
