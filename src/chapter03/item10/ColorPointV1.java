package chapter03.item10;

//56P
public class ColorPointV1 extends Point {
    private final Color color;

    public ColorPointV1(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    //10-2
    //잘못된 코드 - 대칭성 위배!
    //57P
//    @Override
//    public boolean equals(Object o) {
//        if(!(o instanceof ColorPoint)) {
//            return false;
//        }
//
//        return super.equals(o) && ((ColorPoint) o).color == color;
//    }

    //10-3
    //잘못된 코드 - 추이성 위배!
    //57P
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point)) {
            return false;
        }

        //o가 일반 Point면 색상을 무시하고 비교한다.
        if(!(o instanceof ColorPointV1)) {
            return o.equals(this);
        }

        //o가 ColorPoint면 색상까지 비교한다.
        return super.equals(o) && ((ColorPointV1) o).color == color;
    }

    public static void main(String[] args) {
        //첫 번째 equals 메서드(10-2)는 대칭성을 위배한다. (57P)
//        Point p = new Point(1, 2);
//        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
//        System.out.println(p.equals(cp) + " " + cp.equals(p));

        //두 번째 equals 메서드(10-3)는 추이성을 위배한다. (57P)
        ColorPointV1 p1 = new ColorPointV1(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPointV1 p3 = new ColorPointV1(1, 2, Color.BLUE);
        System.out.printf("%s %s %s%n", p1.equals(p2), p2.equals(p3), p1.equals(p3));
    }
}