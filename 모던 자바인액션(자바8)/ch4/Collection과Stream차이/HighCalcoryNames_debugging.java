package Java8.ch5.Collection과Stream차이;

import java.util.List;
import java.util.stream.Collectors;

public class HighCalcoryNames_debugging {
    public static void main(String[] args) {
        List<String> HighCaloryNames =highCaloryNames(Dish.menu);
        System.out.println(HighCaloryNames);
    }
    //게으른 특성을 보여준다!!
    //no DVD! It's like Internet Streaming! (liip fusion)

    public static List<String> highCaloryNames(List<Dish> dishes){
        return dishes.stream()
                .filter(dish->{
                        System.out.println("filtering : "+dish.getName());
                        return dish.getCalories()>300;
                })
                .map(dish->{
                    System.out.println("mapping : "+dish.getName());
                    return dish.getName();
                })
                .collect(Collectors.toList());
    }
}
