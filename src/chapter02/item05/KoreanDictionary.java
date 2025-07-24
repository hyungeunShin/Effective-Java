package chapter02.item05;

import java.util.*;

public class KoreanDictionary implements Lexicon {
    private static final Set<String> words;

    static {
        Set<String> temp = new HashSet<>();
        temp.add("자바");
        temp.add("파이썬");
        temp.add("인공지능");
        words = Collections.unmodifiableSet(temp);
    }

    @Override
    public boolean contains(String word) {
        return words.contains(word);
    }

    @Override
    public List<String> suggest(String typo) {
        List<String> suggestions = new ArrayList<>();
        for(String word : words) {
            if(word.startsWith(typo.substring(0, 1))) {
                suggestions.add(word);
            }
        }
        return suggestions;
    }
}