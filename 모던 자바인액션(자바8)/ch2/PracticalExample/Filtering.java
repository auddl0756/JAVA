package Java8.ch2.PracticalExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filtering {
    interface Predicate<T>{
        boolean test(T t);
    }

    public static <T> List<T> filter(List<T> list,Predicate<T> p){
        List<T> res = new ArrayList<>();
        for(T e:list){
            if(p.test(e)) res.add(e);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> samples = Arrays.asList(
                1,2,3,4,5,6,7
        );

        List<Integer> evenNumbers = filter(samples,(Integer i)->i%2==0);

        for(int num:evenNumbers) System.out.println(num);
    }
}
