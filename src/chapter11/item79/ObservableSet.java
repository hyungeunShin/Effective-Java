package chapter11.item79;

public interface ObservableSet<E> {
    void addObserver(SetObserver<E> observer);
    void removeObserver(SetObserver<E> observer);
}