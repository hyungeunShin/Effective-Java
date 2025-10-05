package chapter11.item79;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ObservableSetV2<E> extends ForwardingSet<E> implements ObservableSet<E> {
    public ObservableSetV2(Set<E> s) {
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

    //79-3
    //외계인 메서드를 동기화 블록 바깥으로 옮겼다.
    //424P
    private void notifyElementAdded(E element) {
        List<SetObserver<E>> snapshot = null;
        synchronized(observers) {
            snapshot = new ArrayList<>(observers);
        }
        for(SetObserver<E> observer : snapshot) {
            observer.added(this, element);
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
