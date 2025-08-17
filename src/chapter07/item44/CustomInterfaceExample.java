package chapter07.item44;

import java.util.LinkedHashMap;
import java.util.Map;

@FunctionalInterface
interface EldestEntryRemovalFunction<K, V> {
    boolean remove(Map<K, V> map, Map.Entry<K, V> eldest);
}

class CustomCache<K, V> extends LinkedHashMap<K, V> {
    private final EldestEntryRemovalFunction<K, V> remover;

    public CustomCache(int capacity, EldestEntryRemovalFunction<K, V> remover) {
        super(capacity, 0.75f, true);
        this.remover = remover;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return remover.remove(this, eldest);
    }
}

public class CustomInterfaceExample {
    public static void main(String[] args) {
        CustomCache<Integer, String> cache = new CustomCache<>(3, (map, eldest) -> map.size() > 3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.put(4, "D");

        System.out.println("Custom 인터페이스 결과: " + cache);
    }
}