package chapter02.item03.field;

//3-1
//public static final 필드 방식의 싱글턴
//23P
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {

    }

    public void leaveTheBuilding() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}