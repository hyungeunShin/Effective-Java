package chapter11.item82;

public class Item82 {
    private final Object lock = new Object();

    //82-1
    //비공개 락 객체 관용구 - 서비스 거부 공격을 막아준다.
    //440P
    public void foo() {
        synchronized(lock) {

        }
    }

    /*
    API 문서에 synchronized 한정자가 보이는 메서드는 스레드 안전하다는 이야기를 들었을지 모른다.
    하지만 이 말은 몇 가지 면에서 틀렸다.
    자바독이 기본 옵션에서 생성한 API 문서에는 synchronized 한정자가 포함되지 않는다.
    메서드 선언에 synchronized 한정자를 선언할지는 구현 이슈일 뿐 API에 속하지 않는다.
    따라서 이것만으로는 그 메서드가 스레드 안전하다고 믿기 어렵다.

    멀티스레드 환경에서도 API를 안전하게 사용하게 하려면 클래스가 지원하는 스레드 안전성 수준을 정확히 명시해야 한다.

        - 불변(immutable)
            - 이 클래스의 인스턴스는 마치 상수와 같아서 외부 동기화도 필요 없다.
            - String, Long, BigInteger 등
        - 무조건적 스레드 안전(unconditionally thread-safe)
            - 이 클래스의 인스턴스는 수정될 수 있으나, 내부에서 충실히 동기화하여 별도의 외부 동기화 없이 동시에 사용해도 안전하다.
            - AtomicLong, ConcurrentHashMap 등
        - 조건부 스레드 안전(conditionally thread-safe)
            - 무조건적 스레드 안전과 같으나, 일부 메서드는 동시에 사용하려면 외부 동기화가 필요하다.
            - Collections.synchronized 래퍼 메서드가 반환한 컬렉션들
        - 스레드 안전하지 않음(not thread-safe)
            - 이 클래스의 인스턴스는 수정될 수 있다. 동시에 사용하려면 각각의 메서드 호출을 클라이언트가 선택한 외부 동기화 메커니즘으로 감싸야한다.
            - ArrayList , HashMap 같은 기본 컬렉션
        - 스레드 적대적(thread-hostile)
            - 이 클래스는 모든 메서드 호출을 외부 동기화로 감싸더라도 멀티스레드 환경에서 안전하지 않다.
            - 이 수준의 클래스는 일반적으로 정적 데이터를 아무 동기화 없이 수정한다.
            - 문제를 고쳐 재배포 하거나 사용자제 (deprecated) API로 지정한다.
    */
}
