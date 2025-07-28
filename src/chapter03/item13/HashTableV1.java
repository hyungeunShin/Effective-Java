package chapter03.item13;

public class HashTableV1 implements Cloneable {
    private Entry[] buckets = new Entry[10];

    //13-3
    //잘못된 clone 메서드 - 가변 상태를 공유한다!
    //82P
    @Override
    public HashTableV1 clone() {
        try {
            HashTableV1 result = (HashTableV1) super.clone();
            result.buckets = buckets.clone();
            return result;
        } catch(CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        public Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return key + "=" + value + (next != null ? " -> " + next : "");
        }
    }

    public static void main(String[] args) {
        HashTableV1 original = new HashTableV1();
        original.buckets[0] = new Entry("one", 1, new Entry("two", 2, null));

        HashTableV1 clone = original.clone();

        System.out.println(original.buckets[0]);
        System.out.println(clone.buckets[0]);

        System.out.println(original.buckets != clone.buckets);
        System.out.println(original.buckets[0] != clone.buckets[0]);
        System.out.println(original.buckets[0].next != clone.buckets[0].next);
    }
}
