package chapter05.item28;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //28-1
        //런타임에 실패한다.
        //164P
        Object[] objectArr = new Long[1];
        //objectArr[0] = "타입이 달라 넣을 수 없다."; //ArrayStoreException

        //28-2
        //컴파일되지 않는다.
        //164P
        //List<Object> ol = new ArrayList<Long>(); //호환되지 않는 타입이다.

        //28-3
        //제네릭 배열 생성을 허용하지 않는 이유 - 컴파일 되지 않는다.
        //165P
        //List<String>[] stringLists = new List<String>[1];
        //List<Integer> intList = List.of(42);
        //Object[] objects = stringLists;
        //objects[0] = intList;
        //String s = stringLists[0].get(0);
    }
}
