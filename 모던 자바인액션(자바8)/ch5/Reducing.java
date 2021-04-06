package Java8.ch5;

import java.util.Arrays;
import java.util.List;

public class Reducing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        int sum1 = getSum_java7(numbers);
        int sum2 = getSum_java8(numbers);

        //map과 reduce를 이용해서 Stream의 요리 개수를 반환하기

        System.out.println(Dish.menu.stream()
                .map(dish->1)
                .reduce(0,(a,b)->a+b));

    }

    public static int getSum_java8(List<Integer> numbers){
        return numbers.stream().reduce(0,(a,b)->a+b);

        //Performs a reduction on the elements of this stream,
        // using the provided identity value and an associative accumulation function,
        // and returns the reduced value.
    }

    public static int getSum_java7(List<Integer> numbers){
        int ret=0;
        for(int num:numbers) ret+=num;
        return ret;
    }

}
