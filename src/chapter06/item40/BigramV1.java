package chapter06.item40;

import java.util.HashSet;
import java.util.Set;

//40-1
//영어 알파벳 2개로 구성된 문자열(바이그램)을 표현하는 클래스 - 버그를 찾아보자.
//246P
public class BigramV1 {
    private final char first;
    private final char second;

    public BigramV1(char first, char second) {
        this.first  = first;
        this.second = second;
    }

    public boolean equals(BigramV1 b) {
        return b.first == first && b.second == second;
    }

    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<BigramV1> s = new HashSet<>();
        for(int i = 0; i < 10; i++) {
            for(char ch = 'a'; ch <= 'z'; ch++) {
                s.add(new BigramV1(ch, ch));
            }
        }
        System.out.println(s.size());
    }
}