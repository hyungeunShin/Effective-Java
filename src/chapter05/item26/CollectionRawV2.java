package chapter05.item26;

import java.util.ArrayList;
import java.util.Collection;

//26-3
//매개변수화된 컬렉션 타입 - 타입 안전성 확보!
//155P
public class CollectionRawV2 {
    private final Collection<Stamp> stamps = new ArrayList<>();

    public Collection<Stamp> getStamps() {
        return stamps;
    }

    public static void main(String[] args) {
        CollectionRawV2 collectionRaw = new CollectionRawV2();

        Collection<Stamp> stamps = collectionRaw.getStamps();
        //stamps.add(new Coin());
    }
}
