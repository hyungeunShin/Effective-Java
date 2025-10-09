package chapter12.item88;

import java.util.Calendar;
import java.util.Date;

import chapter12.Util;

//88-2
//허용되지 않는 Period 인스턴스를 생성할 수 있다.
//468P ~ 469P
public class BogusPeriod {
    //진짜 Period 인스턴스에서는 만들어질 수 없는 바이트 스트림
    private static final byte[] serializedForm = {
        (byte)0xac, (byte)0xed, (byte)0x00, (byte)0x05, (byte)0x73, (byte)0x72, (byte)0x00, (byte)0x17, (byte)0x63, (byte)0x68, 
        (byte)0x61, (byte)0x70, (byte)0x74, (byte)0x65, (byte)0x72, (byte)0x31, (byte)0x32, (byte)0x2e, (byte)0x69, (byte)0x74, 
        (byte)0x65, (byte)0x6d, (byte)0x38, (byte)0x38, (byte)0x2e, (byte)0x50, (byte)0x65, (byte)0x72, (byte)0x69, (byte)0x6f, 
        (byte)0x64, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x02, 
        (byte)0x00, (byte)0x02, (byte)0x4c, (byte)0x00, (byte)0x03, (byte)0x65, (byte)0x6e, (byte)0x64, (byte)0x74, (byte)0x00, 
        (byte)0x10, (byte)0x4c, (byte)0x6a, (byte)0x61, (byte)0x76, (byte)0x61, (byte)0x2f, (byte)0x75, (byte)0x74, (byte)0x69, 
        (byte)0x6c, (byte)0x2f, (byte)0x44, (byte)0x61, (byte)0x74, (byte)0x65, (byte)0x3b, (byte)0x4c, (byte)0x00, (byte)0x05, 
        (byte)0x73, (byte)0x74, (byte)0x61, (byte)0x72, (byte)0x74, (byte)0x71, (byte)0x00, (byte)0x7e, (byte)0x00, (byte)0x01, 
        (byte)0x78, (byte)0x70, (byte)0x73, (byte)0x72, (byte)0x00, (byte)0x0e, (byte)0x6a, (byte)0x61, (byte)0x76, (byte)0x61, 
        (byte)0x2e, (byte)0x75, (byte)0x74, (byte)0x69, (byte)0x6c, (byte)0x2e, (byte)0x44, (byte)0x61, (byte)0x74, (byte)0x65, 
        (byte)0x68, (byte)0x6a, (byte)0x81, (byte)0x01, (byte)0x4b, (byte)0x59, (byte)0x74, (byte)0x19, (byte)0x03, (byte)0x00, 
        (byte)0x00, (byte)0x78, (byte)0x70, (byte)0x77, (byte)0x08, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x8c, (byte)0xc4, 
        (byte)0x0a, (byte)0xef, (byte)0x2b, (byte)0x78, (byte)0x73, (byte)0x71, (byte)0x00, (byte)0x7e, (byte)0x00, (byte)0x03, 
        (byte)0x77, (byte)0x08, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x94, (byte)0x20, (byte)0xe2, (byte)0x77, (byte)0x2b, 
        (byte)0x78
    };

    public static void main(String[] args) {
//        Calendar cal = Calendar.getInstance();
//
//        cal.set(2025, Calendar.JANUARY, 1);
//        Date start = cal.getTime();
//
//        cal.set(2024, Calendar.JANUARY, 1);
//        Date end = cal.getTime();
//
//        Period period = new Period(start, end);
//        byte[] bytes = Util.serialize(period);
//        StringBuilder sb = new StringBuilder();
//        sb.append("{\n    ");
//        for(int i = 0; i < bytes.length; i++) {
//            sb.append(String.format("(byte)0x%02x", bytes[i]));
//            if(i != bytes.length - 1) sb.append(", ");
//            if((i + 1) % 10 == 0) sb.append("\n    ");
//        }
//        sb.append("\n}");
//        System.out.println(sb.toString());

        Period p = (Period) Util.deserialize(serializedForm);
        System.out.println(p);
    }
}
