package chapter08.item54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheeseStorage {
    private final List<Cheese> cheesesInStock = new ArrayList<>();

    //54-1
    //컬렉션이 비었으면 null을 반환한다. - 따라 하지 말 것!
    //323P
    public List<Cheese> getCheesesV1() {
        return cheesesInStock.isEmpty() ? null : new ArrayList<>(cheesesInStock);
    }

    //54-2
    //빈 컬렉션을 반환하는 올바른 예
    //324P
    public List<Cheese> getCheesesV2() {
        return new ArrayList<>(cheesesInStock);
    }

    //54-3
    //최적화 - 빈 컬렉션을 매번 새로 할당하지 않도록 했다.
    //324P
    public List<Cheese> getCheesesV3() {
        return cheesesInStock.isEmpty() ? Collections.emptyList() : new ArrayList<>(cheesesInStock);
    }

    //54-4
    //길이가 0일 수도 있는 배열을 반환하는 올바른 방법
    //324P
    public Cheese[] getCheesesToArrayV1() {
        return cheesesInStock.toArray(new Cheese[0]);
    }

    //54-5
    //최적화 - 빈 배열을 매번 새로 할당하지 않도록 했다.
    //325P
    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];
    public Cheese[] getCheesesToArrayV2() {
        return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
    }
}
