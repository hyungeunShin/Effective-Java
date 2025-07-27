package chapter03.item10;

//56P
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point)) {
            return false;
        }

        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

    /*
    //10-4
    //잘못된 코드 - 리스코프 치환 원칙 위배!
    //59P
    //구체 클래스를 확장해 새로운 값을 추가하면서 equals 규약을 만족시킬 방법은 객체 지향적 추상화의 이점을 포기하지 않는 한 존재하지 않는다.
    @Override
    public boolean equals(Object o) {
        if(o == null || o.getClass() != getClass()) {
            return false;
        }

        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
    */
}