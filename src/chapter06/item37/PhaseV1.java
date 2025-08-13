package chapter06.item37;

//37-5
//배열들의 배열의 인덱스에 ordinal()을 사용! - 따라 하지 말 것!
//228P ~ 229P
public enum PhaseV1 {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        public static final Transition[][] TRANSITIONS = {
                {null, MELT, SUBLIME},
                {FREEZE, null, BOIL},
                {DEPOSIT, CONDENSE, null}
        };

        public static Transition from(PhaseV1 from, PhaseV1 to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }

    public static void main(String[] args) {
        for(PhaseV1 src : PhaseV1.values()) {
            for(PhaseV1 dst : PhaseV1.values()) {
                Transition transition = Transition.from(src, dst);
                if(transition != null) {
                    System.out.printf("%s에서 %s로 : %s %n", src, dst, transition);
                }
            }
        }
    }
}