package chapter02.item05.badstatic;

import chapter02.item05.KoreanDictionary;
import chapter02.item05.Lexicon;

import java.util.List;

//5-1
//정적 유틸리티를 잘못 사용한 예 - 유연하지 않고 테스트하기 어렵다.
//28P
public class SpellChecker {
    //자원 직접 명시
    //사용하는 자원에 따라 동작이 달라지는 클래스에는 적합하지 않음
    private static final Lexicon dictionary = new KoreanDictionary();

    //객체 생성 방지
    private SpellChecker() {

    }

    public static boolean isValid(String word) {
        return dictionary.contains(word);
    }

    public static List<String> suggestions(String typo) {
        return dictionary.suggest(typo);
    }
}
