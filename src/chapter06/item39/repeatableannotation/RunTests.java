package chapter06.item39.repeatableannotation;

import java.lang.reflect.Method;

//39-10
//반복 가능 애너테이션 다루기
//244P ~ 245P
public class RunTests {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName("chapter06.item39.repeatableannotation.Sample");
        for(Method m : testClass.getDeclaredMethods()) {
            if(m.isAnnotationPresent(ExceptionTest.class) || m.isAnnotationPresent(ExceptionTestContainer.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("테스트 %s 실패: 예외를 던지지 않음%n", m);
                } catch(Throwable wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    int oldPassed = passed;
                    ExceptionTest[] excTests = m.getAnnotationsByType(ExceptionTest.class);
                    for(ExceptionTest excTest : excTests) {
                        if(excTest.value().isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if(passed == oldPassed) {
                        System.out.printf("테스트 %s 실패: %s %n", m, exc);
                    }
                }
            }
        }

        System.out.printf("성공: %d, 실패: %d%n", passed, tests - passed);
    }
}