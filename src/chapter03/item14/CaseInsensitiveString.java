package chapter03.item14;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

//14-1
//객체 참조 필드가 하나뿐인 비교자
//90P
public final class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    //자바가 제공하는 비교자를 사용해 클래스를 비교한다.
    public int compareTo(CaseInsensitiveString cis) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
    }

    @Override
    public String toString() {
        return "CaseInsensitiveString{" +
                "s='" + s + '\'' +
                '}';
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis1 = new CaseInsensitiveString("Hello");
        CaseInsensitiveString cis2 = new CaseInsensitiveString("hello");
        CaseInsensitiveString cis3 = new CaseInsensitiveString("world");

        System.out.println(cis1.compareTo(cis2));
        System.out.println(cis1.compareTo(cis3));
        System.out.println(cis3.compareTo(cis1));

        Set<CaseInsensitiveString> s = new TreeSet<>();
        s.add(cis1);
        s.add(cis2);
        s.add(cis3);
        System.out.println(s);
    }
}