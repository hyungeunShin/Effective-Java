package chapter06.item37;

import java.util.*;
import java.util.stream.Collectors;

class Plant {
    enum LifeCycle {
        ANNUAL, PERENNIAL, BIENNIAL
    }

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Plant[] garden = {
            new Plant("바질", LifeCycle.ANNUAL),
            new Plant("캐러웨이", LifeCycle.BIENNIAL),
            new Plant("딜", LifeCycle.ANNUAL),
            new Plant("라벤더", LifeCycle.PERENNIAL),
            new Plant("파슬리", LifeCycle.BIENNIAL),
            new Plant("로즈마리", LifeCycle.PERENNIAL)
        };

        //37-1
        //ordinal()을 배열 인덱스로 사용 - 따라 하지 말 것!
        //226P
//        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
//        for(int i = 0; i < plantsByLifeCycle.length; i++) {
//            plantsByLifeCycle[i] = new HashSet<>();
//        }
//
//        for(Plant p : garden) {
//            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
//        }
//
//        for(int i = 0; i < plantsByLifeCycle.length; i++) {
//            System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
//        }

        //37-2
        //EnumMap을 사용해 데이터와 열거 타입을 매핑한다.
        //227P
        Map<LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        for(Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }

        for(Plant p : garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }

        System.out.println(plantsByLifeCycle);

        //37-3
        //스트림을 사용한 코드 1 - EnumMap을 사용하지 않는다!
        //228P
        Map<LifeCycle, List<Plant>> map = Arrays.stream(garden).collect(Collectors.groupingBy(p -> p.lifeCycle));
        System.out.println(map);

        //37-4
        //스트림을 사용한 코드 2 - EnumMap을 이용해 데이터와 열거 타입을 매핑했다.
        //228P
        EnumMap<LifeCycle, Set<Plant>> enumMap = Arrays.stream(garden)
                                                       .collect(
                                                           Collectors.groupingBy(
                                                               p -> p.lifeCycle,
                                                               () -> new EnumMap<>(LifeCycle.class),
                                                               Collectors.toSet()
                                                           )
                                                       );
        System.out.println(enumMap);
    }
}