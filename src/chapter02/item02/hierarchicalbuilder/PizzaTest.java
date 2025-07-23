package chapter02.item02.hierarchicalbuilder;

import static chapter02.item02.hierarchicalbuilder.NyPizza.Size.*;
import static chapter02.item02.hierarchicalbuilder.Pizza.Topping.*;

//계층적 빌더 사용
//21P
public class PizzaTest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                                   .addTopping(SAUSAGE)
                                   .addTopping(ONION)
                                   .build();

        Calzone calzone = new Calzone.Builder()
                                     .addTopping(HAM)
                                     .sauceInside()
                                     .build();
        
        System.out.println(pizza);
        System.out.println(calzone);
    }
}