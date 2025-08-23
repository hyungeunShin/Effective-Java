package chapter08.item49;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        System.out.println(mod(new BigInteger("5")));
    }

    public static BigInteger mod(BigInteger m) {
        if(m.signum() <= 0) {
            throw new ArithmeticException("계수(m)는 양수여야 합니다. " + m);
        }
        return m.mod(m);
    }
}
