package chapter09.item62;

import java.util.Map;
import java.util.HashMap;

//62-3
//Key 클래스로 권한을 구분했다.
//363P ~ 364P
public class ThreadLocalV2 {
    private static final ThreadLocal<Map<Key, Object>> threadLocalMap = ThreadLocal.withInitial(HashMap::new);

    //객체 생성 불가
    private ThreadLocalV2() {

    }

    public static class Key {
        Key() {

        }
    }

    //위조 불가능한 고유 키를 생성한다.
    public static Key getKey() {
        return new Key();
    }

    public static void set(Key key, Object value) {
        threadLocalMap.get().put(key, value);
    }

    public static Object get(Key key) {
        return threadLocalMap.get().get(key);
    }
}
