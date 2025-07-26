package chapter02.item7;

import java.util.Arrays;
import java.util.List;

//7-1
//메모리 누수가 일어나는 위치는 어디인가?
//36P
public class StackV1 {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackV1() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if(size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    /**
     * 원소를 위한 공간을 적어도 하나 이상 확보한다.
     * 배열 크기를 늘려야 할 때마다 대략 두 배씩 늘린다.
     */
    private void ensureCapacity() {
        if(elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        /*
        이 코드에서는 스택이 커졌다가 줄어들었을 때 스택에서 꺼내진 객체들을 가비지 컬렉터가 회수하지 않는다.
        이 스택이 그 객체들의 다 쓴 참조를 여전히 가지고 있기 때문이다.
        해법은 간단하다. 해당 참조를 다 썼을 때 null 처리(참조 해제)하면 된다.
        */
        List<String> list = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        StackV1 stack = new StackV1();
        for(String arg : list) {
            stack.push(arg);
        }

        while(true) {
            System.err.println(stack.pop());
        }
    }
}