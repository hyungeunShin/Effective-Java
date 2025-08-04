package chapter05.item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//28-5
//제네릭으로 만들기 위한 첫 시도 - 컴파일되지 않는다.
//167P
public class ChooserV2<T> {
    private final T[] choiceArray;

    public ChooserV2(Collection<T> choices) {
        //컴파일 에러를 막기 위한 형변환
        this.choiceArray = (T[]) choices.toArray();
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}