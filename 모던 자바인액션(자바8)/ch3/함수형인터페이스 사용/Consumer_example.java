package Java8.ch2.recap;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumer_example {

    //java.util.function.Consumer 인터페이스에 선언된 내용
    //제네릭 타입 T를 받아서 void를 리턴한다
    //Consumer는 왜 쓰는거지..?
    //개념적인건가..

//    @FunctionalInterface
//    public interface Consumer<T>{
//        void accept(T t);
//    }

    public static <T> void ForEach(List<T> list, Consumer<T> c){
        for(T t:list) c.accept(t);
    }

    public static void main(String[] args) {
        ForEach(Arrays.asList(1,2,3,4,5),(num -> System.out.println(num)) );

    }

}
