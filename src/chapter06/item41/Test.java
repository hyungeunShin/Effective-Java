package chapter06.item41;

public class Test {
    static class Dog implements Animal {

    }

    static class Cat {

    }

    static void sound(Object animal) {
        if(!(animal instanceof Animal)) {
            throw new IllegalArgumentException();
        }
        System.out.println("Animal");
    }

    public static void main(String[] args) {
        sound(new Dog());
        sound(new Cat());
    }
}
