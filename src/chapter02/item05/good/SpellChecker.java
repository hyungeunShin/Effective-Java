package chapter02.item05.good;

import chapter02.item05.Lexicon;

import java.util.List;
import java.util.Objects;

//5-3
//의존 객체 주입은 유연성과 테스트 용이성을 높여준다.
//29P
public class SpellChecker {
    private final Lexicon dictionary;

    //생성자를 통한 의존성 주입
    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return dictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        return dictionary.suggest(typo);
    }
}