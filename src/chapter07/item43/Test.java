package chapter07.item43;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        List<String> list = List.of("1", "1", "2", "2", "3");
        Map<String, Integer> frequencyTable = new TreeMap<>();

        for(String s : list) {
            frequencyTable.merge(s, 1, (count, incr) -> count + incr);
        }
        System.out.println(frequencyTable);

        frequencyTable.clear();
        for(String s : list) {
            frequencyTable.merge(s, 1, Integer::sum);
        }
        System.out.println(frequencyTable);

    }
}
