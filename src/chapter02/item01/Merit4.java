package chapter02.item01;

//4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
public class Merit4 {
    public static class NumberParser {
        public static Number parse(String input) {
            if(input.contains(".")) {
                return Double.parseDouble(input);
            } else {
                return Integer.parseInt(input);
            }
        }
    }
}
