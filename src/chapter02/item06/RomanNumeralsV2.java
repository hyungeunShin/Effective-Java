package chapter02.item06;

import java.util.regex.Pattern;

//6-2
//값비싼 객체를 재사용해 성능을 개선한다.
//32P
public class RomanNumeralsV2 {
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        boolean b = false;

        for(int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            for(int j = 0; j < 1000; j++) {
                //6배정도 빨라짐
                b ^= isRomanNumeralFast("MCMLXXVI");
            }
            long end = System.currentTimeMillis();
            System.out.println((end - start) + "ms");
        }

        //VM이 최적화하지 못하게 막는 코드
        if(!b) {
            System.out.println();
        }
    }
}