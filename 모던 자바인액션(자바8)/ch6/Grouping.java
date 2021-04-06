package Java8.ch6;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static Java8.ch6.Dish.menu;

//groupingBy 간단한 예제
public class Grouping {
    enum CalroricLevel{ DIET,NORMAL,FAT}

    public static void main(String[] args) {
        groupingBy_Type();
        groupingBy_Calrory();
    }

    public static void groupingBy_Calrory(){    //더 복잡한 기준에 따라 분류 -> 메서드 참조 대신 람다 표현식 사용하면 됨
        Map<CalroricLevel,List<Dish>> dishesByCalroricLevel
                = menu.stream().collect(groupingBy(
                dish->{
                    if(dish.getCalories()<=400) return CalroricLevel.DIET;
                    else if(dish.getCalories()<=700) return CalroricLevel.NORMAL;
                    else return CalroricLevel.FAT;
                }
        ));

        System.out.println(dishesByCalroricLevel);
    }

    public static void groupingBy_Type(){
        Map<Dish.Type, List<Dish>> dishByType= menu.stream().collect(groupingBy(Dish::getType));

        //Collectors.groupingBy()
        // : Returns a Collector implementing a "group by" operation on input elements of type T,
        // grouping elements according to a classification function,
        // and returning the results in a Map.

        System.out.println(dishByType);
    }
}
