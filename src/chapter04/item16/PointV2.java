package chapter04.item16;

//16-2
//접근자와 변경자(mutator) 메서드를 활용해 데이터를 캡슐화한다.
//102P
class PointV2 {
    private double x;
    private double y;

    public PointV2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}