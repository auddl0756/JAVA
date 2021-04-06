package Java8.ch5;

import java.util.Arrays;
import java.util.List;

public class Search_Match {
    public static void main(String[] args) {
        //anyMatch
        // : Returns whether any elements of this stream match the provided predicate.
        if(Dish.menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("the menu is (somewhat) vegeterian friendly!");
        }

        //allMatch
        // : Returns whether all elements of this stream match the provided predicate.
        if(Dish.menu.stream().allMatch(dish->dish.getCalories()<1000))
            System.out.println("all calrories are under 1000");

        //finaAny
        //:Returns an Optional describing some element of the stream, or an empty Optional if the stream is empty.
        //This is a short-circuiting terminal operation.
        Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish-> System.out.println(dish.getName()));


        //findFirst
        //제곱값이 3으로 나눠떨어지는 첫번째 수 찾기.
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        numbers.stream()
                .map(n->n*n)
                .filter(n->n%3==0)
                .findFirst()
                .ifPresent(System.out::println);



    }




}
