package chapter09.item63;

public class Test {
    public static void main(String[] args) {
        int loopCount = 100_000;

        //63-1
        //문자열 연결을 잘못 사용한 예 - 느리다!
        //366P
        long startTime1 = System.currentTimeMillis();
        String str = "";
        for(int i = 0; i < loopCount; i++) {
            str += "a";
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println((endTime1 - startTime1) + " ms");

        //63-2
        //StringBuilder를 사용하면 문자열 연결 성능이 크게 개선된다.
        //366P
        long startTime2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < loopCount; i++) {
            sb.append("a");
        }
        String result = sb.toString();
        long endTime2 = System.currentTimeMillis();
        System.out.println((endTime2 - startTime2) + " ms");
    }
}
