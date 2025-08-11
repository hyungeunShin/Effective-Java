package chapter06.item34;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

//34-6
//상수별 클래스 몸체(class body)와 데이터를 사용한 열거 타입
//215P
public enum OperationV3 {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    }
    , MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    }
    , TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    }
    , DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    OperationV3(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract double apply(double x, double y);

    //34-7
    //열거 타입용 fromString 메서드 구현하기
    //216P
    private static final Map<String, OperationV3> stringToEnum = Stream.of(values()).collect(toMap(Object::toString, e -> e));

    //지정한 문자열에 해당하는 Operation을 (존재한다면) 반환한다.
    public static Optional<OperationV3> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public static void main(String[] args) {
        double x = Double.parseDouble("2");
        double y = Double.parseDouble("1");
        for(OperationV3 op : OperationV3.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }

        System.out.println(fromString("+").orElseThrow());
        System.out.println(fromString("++").orElseThrow());
    }
}