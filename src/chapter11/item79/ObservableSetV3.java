package chapter11.item79;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObservableSetV3<E> extends ForwardingSet<E> implements ObservableSet<E> {
    public ObservableSetV3(Set<E> s) {
        super(s);
    }

    private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<>();

    @Override
    public void addObserver(SetObserver<E> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(SetObserver<E> observer) {
        observers.remove(observer);
    }

    private void notifyElementAdded(E element) {
        for(SetObserver<E> observer : observers) {
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
