package chapter03.item13;

//13-4
//복잡한 가변 상태를 갖는 클래스용 재귀적 clone 메서드
//82P ~ 83P
public class HashTableV2 implements Cloneable {
    private Entry[] buckets = new Entry[10];

    @Override
    public HashTableV2 clone() {
        try {
            HashTableV2 result = (HashTableV2) super.clone();
            result.buckets = new Entry[buckets.length];
            for(int i = 0; i < buckets.length; i++) {
                if(buckets[i] != null) {
                    result.buckets[i] = buckets[i].deepCopy();
                }
            }
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

        //이 엔트리가 가리키는 연결 리스트를 재귀적으로 복사
        //깊은 복사
        //리스트가 길면 스택 오버플로를 일으킬 위험이 존재
//        Entry deepCopy() {
//            return new Entry(key, value, next == null ? null : next.deepCopy());
//        }

        //13-5
        //엔트리 자신이 가리키는 연결 리스트를 반복적으로 복사
        //83P
        Entry deepCopy() {
            Entry result = new Entry(key, value, next);
            for(Entry p = result; p.next != null; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }
            return result;
        }

        @Override
        public String toString() {
            return key + "=" + value + (next != null ? " -> " + next : "");
        }
    }

    public static void main(String[] args) {
        HashTableV2 original = new HashTableV2();
        original.buckets[0] = new Entry("one", 1, new Entry("two", 2, null));

        HashTableV2 clone = original.clone();

        System.out.println(original.buckets[0]);
        System.out.println(clone.buckets[0]);

        System.out.println(original.buckets != clone.buckets);
        System.out.println(original.buckets[0] != clone.buckets[0]);
        System.out.println(original.buckets[0].next != clone.buckets[0].next);
    }
}
