package chapter08.item54;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        CheeseStorage storage = new CheeseStorage();
        List<Cheese> cheeses = storage.getCheesesV1();
        if(cheeses != null && cheeses.contains(Cheese.STILTON)) {
            System.out.println("좋았어, 바로 그거야.");
        }
    }
}
