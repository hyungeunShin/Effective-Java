package chapter06.item36;

//36-1
//비트 필드 열거 상수 - 구닥다리 기법!
//223P
public class TextV1 {
    public static final int STYLE_BOLD = 1 << 0;
    public static final int STYLE_ITALIC = 1 << 1;
    public static final int STYLE_UNDERLINE = 1 << 2;
    public static final int STYLE_STRIKETHROUGH = 1 << 3;

    public void applyStyles(int styles) {
        System.out.print("Applying styles: ");
        if((styles & STYLE_BOLD) != 0) System.out.print("BOLD ");
        if((styles & STYLE_ITALIC) != 0) System.out.print("ITALIC ");
        if((styles & STYLE_UNDERLINE) != 0) System.out.print("UNDERLINE ");
        if((styles & STYLE_STRIKETHROUGH) != 0) System.out.print("STRIKETHROUGH ");
        System.out.println();
    }

    public static void main(String[] args) {
        TextV1 text = new TextV1();
        int styles = STYLE_BOLD | STYLE_ITALIC;
        text.applyStyles(styles);
    }
}