package chapter07.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

//46-1
//스트림 패러다임을 이해하지 못한 채 API만 사용했다 - 따라 하지 말 것!
//277P
public class FreqV1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("temp/word2.txt");

        Map<String, Long> freq = new HashMap<>();
        try(Stream<String> words = new Scanner(file).tokens()) {
            words.forEach(word -> freq.merge(word.toLowerCase(), 1L, Long::sum));
        }

        System.out.println(freq);
    }
}
