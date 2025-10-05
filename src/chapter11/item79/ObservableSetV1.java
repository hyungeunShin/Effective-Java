package chapter11.item79;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

//79-1
//잘못된 코드 - 동기화 블록 안에서 외계인 메서드를 호출한다.
//420P ~ 421P
public class ObservableSetV1<E> extends ForwardingSet<E> implements ObservableSet<E> {
    public ObservableSetV1(Set<E> s) {
        super(s);
    }

    private final List<SetObserver<E>> observers = new ArrayList<>();

    @Override
    public void addObserver(SetObserver<E> observer) {
        synchronized(observers) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(SetObserver<E> observer) {
        synchronized(observers) {
            observers.remove(observer);
        }
    }

    private void notifyElementAdded(E element) {
        synchronized(observers) {
            for(SetObserver<E> observer : observers) {
                observer.added(this, element);
            }
        }
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if(added) {
            notifyElementAdded(element);
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for(E element : c) {
            result |= add(element);
        }
        return result;
    }
}
