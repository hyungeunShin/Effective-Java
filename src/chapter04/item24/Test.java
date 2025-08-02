package chapter04.item24;

public class Test {
    public static void main(String[] args) {
        OuterV1 outer1 = new OuterV1();
        OuterV1.Inner inner1 = outer1.new Inner();  //Outer 인스턴스 필요
        inner1.print();

        OuterV2.Inner inner2 = new OuterV2.Inner();  //Outer 인스턴스 없이 바로 생성 가능
        inner2.print();
    }
}
