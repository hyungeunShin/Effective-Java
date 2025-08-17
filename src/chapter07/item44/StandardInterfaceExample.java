package chapter07.item44;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;

class StandardCache<K, V> extends LinkedHashMap<K, V> {
    private final BiPredicate<Map<K, V>, Map.Entry<K, V>> remover;

    public StandardCache(int capacity, BiPredicate<Map<K, V>, Map.Entry<K, V>> remover) {
        super(capacity, 0.75f, true); // access-order = true
        this.remover = remover;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return remover.test(this, eldest);
    }
}

public class StandardInterfaceExample {
    public static void main(String[] args) {
        StandardCache<Integer, String> cache = new StandardCache<>(3, (map, eldest) -> map.size() > 3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.put(4, "D");

        System.out.println("표준 인터페이스 결과: " + cache);
    }
}