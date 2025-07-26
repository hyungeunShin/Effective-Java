package chapter02.item06;

//6-1
//내부에서 만드는 정규표현식용 Pattern 인스턴스는, 한 번 쓰고 버려져서 곧바로 가비지 컬렉션 대상이 된다.
//32P
public class RomanNumeralsV1 {
    static boolean isRomanNumeralSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    public static void main(String[] args) {
        boolean b = false;

        for(int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            for(int j = 0; j < 1000; j++) {
                b ^= isRomanNumeralSlow("MCMLXXVI");
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