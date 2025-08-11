package chapter06.item34;

//34-5
//상수별 메서드 구현을 활용한 열거 타입
//214P
public enum OperationV2 {
    PLUS {
        public double apply(double x, double y) {
            return x + y;
        }
    }
    , MINUS {
        public double apply(double x, double y) {
            return x - y;
        }
    }
    , TIMES {
        public double apply(double x, double y) {
            return x * y;
        }
    }
    , DIVIDE {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    public abstract double apply(double x, double y);

    public static void main(String[] args) {
        double x = Double.parseDouble("2");
        double y = Double.parseDouble("1");
        for(OperationV2 op : OperationV2.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}