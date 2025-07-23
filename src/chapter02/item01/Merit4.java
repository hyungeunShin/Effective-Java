package chapter02.item01;

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
