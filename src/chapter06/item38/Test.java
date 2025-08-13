package chapter06.item38;

import java.util.Arrays;
import java.util.Collection;

public class Test {
    public static void main(String[] args) {
        double x = Double.parseDouble("1");
        double y = Double.parseDouble("2");
        test(ExtendedOperation.class, x, y);
        test(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
        for(Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    private static void test(Collection<? extends Operation> opSet, double x, double y) {
        for(Operation op : opSet) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
