package chapter05.item28;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//28-4
//제네릭을 시급히 적용해야 한다!
//167P
public class ChooserV1 {
    private final Object[] choiceArray;

    public ChooserV1(Object[] choiceArray) {
        this.choiceArray = choiceArray;
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}