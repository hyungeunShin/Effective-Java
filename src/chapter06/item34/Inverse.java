package chapter06.item34;

//34-10
//switch 문을 이용해 원래 열거 타입에 없는 기능을 수행한다.
//219P
public class Inverse {
    public static OperationV3 inverse(OperationV3 op) {
        switch(op) {
            case PLUS:   return OperationV3.MINUS;
            case MINUS:  return OperationV3.PLUS;
            case TIMES:  return OperationV3.DIVIDE;
            case DIVIDE: return OperationV3.TIMES;

            default: throw new AssertionError("알 수 없는 연산: " + op);
        }
    }

    public static void main(String[] args) {
        double x = Double.parseDouble("2");
        double y = Double.parseDouble("1");
        for(OperationV3 op : OperationV3.values()) {
            OperationV3 invOp = inverse(op);
            System.out.printf("%f %s %f %s %f = %f%n", x, op, y, invOp, y, invOp.apply(op.apply(x, y), y));
        }
    }
}