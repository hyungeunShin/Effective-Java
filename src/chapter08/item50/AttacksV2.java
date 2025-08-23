package chapter08.item50;

import java.util.Date;

public class AttacksV2 {
    public static void main(String[] args) {
        // 코드 50-4 Period 인스턴스를 향한 두 번째 공격 (305쪽)
        Date start = new Date();
        Date end = new Date();
        PeriodV2 p = new PeriodV2(start, end);
        p.end().setYear(78);  //p의 내부를 변경했다!
        System.out.println(p);
    }
}