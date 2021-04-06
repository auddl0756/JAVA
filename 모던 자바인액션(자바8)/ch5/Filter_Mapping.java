package Java8.ch5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Filter_Mapping {
    public static void main(String[] args) {
        //FlatMap2();


    }

///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

    //flatMap()
    public static List<String> FlatMap(List<Dish> dishes){
        //요리들의 알파벳의 집합을 리턴하기
        return dishes.stream()
                .map(Dish::getName)
                .map(word->word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    //stream으로 모든 쌍 만들기 (2중 For문과 같은)
    public static void FlatMap2(){
        List<Integer> a=Arrays.asList(1,2,3);
        List<Integer> b=Arrays.asList(3,4);
        List<int[]> pairs = a.stream()
                .flatMap(i->b.stream().map(j->new int[]{i,j})).collect(Collectors.toList());

        for(int i=0;i<pairs.size();i++){
            System.out.println(pairs.get(i)[0]+" "+pairs.get(i)[1]);
        }
        System.out.println();
    }
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

    //map()
    //Stream의 각 원소에 함수 적용하기 (map())
    public static List<String> MAP(List<Dish> dishes){
        //요리의 이름들을 반환
        return dishes.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    public static List<Integer> MAP2(List<Dish> dishes){
        //요리의 이름들을 얻고 이름들의 길이를 반환
        return dishes.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
    }

    public static void MAP3(){
        //제곱근 구하기
        List<Integer> sample = Arrays.asList(1,2,3,4,5);
        sample.stream()
                .map(x->x*x)
                .forEach(System.out::println);
    }
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

    // Stream의 일부 원소 건너 뛰기
    public static List<Dish> Skip(List<Dish> dishes){
        //300 칼로리 이상의 중에 앞의 2개는 건너 뛰고 반환하기
        return dishes.stream()
                .filter(d->d.getCalories()>=300)
                .skip(2)
                .collect(Collectors.toList());
    }
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

    //Stream 축소,한정
    public static List<Dish> Limit(List<Dish> dishes){
        //300 칼로리 이상의 요리 3개 리턴하기
        return dishes.stream()
                .filter(d->d.getCalories()>=300)
                .limit(3)
                .collect(Collectors.toList());
    }
///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////

    //고유 요소 필터링 -> use  "public abstract Stream<T> distinct()" in "java.util.stream.Stream<T>" package
    public static void Distinct(){
        int a=1;
        Integer b = new Integer(3);
        Integer c = new Integer(3);
        System.out.println(b.hashCode());   //Returns a hash code for this Integer which is number itself.
        System.out.println(c.hashCode());

        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4,5,1,2,3);

//        List<Integer> evenNumbers  = numbers.stream()
//                .filter((num)->num%2==0)
//                .distinct()
//                .collect(Collectors.toList());
//
//        System.out.println(evenNumbers);

        numbers.stream()
                .filter(num -> num%2==0)
                .distinct()
                .forEach(System.out::println);
        //distinct()
        // :Returns a stream consisting of the distinct elements
        // (according to Object.equals(Object)) of this stream.
    }
}
