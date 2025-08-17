package chapter07.item42;

import java.util.function.DoubleBinaryOperator;

//42-3
//상수별 클래스 몸체(class body)와 데이터를 사용한 열거 타입
//256P
public enum OperationV2 {
    PLUS("+", (x, y) -> x + y)
    , MINUS("-", (x, y) -> x - y)
    , TIMES("*", (x, y) -> x * y)
    , DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    OperationV2(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }

    public static void main(String[] args) {
        double x = Double.parseDouble("1");
        double y = Double.parseDouble("2");
        for(OperationV2 op : OperationV2.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}