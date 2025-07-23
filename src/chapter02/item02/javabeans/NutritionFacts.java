package chapter02.item02.javabeans;

//2-2
//자바빈즈 패턴 - 일관성이 깨지고, 불변으로 만들 수 없다.
//16P
public class NutritionFacts {
    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    public NutritionFacts() {

    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {
        //객체 하나를 만들려면 메서드를 여러 개 호출해야 하고, 객체가 완전히 생성되기 전까지는 일관성이 무너진 상태
        NutritionFacts nutritionFacts = new NutritionFacts();
        nutritionFacts.setServingSize(240);
        nutritionFacts.setServings(8);
        nutritionFacts.setCalories(100);
        nutritionFacts.setSodium(35);
        nutritionFacts.setCarbohydrate(27);
    }
}