package chapter03.item10;

import java.util.Objects;

//10-1
//잘못된 코드 - 대칭성 위배!
//54P ~ 55P
public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    //대칭성 위배!
//    @Override
//    public boolean equals(Object o) {
//        if(o instanceof CaseInsensitiveString) {
//            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
//        }
//
//        //한 방향으로만 작동한다!
//        if(o instanceof String) {
//            return s.equalsIgnoreCase((String) o);
//        }
//
//        return false;
//    }

    //수정한 equals 메서드 - 56P
    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        //대칭성 위배
        System.out.println(cis.equals(s) + " " + s.equals(cis));

        CaseInsensitiveString cis2 = new CaseInsensitiveString(s);
        System.out.println(cis.equals(cis2));
    }
}