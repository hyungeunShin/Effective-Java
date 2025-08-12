package chapter06.item36;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

//36-2
//EnumSet - 비트 필드를 대체하는 현대적 기법
//224P
public class TextV2 {
    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    //어떤 Set을 넘겨도 되지만, EnumSet이 가장 좋다.
    public void applyStyles(Set<Style> styles) {
        System.out.print("Applying styles: ");
        Objects.requireNonNull(styles);

        if(styles.contains(Style.BOLD)) System.out.print("BOLD ");
        if(styles.contains(Style.ITALIC)) System.out.print("ITALIC ");
        if(styles.contains(Style.UNDERLINE)) System.out.print("UNDERLINE ");
        if(styles.contains(Style.STRIKETHROUGH)) System.out.print("STRIKETHROUGH ");

        System.out.println();
    }

    public static void main(String[] args) {
        TextV2 text = new TextV2();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}