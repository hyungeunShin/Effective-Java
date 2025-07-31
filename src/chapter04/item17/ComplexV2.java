package chapter04.item17;

//17-2
//생성자 대신 정적 팩터리를 사용한 불변 클래스
//110P ~ 1111P
public final class ComplexV2 {
    private final double re;
    private final double im;

    private ComplexV2(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static ComplexV2 valueOf(double re, double im) {
        return new ComplexV2(re, im);
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public ComplexV2 plus(ComplexV2 c) {
        return new ComplexV2(re + c.re, im + c.im);
    }

    public ComplexV2 minus(ComplexV2 c) {
        return new ComplexV2(re - c.re, im - c.im);
    }

    public ComplexV2 times(ComplexV2 c) {
        return new ComplexV2(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public ComplexV2 dividedBy(ComplexV2 c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new ComplexV2((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }

        if(!(o instanceof ComplexV2)) {
            return false;
        }

        ComplexV2 c = (ComplexV2) o;

        //63P 참고
        return Double.compare(c.re, re) == 0 && Double.compare(c.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}