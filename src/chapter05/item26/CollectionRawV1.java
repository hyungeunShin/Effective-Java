package chapter05.item26;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//26-1
//컬렉션의 로 타입 - 따라 하지 말것!
//154P
public class CollectionRawV1 {
    //Stamp 인스턴스만 취급한다
    private final Collection stamps = new ArrayList();

    public Collection getStamps() {
        return stamps;
    }

    public static void main(String[] args) {
        CollectionRawV1 collectionRaw = new CollectionRawV1();
        //실수로 동전을 넣는다.
        //unchecked call 경고를 뱉는다.
        Collection stamps = collectionRaw.getStamps();
        stamps.add(new Coin());

        //26-2
        //반복자의 로 타입 - 따라 하지 말 것!
        //155P
        for(Iterator i = stamps.iterator(); i.hasNext();) {
            //ClassCastException
            Stamp stamp = (Stamp) i.next();
        }
    }
}
