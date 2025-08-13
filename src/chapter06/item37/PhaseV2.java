package chapter06.item37;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

//37-6
//중첩 EnumMap으로 데이터와 열거 타입 쌍을 연결했다.
//229P ~ 230P
public enum PhaseV2 {
    SOLID, LIQUID, GAS, PLASMA;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID),
        IONIZE(GAS, PLASMA), DEIONIZE(PLASMA, GAS);

        private final PhaseV2 from;
        private final PhaseV2 to;

        Transition(PhaseV2 from, PhaseV2 to) {
            this.from = from;
            this.to = to;
        }

        //상전이 맵을 초기화한다.
        private static final Map<PhaseV2, Map<PhaseV2, Transition>> m = Stream.of(values())
                                                                              .collect(groupingBy(
                                                                                      t -> t.from,
                                                                                      () -> new EnumMap<>(PhaseV2.class),
                                                                                      toMap(
                                                                                          t -> t.to,
                                                                                          t -> t,
                                                                                          (x, y) -> y,
                                                                                          () -> new EnumMap<>(PhaseV2.class)
                                                                                      ))
                                                                              );
        
        public static Transition from(PhaseV2 from, PhaseV2 to) {
            return m.get(from).get(to);
        }
    }

    public static void main(String[] args) {
        for(PhaseV2 src : PhaseV2.values()) {
            for(PhaseV2 dst : PhaseV2.values()) {
                Transition transition = Transition.from(src, dst);
                if(transition != null) {
                    System.out.printf("%s에서 %s로 : %s %n", src, dst, transition);
                }
            }
        }
    }
}