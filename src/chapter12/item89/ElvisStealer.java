package chapter12.item89;

import java.io.Serializable;

//89-2
//도둑 클래스
//476P
public class ElvisStealer implements Serializable {
    static ElvisV1 impersonator;
    private ElvisV1 payload;

    private Object readResolve() {
        //resolve되기 전의 Elvis 인스턴스의 참조를 저장한다.
        System.out.println("ElvisStealer readResolve 호출");
        impersonator = payload;
        
        //favoriteSongs 필드에 맞는 타입의 객체를 반환한다.
        return new String[] {"A Fool Such as I"};
    }

    private static final long serialVersionUID = 0;

    public void setPayload(ElvisV1 payload) {
        this.payload = payload;
    }
}
