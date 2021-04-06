package Java8.ch2.recap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Function_example {

    //java.util.function.Function에 정의된 인터페이스
    //  R apply(T)을 정의한다
    // 입력을 출력으로 매핑하는 람다를 정의할 때 Function 인터페이스를 활용할 수 있다
    // 사실 stream에 있는 map을 쓰면 된다.

//    @FunctionalInterface
//    public interface Function<T,R>{
//        R apply(T t);
//    }

    public static <T,R> List<R> map(List<T> list, Function<T,R>f){
        List<R> results = new ArrayList<>();
        for(T t:list) results.add(f.apply(t));
        return results;
    }

    public static void main(String[] args) {
        map(Arrays.asList("lambdas","in","action") , (String s)->s.length()).stream()
                .forEach(System.out::println);
    }
}
