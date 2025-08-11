package chapter05.item33;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

//33-5
//asSubclass를 사용해 한정적 타입 토큰을 안전하게 형변환한다.
//204P
public class PrintAnnotation {
    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        Class<?> annotationType = null; //비한정적 타입 토큰
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch(Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Test.class;

        String annotationClassName = "chapter05.item33.TestAnnotation";

        Annotation annotation = getAnnotation(clazz, annotationClassName);

        if(annotation != null) {
            System.out.println(annotation);
        }
    }
}