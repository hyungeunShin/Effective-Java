package chapter04.item21;

public interface Printer {
    void print();

    default void duplexPrint() {
        print();
        print();
    }
}