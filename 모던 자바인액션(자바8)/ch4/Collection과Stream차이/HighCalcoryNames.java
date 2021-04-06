package Java8.ch5.Collection과Stream차이;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HighCalcoryNames {
    public static void main(String[] args) {

        List<String> result_by_java7 = getHighCalroryNames_java7(Dish.menu);
        List<String> result_by_java8 = getHighCalroryNames_java8(Dish.menu);

        System.out.println(result_by_java7);
        System.out.println(result_by_java8);
    }

    public static List<String> getHighCalroryNames_java7(List<Dish> dishes){
        List<Dish> highCalroryDishes = new ArrayList<>();
        for(Dish dish:dishes){
            if(dish.getCalories()<400) highCalroryDishes.add(dish);
        }
        List<String> highCalroryNames = new ArrayList<>();
        Collections.sort(highCalroryDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(),o2.getCalories());
            }
        });

        for(Dish d:highCalroryDishes){
            highCalroryNames.add(d.getName());
        }

        return highCalroryNames;
    }

    public static List<String> getHighCalroryNames_java8(List<Dish> dishes){
        return dishes.stream()
                .filter(d->d.getCalories()<400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());

        //filter : Returns a stream consisting of the elements of this stream that match the given predicate.
        //sorted : Returns a stream consisting of the elements of this stream, sorted according to the provided Comparator.
        //map : Returns a stream consisting of the results of applying the given function to the elements of this stream.
        //collect : Performs a mutable reduction operation on the elements of this stream using a Collector.
        //  Mutable reduction이란 ?
        //   :collect the desired results into a mutable container object such as a java.util.Collection or an array.

        //filter,sorted,map : 중간 연산
        //collect : 최종 연산
    }

}
