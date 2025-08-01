package chapter04.item21;

public class DuplexPrinter implements Printer {
    @Override
    public void print() {
        System.out.println("일반 출력");
    }

    @Override
    public void duplexPrint() {
        System.out.println("양면 출력 실행");
    }
}