package chapter08.item50;

import java.util.Date;

public class AttacksV1 {
    public static void main(String[] args) {
        //50-2
        //Period 인스턴스의 내부를 공격해보자.
        //303P
        Date start = new Date();
        Date end = new Date();
        PeriodV1 p = new PeriodV1(start, end);
        end.setYear(78);  //p의 내부를 변경했다!
        System.out.println(p);
    }
}