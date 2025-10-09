package chapter12.item88;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

//88-1
//방어적 복사를 사용하는 불변 클래스
//467P
public class Period implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date start;
    private Date end;

    /**
     * @param  start    시작 시각
     * @param  end      종료 시각. 시작 시각보다 뒤여야 한다.
     * @throws IllegalArgumentException 시작 시각이 종료 시각보다 늦을 때 발생한다.
     * @throws NullPointerException     start나 end가 null이면 발생한다.
     */
    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if(this.start.compareTo(this.end) > 0) {
            throw  new IllegalArgumentException(this.start + "가 " + this.end + "보다 늦다.");
        }
    }

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    public String toString() {
        return start + " - " + end;
    }

    //88-3
    //유효성 검사를 수행하는 readObject 메서드 - 아직 부족하다!
    //469P
//    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
//        s.defaultReadObject();
//
//        //불변식을 만족하는지 검사한다.
//        if(this.start.compareTo(this.end) > 0) {
//            throw new InvalidObjectException(this.start + "가 " + this.end + "보다 늦다.");
//        }
//    }

    //88-5
    //방어적 복사와 유효성 검사를 수행하는 readObject 메서드
    //472P
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();

        //가변 요소들을 방어적으로 복사한다.
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        //불변식을 만족하는지 검사한다.
        if(this.start.compareTo(this.end) > 0) {
            throw new InvalidObjectException(this.start + "가 " + this.end + "보다 늦다.");
        }
    }
}
