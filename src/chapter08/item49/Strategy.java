package chapter08.item49;

import java.util.Objects;

public class Strategy {
    private final String strategy;

    public Strategy(String strategy) {
        //49-1
        //자바의 null 검사 기능 사용하기
        //299P
        this.strategy = Objects.requireNonNull(strategy, "전략");
    }
}
