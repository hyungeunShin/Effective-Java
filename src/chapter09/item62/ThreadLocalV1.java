package chapter09.item62;

//62-2
//잘못된 예 - 문자열을 사용해 권한을 구분하였다.
//363P
public class ThreadLocalV1 {
    //객체 생성 불가
    private ThreadLocalV1() {

    }

    //현 스레드의 값을 키로 구분해 저장한다.
    public static void set(String key, Object value) {

    }

    //키가 가리키는 현 스레드의 값을 반환한다.
    public static Object get(String key) {
        return null;
    }
}
