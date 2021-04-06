package Java8.ch2.recap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Predicate_example {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("aa","","bb");


//        Predicate<String> nonEmptyStringPredicate = (String s)->!s.isEmpty();
//        List<String> nonEmpty =filter(listOfStrings,nonEmptyStringPredicate);
        List<String> nonEmpty = filter(listOfStrings,(s)->!s.isEmpty());
        System.out.println(nonEmpty);
    }

    //java.util.function.Predicate에 선언되어 있는 인터페이스
    //제네릭 형식의 T를 받아 boolean을 리턴.
//    @FunctionalInterface
//    public interface Predicate<T>{
//        boolean test(T t);
//    }

    public static <T> List<T> filter(List<T> list,Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T t:list){
            if(p.test(t)) result.add(t);
        }
        return result;
    }
}
