package chapter09.Item58;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

public class DiceRolls {
    enum Face { ONE, TWO, THREE, FOUR, FIVE, SIX }

    public static void main(String[] args) {
        Collection<Face> faces = EnumSet.allOf(Face.class);

        //58-5
        //58-4와 같은 버그, 다른 증상! - 예외를 던지진 않지만, 기대했던 결과는 36가지의 조합이지만 6가지만 출력하고 끝나버린다.
        //349P
        for(Iterator<Face> i = faces.iterator(); i.hasNext();) {
            for(Iterator<Face> j = faces.iterator(); j.hasNext();) {
                System.out.println(i.next() + " " + j.next());
            }
        }
    }
}