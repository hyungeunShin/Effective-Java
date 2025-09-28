package chapter10.item73;

public class Item73 {
    public static void main(String[] args) throws HigherException {
        //73-1
        //예외 번역
        //399P
        try {
            doSomething(); //저수준 추상화를 이용한다.
        } catch(LowerException e) {
            //추상화 수준에 맞게 번역한다.
            throw new HigherException();
        }

        //73-2
        //예외 연쇄
        //400P
        try {
            doSomething(); //저수준 추상화를 이용한다.
        } catch(LowerException cause) {
            //저수준 예외를 고수준 에외에 실어 보낸다.
            throw new HigherException(cause);
        }
    }

    static void doSomething() throws LowerException {
        throw new LowerException();
    }
}