package Java8.ch6;

import java.util.*;

import static Java8.ch6.Dish.menu;
import static java.util.stream.Collectors.*;

public class Grouping2 {
    private enum CalroricLevel{ DIET,NORMAL,FAT}

    public static void main(String[] args) {
//        groupingByWithFiltering();
//
//        groupingBy_2base();
//
//        groupingBy_typeCount();

//        groupingBy_typeMax();
//
//        groupingBy_Calory();

        //groupingBy_TypeTotalCalrory();

        groupingBy_TypeCaloricLevel();
    }

    //groupingBy 내에 mapping() 사용
    public static void groupingBy_TypeCaloricLevel(){
        Map<Dish.Type, Set<CalroricLevel>> result=
                menu.stream().collect(
                    groupingBy(Dish::getType,mapping(dish->{
                                if(dish.getCalories()<=400) return CalroricLevel.DIET;
                                else if(dish.getCalories()<=700) return CalroricLevel.NORMAL;
                                else return CalroricLevel.FAT;
                            }
                            //,toSet())));
                            ,toCollection(TreeSet::new) )));

        System.out.println(result);
    }

    //타입별 총 칼로리 합
    public static void groupingBy_TypeTotalCalrory(){
        Map<Dish.Type,Integer> totalColoryPerType
                = menu.stream()
                .collect(groupingBy(Dish::getType,summingInt(Dish::getCalories)));

        System.out.println(totalColoryPerType);
    }

    public static void groupingBy_typeMax(){
//        Map<Dish.Type, Optional<Dish>> typesMax = menu.stream()
//                .collect(groupingBy(Dish::getType,maxBy(Comparator.comparingInt(Dish::getCalories))));
//        System.out.println(typesMax);

        //위에서처럼 Optinal로 감쌀 필요가 없으므로
        Map<Dish.Type,Dish> mostCaloricType
                = menu.stream()
                        .collect(groupingBy(
                                Dish::getType,collectingAndThen(
                                maxBy(Comparator.comparingInt(Dish::getCalories)),
                                Optional::get
                        )));

        System.out.println(mostCaloricType);
    }

    //Collectors.counting()
    // : Returns a Collector accepting elements of type T that counts the number of input elements
    public static void groupingBy_typeCount(){
        Map<Dish.Type,Long> typesCount=menu.stream()
                .collect(groupingBy(Dish::getType,counting()));

        System.out.println(typesCount);
    }

    public static void groupingBy_Calory(){
//        Map<Integer,Long> result = menu.stream()
//                .collect(groupingBy(Dish::getCalories,counting()));
        Map<Integer,List<Dish>> result = menu.stream()
                .collect(groupingBy(Dish::getCalories));
        System.out.println(result);
    }

    //Collectors.groupingBy()
    //Returns a Collector implementing a cascaded "group by" operation on input elements of type T,
    // grouping elements according to a classification function,
    // and then performing a reduction operation on the values associated with a given key
    // using the specified downstream Collector.
    public static void groupingBy_2base(){
        Map<Dish.Type,Map<CalroricLevel,List<Dish>>> dishesByTypeCaloricLevel=
        menu.stream().collect(
            groupingBy(Dish::getType,
                groupingBy(dish->{
                    if(dish.getCalories()<=400) return CalroricLevel.DIET;
                    else if(dish.getCalories()<=700) return CalroricLevel.NORMAL;
                    else return CalroricLevel.FAT;
                })
            )
        );

        System.out.println(dishesByTypeCaloricLevel);
    }

    public static void groupingByWithFiltering(){
        Map<Dish.Type, List<Dish>> caloricDishesByType =menu.stream().
                                        filter(dish->dish.getCalories()>500)
                                        .collect(groupingBy(Dish::getType));
        System.out.println(caloricDishesByType);

        //Collectors.filtering()은 java9부터 새로 추가된 것이라 실습 불가...자바8에는 없음..
    }



}
