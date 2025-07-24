package chapter02.item05;

import java.util.List;

public interface Lexicon {
    boolean contains(String word);
    List<String> suggest(String typo);
}