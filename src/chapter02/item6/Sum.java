package chapter02.item6;

//6-3
//끔찍이 느리다! 객체가 만들어지는 위치를 찾았는가?
//34P
public class Sum {
    private static long sum() {
        //박싱된 기본 타입보다는 기본 타입을 사용하고, 의도치 않은 오토박싱이 숨어들지 않도록 주의하자.
        //Long sum = 0L;
        long sum = 0L;
        for(long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        long x = 0;

        for(int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis();
            x += sum();
            long end = System.currentTimeMillis();
            System.out.println((end - start) + "ms");
        }

        //VM이 최적화하지 못하게 막는 코드
        if(x == 42) {
            System.out.println();
        }
    }
}