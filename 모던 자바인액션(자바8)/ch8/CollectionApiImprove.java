package Java8.ch8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionApiImprove {
    public static void main(String[] args) {
        List<Integer> list =  new ArrayList<>();
        for(int i=1;i<=10;i++) list.add(i);

//        for(Iterator<Integer> iterator=list.iterator();iterator.hasNext();){
//            int here= iterator.next();;
//            if(here%2==0){
//                iterator.remove();
//            }
//        }

        list.removeIf(x->x%2==0);

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.forEach((key,value)-> System.out.println(key+" "+value));


    }
}
