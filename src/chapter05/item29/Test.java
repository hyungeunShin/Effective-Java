package chapter05.item29;

public class Test {
    public static void main(String[] args) {
        StackV2<String> stack = new StackV2<>();

        for(String arg : args) {
            stack.push(arg);
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop().toUpperCase());
        }
    }
}
