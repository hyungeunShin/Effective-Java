package chapter05.item29;

import java.util.Arrays;

//29-2
//제네릭 스택으로 가는 첫 단계 - 컴파일 되지 않는다.
//171P
public class StackV2<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    //29-3
    //배열을 사용한 코드를 제네릭으로 만드는 방법1
    //172P
    //배열 elements는 push(E)로 넘어온 E 인스턴스만 담는다.
    //따라서 타입 안전성을 보장하지만, 이 배열의 런타임 타입은 E[]가 아닌 Object[]다!!!
    @SuppressWarnings("unchecked")
    public StackV2() {
        //컴파일 에러
        //elements = new E[DEFAULT_INITIAL_CAPACITY];
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    //29-4
    //배열을 사용한 코드를 제네릭으로 만드는 방법2
    public E pop() {
        if(size == 0) {
            throw new EmptyStackException();
        }

        //비검사 경고를 적절히 숨긴다
        //push 에서 E 타입만 허용하므로 이 형변환은 안전하다
        @SuppressWarnings("unchecked") E result = (E) elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if(elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}