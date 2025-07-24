package chapter02.item04;

//인스턴스를 만들 수 없는 유틸리티 클래스
//26P ~ 27P
public class UtilityClass {
    //기본 생성자가 만들어지는 것을 막는다(인스턴스화 방지용)
    private UtilityClass() {
        throw new AssertionError();
    }
}