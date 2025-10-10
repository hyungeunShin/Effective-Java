package chapter12.item89;

import java.util.Arrays;

//89-4
//열거 타입 싱글턴 - 전통적인 싱글턴보다 우수하다.
//478P
public enum ElvisV2 {
    INSTANCE;

    private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}
