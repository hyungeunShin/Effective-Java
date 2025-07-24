package chapter02.item05.badsingleton;

import chapter02.item05.KoreanDictionary;
import chapter02.item05.Lexicon;

import java.util.List;

public class SpellChecker {
    private final Lexicon dictionary = new KoreanDictionary();

    //싱글턴 인스턴스
    private static final SpellChecker INSTANCE = new SpellChecker();

    private SpellChecker() {

    }

    public static SpellChecker getInstance() {
        return INSTANCE;
    }

    public boolean isValid(String word) {
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        return dictionary.suggest(typo);
    }
}