package chapter11.item81;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Intern {
    private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

    public static ConcurrentMap<String, String> getMap() {
        return map;
    }

    //81-1
    //ConcurrentMap으로 구현한 동시성 정규화 맵 - 최적은 아니다.
    //432P
    public static String internV1(String s) {
        String previousValue = map.putIfAbsent(s, s);
        return previousValue == null ? s : previousValue;
    }

    //81-2
    //ConcurrentMap으로 구현한 동시성 정규화 맵 - 더 빠르다!
    //432P
    public static String internV2(String s) {
        //ConcurrentHashMap은 get 같은 검색 기능에 최적화 되었다.
        //따라서 get을 먼저 호출하여 필요할 때만 putIfAbsent를 호출하면 더 빠르다.
        String result = map.get(s);
        if(result == null) {
            result = map.putIfAbsent(s, s);
            result = result == null ? s : result;
        }
        return result;
    }

    public static void main(String[] args) {
        int size = 100_000_000;
        String[] strings = new String[size];
        for(int i = 0; i < size; i++) {
            strings[i] = "str" + (i % 10_000);
        }

        map.clear();
        long startV1 = System.currentTimeMillis();
        for(String s : strings) {
            internV1(s);
        }
        long endV1 = System.currentTimeMillis();
        System.out.println("internV1 time: " + (endV1 - startV1) + " ms");

        map.clear();
        long startV2 = System.currentTimeMillis();
        for(String s : strings) {
            internV2(s);
        }
        long endV2 = System.currentTimeMillis();
        System.out.println("internV2 time: " + (endV2 - startV2) + " ms");
    }
}
