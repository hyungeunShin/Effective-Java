package chapter06.item39.repeatableannotation;

import java.lang.annotation.*;

//39-8
//반복 가능한 애너테이션 타입
//243P ~ 244P
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTest {
    Class<? extends Throwable> value();
}