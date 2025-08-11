package chapter06.item34;

public class SimpleClass {
    public static void main(String[] args) {
        Apple apple = Apple.FUJI;
        Orange orange = Orange.NAVEL;

        //System.out.println(apple == orange);
    }
}

//34-2
//가장 단순한 열거 타입
//209P
enum Apple { FUJI, PIPPIN, GRANNY_SMITH }
enum Orange { NAVEL, TEMPLE, BLOOD }
