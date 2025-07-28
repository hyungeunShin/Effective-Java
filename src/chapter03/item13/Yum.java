package chapter03.item13;

public class Yum implements Cloneable {
    private String name;
    private int calories;

    public Yum(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    //13-6
    //하위 클래스에서 Cloneable을 지원하지 못하게 하는 clone 메서드
    //85P
    @Override
    protected Yum clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    //13-7
    //복사 생성자 - 단순히 자신과 같은 클래스의 인스턴스를 인수로 받는 생성자
    //85P ~ 86P
    public Yum(Yum other) {
        this.name = other.name;
        this.calories = other.calories;
    }

    //13-8
    //복사 팩터리
    //85P ~ 86P
    public static Yum copyOf(Yum other) {
        return new Yum(other);
    }

    @Override
    public String toString() {
        return "Yum{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }

    public static void main(String[] args) {
        Yum original = new Yum("Cake", 500);

        Yum copiedByConstructor = new Yum(original);
        Yum copiedByFactory = Yum.copyOf(original);

        System.out.println(copiedByConstructor);
        System.out.println(copiedByFactory);
    }
}