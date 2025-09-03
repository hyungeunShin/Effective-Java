package chapter09.item65;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

//65-1
//리플렉션으로 생성하고 인터페이스로 참조해 활용한다.
//372P ~ 373P
public class ReflectiveInstantiation {
    public static void main(String[] args) {
        String[] testArgs = {
                "java.util.HashSet",
                "apple", "banana", "orange"
        };

        //클래스 이름을 Class 객체로 변환
        Class<? extends Set<String>> cl = null;
        try {
            //비검사 형변환!
            cl = (Class<? extends Set<String>>) Class.forName(testArgs[0]);
        } catch(ClassNotFoundException e) {
            fatalError("클래스를 찾을 수 없습니다.");
        }

        //생성자를 얻는다.
        Constructor<? extends Set<String>> cons = null;
        try {
            cons = cl.getDeclaredConstructor();
        } catch(NoSuchMethodException e) {
            fatalError("매개변수 없는 생성자를 찾을 수 없습니다.");
        }

        //집합의 인스턴스를 만든다.
        Set<String> s = null;
        try {
            s = cons.newInstance();
        } catch(IllegalAccessException e) {
            fatalError("생성자에 접근할 수 없습니다.");
        } catch(InstantiationException e) {
            fatalError("클래스를 인스턴스화할 수 없습니다.");
        } catch(InvocationTargetException e) {
            fatalError("생성자가 예외를 던졌습니다: " + e.getCause());
        } catch(ClassCastException e) {
            fatalError("Set을 구현하지 않은 클래스입니다.");
        }

        //생성한 집합을 사용한다.
        s.addAll(Arrays.asList(testArgs).subList(1, testArgs.length));
        System.out.println(s);
    }

    private static void fatalError(String msg) {
        System.err.println(msg);
        System.exit(1);
    }
}