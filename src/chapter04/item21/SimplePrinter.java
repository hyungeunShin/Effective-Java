package chapter04.item21;

public class SimplePrinter implements Printer {
    @Override
    public void print() {
        System.out.println("기본 프린터 출력");
    }

    //특정 클래스 관점에서 바라본 default 메서드는 특정 클래스에 해가 될 수 있다.
    //만약 어쩔 수 없이 default 메서드가 추가되었다면, 의도치 않은 동작을 막기 위해 해당 메서드를 오버라이딩해야한다.
    @Override
    public void duplexPrint() {
        throw new UnsupportedOperationException("이 프린터는 양면 인쇄를 지원하지 않습니다.");
    }
}