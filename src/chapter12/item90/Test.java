package chapter12.item90;

import chapter12.Util;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Period before = new Period(new Date(), new Date());
        System.out.println(before);
        byte[] bytes = Util.serialize(before);
        Period after = (Period) Util.deserialize(bytes);
        System.out.println(after);
    }
}
