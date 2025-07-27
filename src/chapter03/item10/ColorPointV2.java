package chapter03.item10;

import java.util.Objects;

//10-5
//equals 규약을 지키면서 값 추가하기
//60P
public class ColorPointV2 {
    private final Point point;
    private final Color color;

    public ColorPointV2(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    /**
     * 이 ColorPoint의 Point 뷰를 반환한다.
     */
    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof ColorPointV2)) {
            return false;
        }

        ColorPointV2 cp = (ColorPointV2) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    public static void main(String[] args) {
        ColorPointV2 colorPoint1 = new ColorPointV2(1, 2, Color.RED);
        ColorPointV2 colorPoint2 = new ColorPointV2(2, 3, Color.RED);
        ColorPointV2 colorPoint3 = new ColorPointV2(1, 2, Color.BLUE);
        ColorPointV2 colorPoint4 = new ColorPointV2(1, 2, Color.RED);

        System.out.println(colorPoint1.equals(colorPoint2) + " " + colorPoint2.equals(colorPoint3));
        System.out.println(colorPoint1.equals(colorPoint4));
    }
}