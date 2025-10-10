package chapter12.item89;

import java.io.Serializable;
import java.util.Arrays;

//89-1
//잘못된 싱글턴 - transient가 아닌 참조 필드를 가지고 있다!
//476P
public class ElvisV1 implements Serializable {
    public static final ElvisV1 INSTANCE = new ElvisV1();

    private ElvisV1() {

    }

    private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }

    private Object readResolve() {
        System.out.println("ElvisV1 readResolve 호출");
        return INSTANCE;
    }
}
