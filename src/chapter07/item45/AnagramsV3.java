package chapter07.item45;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//45-3
//스트림을 적절히 활용하면 깔끔하고 명료해진다.
//271P
public class AnagramsV3 {
    public static void main(String[] args) throws IOException {
        Path dictionary = Paths.get("temp/word.txt");
        int minGroupSize = 3;

        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(Collectors.groupingBy(AnagramsV3::alphabetize))
                 .values().stream()
                 .filter(group -> group.size() >= minGroupSize)
                 .forEach(g -> System.out.println(g.size() + ": " + g));
        }
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}