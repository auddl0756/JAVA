package Java8.ch2.AppleExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> apples= Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED),
                new Apple(170, Color.RED),
                new Apple(180, Color.GREEN)
        );

        List<Apple> redApples = filter(apples,new AppleColorPredicate());
        //debug(redApples);

        /// 익명클래스를 발전시킨 람다로 더 간소화하면
        // predicate를 따로 클래스로 작성할 필요없이 원하는 값을 바로 얻는 것도 가능!!!!!!!!
        List<Apple> redApples2 = filter(apples,(Apple a)->Color.RED.equals(a.getColor()) );
        //debug(redApples2);


    }

    public static<T> void debug(List<T> apples){
        for(T a:apples){
            System.out.print(a.toString()+" ");
        }
        System.out.println();
    }
    //전달한 ApplePredicate에 의해 filter동작이 결정!
    //의의 : 1개의 파라미터, 다양한 동작!!!!
    //      하나의 메서드가 다양한 동작을 하도록 재사용
    // 전략 디자인 패턴의 일종.
    // 전략 디자인 패턴 : 각 알고리즘을 캡슐화해서 마련해두고 런타임에 사용할 알고리즘을 선택하는 기법
    public static List<Apple> filter(List<Apple> apples,ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple a:apples){
            if(p.test(a)) result.add(a);
        }
        return result;
    }





    // 구식 방법. 원하는 필터마다 함수를 따로 작성했다.
//    public static List<Apple> filterGreenApples(List<Apple> apples){
//        List<Apple> result = new ArrayList<>();
//        for(Apple a:apples){
//            if(a.getColor()==Color.GREEN) result.add(a);
//        }
//        return result;
//    }
//
//    public static List<Apple> filterApplesByColor(List<Apple> apples, Color color) {
//        List<Apple> result = new ArrayList<>();
//        for(Apple a:apples){
//            if(a.getColor()==color) result.add(a);
//        }
//        return result;
//    }
//
//    public static List<Apple> filterApplesByWeight(List<Apple> apples, int weight) {
//        List<Apple> result = new ArrayList<>();
//        for (Apple apple : apples) {
//            if (apple.getWeight() > weight) {
//                result.add(apple);
//            }
//        }
//        return result;
//    }


}
