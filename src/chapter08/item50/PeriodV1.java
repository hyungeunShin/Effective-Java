package chapter08.item50;

import java.util.Date;

//50-1
//기간을 표현하는 클래스 - 불변식을 지키지 못했다.
//302P ~ 303P
public final class PeriodV1 {
    private final Date start;
    private final Date end;

    /**
     * @param  start 시작 시각
     * @param  end 종료 시각. 시작 시각보다 뒤여야 한다.
     * @throws IllegalArgumentException 시작 시각이 종료 시각보다 늦을 때 발생한다.
     * @throws NullPointerException start나 end가 null이면 발생한다.
     */
    public PeriodV1(Date start, Date end) {
        if(start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + "가 " + end + "보다 늦다.");
        }

        this.start = start;
        this.end = end;
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }

    public String toString() {
        return start + " - " + end;
    }
}