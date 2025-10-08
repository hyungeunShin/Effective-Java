package chapter11.item83;

public class Initialization {
    //83-1
    //인스턴스 필드를 초기화하는 일반적인 방법
    //443P
    private final FieldType field1 = computeFieldValue();

     private static FieldType computeFieldValue() {
        return new FieldType();
    }

    //83-2
    //인스턴스 필드의 지연 초기화 - synchronized 접근자 방식
    //443P
    private FieldType field2;

    private synchronized FieldType getField2() {
        if(field2 == null) {
            field2 = computeFieldValue();
        }
        return field2;
    }

    //83-3
    //정적 필드용 지연 초기화 홀더 클래스 관용구
    //443P
    private static class FieldHolder {
        static final FieldType field3 = computeFieldValue();
    }

    private static FieldType getField3() {
        return FieldHolder.field3;
    }

    //83-4
    //인스턴스 필드 지연 초기화용 이중검사 관용구
    //444P
    private volatile FieldType field4;

    private FieldType getField4() {
        FieldType result = field4;
        if(result != null) {
            return result;
        }

        synchronized(this) {
            if(field4 == null) {
                field4 = computeFieldValue();
            }
            return field4;
        }
    }

    //83-5
    //단일검사 관용구 - 초기화가 중복해서 일어날 수 있다!
    //445P
    private volatile FieldType field5;

    private FieldType getField5() {
        FieldType result = field5;
        if(result == null) {
            field5 = result = computeFieldValue();
        }

        return result;
    }
}
