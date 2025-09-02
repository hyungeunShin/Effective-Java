package chapter09.item62;

//62-5
//매개변수화하여 타입안전성 확보
//364P
public final class ThreadLocalV4<T> {
    private final ThreadLocal<T> threadLocal;

    public ThreadLocalV4() {
        this.threadLocal = new ThreadLocal<>();
    }

    public void set(T value) {
        threadLocal.set(value);
    }

    public Object get() {
        return threadLocal.get();
    }
}
