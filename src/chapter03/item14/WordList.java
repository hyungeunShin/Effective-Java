package chapter03.item14;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//87P
public class WordList {
    public static void main(String[] args) {
        List<String> list = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        Set<String> s = new TreeSet<>(list);
        System.out.println(s);
    }
}