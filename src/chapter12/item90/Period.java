package chapter12.item90;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public class Period implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Date start;
    private final Date end;

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

    //90-1
    //Period 클래스용 직렬화 프록시
    //479P ~ 480P
    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;

        SerializationProxy(Period p) {
            this.start = p.start;
            this.end = p.end;
        }

        //아무 값이나 상관없다. (아이템 87)
        private static final long serialVersionUID = 234098243823485285L;

        private Object readResolve() {
            System.out.println("SerializationProxy.readResolve");
            return new Period(start, end);
        }
    }

    //직렬화 프록시 패턴용 writeReplace 메서드
    private Object writeReplace() {
        System.out.println("writeReplace");
        return new SerializationProxy(this);
    }

    //직렬화 프록시 패턴용 readObject 메서드
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        System.out.println("readObject");
        throw new InvalidObjectException("프록시가 필요합니다.");
    }
}
