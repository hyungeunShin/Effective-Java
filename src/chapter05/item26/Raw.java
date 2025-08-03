package chapter05.item26;

import java.util.ArrayList;
import java.util.List;

//26-4
//런타임에 실패한다. - unsafeAdd 메서드가 로 타입(List)을 사용
//156P ~ 157P
public class Raw {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0);  //컴파일러가 자동으로 형변환 코드를 넣어준다.
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}