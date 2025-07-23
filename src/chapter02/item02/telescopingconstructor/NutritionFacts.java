package chapter02.item02.telescopingconstructor;

//2-1
//점층적 생성자 패턴 - 확장하기 어렵다.
//14P ~ 15P
public class NutritionFacts {
    private final int servingSize;  //필수
    private final int servings;     //필수
    private final int calories;     //선택
    private final int fat;          //선택
    private final int sodium;       //선택
    private final int carbohydrate; //선택

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize  = servingSize;
        this.servings     = servings;
        this.calories     = calories;
        this.fat          = fat;
        this.sodium       = sodium;
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args) {
        //매개변수가 많아지면 클라이언트 코드를 작성하거나 읽기 어려움
        NutritionFacts nutritionFacts = new NutritionFacts(240, 8, 100, 0, 35, 27);
    }
}