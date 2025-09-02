package chapter09.item62;

//62-4
//리팩터링하여 Key를 ThreadLocal로 변경
//364P
public final class ThreadLocalV3 {
    private final ThreadLocal threadLocal;

    public ThreadLocalV3() {
        this.threadLocal = new ThreadLocal();
    }

    public void set(Object value) {
        threadLocal.set(value);
    }

    public Object get() {
        return threadLocal.get();
    }
}
