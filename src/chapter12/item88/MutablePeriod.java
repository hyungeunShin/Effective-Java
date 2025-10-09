package chapter12.item88;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;

//88-4
//가변 공격의 예
//470P ~ 471P
public class MutablePeriod {
    public final Period period;

    //시작 시각 필드 - 외부에서 접근할 수 없어야 한다.
    public final Date start;

    //종료 시각 필드 - 외부에서 접근할 수 없어야 한다.
    public final Date end;

    public MutablePeriod() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);

            //유효한 Period 인스턴스를 직렬화한다.
            out.writeObject(new Period(new Date(), new Date()));

            /*
             * 악의적인 '이전 객체 참조', 즉 내부 Date 필드로의 참조를 추가한다.
             * 상세 내용은 자바 객체 직렬화 명세의 6.4절을 참고하자
             */
            byte[] ref = {0x71, 0, 0x7e, 0, 5};
            bos.write(ref);
            ref[4] = 4;
            bos.write(ref);

            //Period 역직렬화 후 Date 참조를 훔친다.
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            period = (Period) ois.readObject();
            start = (Date) ois.readObject();
            end = (Date) ois.readObject();
        } catch(IOException | ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        MutablePeriod mp = new MutablePeriod();
        Period p = mp.period;
        Date pEnd = mp.end;

        Calendar cal = Calendar.getInstance();
        cal.setTime(pEnd);

        cal.set(Calendar.YEAR, 1978);
        pEnd.setTime(cal.getTimeInMillis());
        System.out.println(p);

        cal.set(Calendar.YEAR, 1969);
        pEnd.setTime(cal.getTimeInMillis());
        System.out.println(p);
    }
}
