package chapter10.item69;

public class Climber {
    public void climb() {
        System.out.println("Climbing!");
    }

    public static void main(String[] args) {
        Climber[] range = new Climber[5];
        for(int i = 0; i < range.length; i++) {
            range[i] = new Climber();
        }

        //69-1
        //예외를 완전히 잘못 사용한 예 - 따라 하지 말 것!
        //386P
        try {
            int i = 0;
            while(true) {
                range[i++].climb();
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Finished climbing all elements!");
        }
    }
}