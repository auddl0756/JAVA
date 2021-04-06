package Java8.ch5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Review {
    static List<Integer> numbers = Arrays.asList(1,2,3,4,1,2,3,4,1,2,3);
    static List<String> words =Arrays.asList("hello","world");
    static List<Integer> a=Arrays.asList(1,2,3);
    static List<Integer> b=Arrays.asList(4,5);

    public static void main(String[] args) {

    }

    public static void Reduce_Map(){
        int cnt=Dish.menu.stream()
                .map(dish->1)
                .reduce(0,(x,y)->x+y);

        System.out.println(cnt);
    }

    public static void Reduce_Max(){
        //최댓값 구하기
        Optional<Integer> max=numbers.stream()
                //.reduce(0,(a,b)->Math.max(a,b));
                .reduce(Integer::max);

        System.out.println(max);
    }

    public static void Reduce_Sum(){
        //numbers에 있는 수를 다 더한 값을 반환.
        //reduce(초기값,BinaryOperation)
        int sum = numbers.stream()
                .reduce(0, (a,b)->a+b);
        System.out.println(sum);
    }

    public static void AllMatch(){
        if(Dish.menu.stream().allMatch(dish->dish.getCalories()<100))
            System.out.println("all dishes are under 100 calrories");
        else System.out.println("some dish's calrory over 100");
    }

    public static void AnyMatch(){
        if(Dish.menu.stream().anyMatch(Dish::isVegetarian))
            System.out.println("matched");
        else System.out.println("nothing matched");
    }

    public static void AnyMatch2(){
        //채식 요리 선택하기
        Optional<Dish> dish = Dish.menu.stream()
                //.filter(d -> d.getCalories()>1000)
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println(dish);

    }

    public static void 두배열의모든쌍구하기(){
        List<int[]> res=a.stream()
                .flatMap(i -> b.stream().map(j->new int[]{i,j}))
                .collect(Collectors.toList());

        for(int[] x:res) System.out.println(x[0]+","+x[1]);

    }

    public static void FlatMap(){
        //[ this not work. need flatMap]
//                words.stream()
//                .map(word -> word.split(""))
//                .distinct()
//                .forEach(System.out::println);

        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
    }

    public static void Mapping(){
        //3이상인 수들의 제곱수를 구하기. using map
        numbers.stream()
                .filter(x->x>=3)
                .map(x->x*x)
                .forEach(System.out::println);

        //요리객체의 리스트를 요리 이름의 리스트로 바꾸기
        List<String> names =Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());

    }

    public static void Skip(){
        // 처음 3개 건너뛰고 출력하기
        numbers.stream()
                .skip(3)
                .forEach(System.out::println);
    }

    public static void Filter(){
        //채식 요리만 거르기
        Dish.menu.stream()  //일단 stream을 얻은 다음에
                .filter(Dish::isVegetarian) //거르고
                .forEach(System.out::println);  //출력하기
    }

    public static void Distinct(){
        //짝수를 필터링하는데 중복을 제거하도록
        numbers.stream()    //1. 스트림을 얻고
                .filter(x->x%2==0)  //2. 필터링 하고
                .distinct()     //중복을 제거하고
                .forEach(System.out::println);
    }

    public static void Limit(){
        //위에 준어진 배열에서 3이상이면서 앞의 3개 가져오기
        numbers.stream()
                .filter(x -> x>=3)
                .limit(3)
                .forEach(System.out::println);

    }

}
