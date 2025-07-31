package chapter04.item17;

//17-1
//불변 복소수 클래스
//106P ~ 107P
public final class ComplexV1 {
    private final double re;
    private final double im;

    public ComplexV1(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public ComplexV1 plus(ComplexV1 c) {
        return new ComplexV1(re + c.re, im + c.im);
    }

    public ComplexV1 minus(ComplexV1 c) {
        return new ComplexV1(re - c.re, im - c.im);
    }

    public ComplexV1 times(ComplexV1 c) {
        return new ComplexV1(re * c.re - im * c.im, re * c.im + im * c.re);
    }

    public ComplexV1 dividedBy(ComplexV1 c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new ComplexV1((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }

        if(!(o instanceof ComplexV1)) {
            return false;
        }

        ComplexV1 c = (ComplexV1) o;

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