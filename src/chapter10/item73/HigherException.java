package chapter10.item73;

public class HigherException extends Exception {
    public HigherException() {

    }

    //73-3
    //예외 연쇄용 생성자
    //400P
    public HigherException(Throwable cause) {
        super(cause);
    }
}