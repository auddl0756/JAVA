package Java8.ch6;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;

import static Java8.ch6.Dish.menu;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;

//Implementations of Collector that implement various useful reduction operations

public class Reducing {
    public static void main(String[] args) {
//        getMaxBy();
        //getAverage();
        //getSum();
        //getSummaryStatistics();

//        Joining();

//        getSum();
//        getCount();

        Joining();
    }

    public static void Joining(){
        //이게 더 좋은 방법
        String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(" "));

        //범용 리듀싱 연산을 이용
        //version 1
        //String shortMenu= menu.stream().collect(reducing("",Dish::getName,(s1,s2)->s1+" "+s2));

        //version 2
        //String shortMenu = menu.stream().map(Dish::getName).collect(reducing((s1,s2)->s1+" "+s2)).get();

        System.out.println(shortMenu);

    }

    //사이즈,합계,최소,최대,평균 정보를 모두 제공하는 Collectors 클래스의 정적 메서드도 있다!
    public static void getSummaryStatistics(){
        //IntSummaryStatistics
        // : A state object for collecting statistics such as count, min, max, sum, and average.

        IntSummaryStatistics menuStatistics =menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);
    }


    public static void getSum(){
//        int caloriesSum = menu.stream()
//                                .collect(Collectors.summingInt(Dish::getCalories));
//        System.out.println(caloriesSum);

        //범용 reducing으로도 동일한 결과를 얻을 수 있다
//        int caloriesSum = menu.stream()
//                                .collect(reducing(0,Dish::getCalories,(i,j)->i+j));

        //int caloriesSum = menu.stream().collect(reducing(0,Dish::getCalories,Integer::sum));

        //스트림을 IntStream으로 매핑한 다음에 sum 메서드를 호출해서 합계를 얻을 수도 있다!
        int caloriesSum = menu.stream().mapToInt(Dish::getCalories).sum();
        //mapToInt
        //:Returns an IntStream consisting of the results
        // of applying the given function to the elements of this stream.
        System.out.println(caloriesSum);
    }

    public static void getAverage(){
        double averageCalrorie=menu.stream()
                .collect(Collectors.averagingInt(Dish::getCalories));

        System.out.println(averageCalrorie);
    }

    public static void getMaxBy(){
//        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
//        Optional<Dish> mostCalrorieDish = menu.stream()
//                                                .collect(maxBy(dishCaloriesComparator));
//            System.out.println(mostCalrorieDish.get());


//        Optional<Dish> mostCalrorieDish = menu.stream()
//                .max(new Comparator<Dish>() {
//                    @Override
//                    public int compare(Dish o1, Dish o2) {
//                        return o1.getCalories()-o2.getCalories();
//                    }
//                });
//        System.out.println(mostCalrorieDish.get());


//        Optional<Dish> mostCalrorieDish = menu.stream()
//                                                .max(Comparator.comparing(Dish::getCalories));
//        System.out.println(mostCalrorieDish.get());


        //범용 리듀싱 연산 이용
        Optional<Dish> mostCalrorieDish=menu.stream()
                                .collect(reducing((d1, d2)->d1.getCalories()>d2.getCalories() ? d1:d2));

        System.out.println(mostCalrorieDish.get());


    }

    public static void getCount(){
//       long howManyDishes =menu.stream()
//                                .collect(Collectors.counting());
        //Implementations of Collector that implement various useful reduction operations,
        // such as accumulating elements into collections,
        // summarizing elements according to various criteria, etc.
        // 많은 predefined collectors가 있다!

        //long howManyDishes = menu.stream().count();
            //Returns the count of elements in this stream.
            // This is a special case of a reduction and is equivalent to:
            //     return mapToLong(e -> 1L).sum();

        long howManyDishes = menu.stream().collect(reducing(0L,dish->1L,Long::sum));

        System.out.println(howManyDishes);

    }
}
