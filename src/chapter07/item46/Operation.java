package chapter07.item46;

import java.util.Map;
import java.util.function.DoubleBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public enum Operation {
    PLUS("+", "덧셈", (x, y) -> x + y),
    MINUS("-", "뺄셈", (x, y) -> x - y),
    TIMES("*", "곱셈", (x, y) -> x * y),
    DIVIDE("/", "나눗셈", (x, y) -> x / y);

    private final String symbol;
    private final String korean;
    private final DoubleBinaryOperator op;

    Operation(String symbol, String korean, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.korean = korean;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }

    private static final Map<String, Operation> stringToEnum = Stream.of(values()).collect(Collectors.toMap(e -> e.korean, e -> e));

    public static void main(String[] args) {
        System.out.println(stringToEnum);
    }
}