import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//ArrayList vs LinkedList

public class ListExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i<=1000000;i++) numbers.add(i);

        List<Integer> arrayList = new ArrayList<>(numbers);
        List<Integer> linkedList = new LinkedList<>(numbers);

        //ArrayList와 LinkedList 중간 원소 삭제시 수행 시간 비교
        System.out.print("arrayList's remove execution time :");
        removeTime(arrayList,10);
        System.out.print("linkedList's remove execution time :");
        removeTime(linkedList,10);


        //get 연산 수행 시간 비교
        System.out.print("arrayList's get execution time :");   //ArrayList는 RandomAccess 인터페이스를 구현하고 있다!
        getTime(arrayList,numbers.size()/2);

        System.out.print("linkedList's get execution time :");
        getTime(linkedList,numbers.size()/2);

        //자바에서 Queue는 LinkedList 이용
        //LinkedList는 Queue,Deque 인터페이스도 구현하고 있다!
        Queue<Integer> queue = new LinkedList<>();


    }

    public static void getTime(List<Integer> list,int idx){
        long startTime = System.nanoTime();
        list.get(idx);
        long endTime = System.nanoTime();

        System.out.println(endTime-startTime);
    }

    public static void removeTime(List<Integer> list,int idx){
        long startTime = System.nanoTime();
        list.remove(idx);
        long endTime = System.nanoTime();

        System.out.println(endTime-startTime);
    }

    public static void linkedListMethods(LinkedList<Integer> linkedList){
       linkedList.add(-1);

       linkedList.get(0);

       System.out.println(linkedList.contains(11));

       //이하 ArrayList에는 없음
       System.out.println(linkedList.pop());    //same with 'poll','remove', remove first element and return that
         System.out.println(linkedList.pollLast());
       System.out.println(linkedList.getLast());

    }
}
