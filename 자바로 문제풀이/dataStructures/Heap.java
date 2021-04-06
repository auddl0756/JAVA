package Greedy;

import java.util.PriorityQueue;

public class Heap {
    public static void main(String[] args) {
        // 선언
        PriorityQueue<Info> pq = new PriorityQueue<>();

        //pq에 정수를 담으려면 이런 식으로 사용
        // min heap
        //PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        //max heap
        //PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        // 값 넣기 (pq.offer()도 가능)
        pq.add(new Info(1,1));
        pq.add(new Info(-1,1));
        pq.add(new Info(2,2));
        pq.add(new Info(-2,2));

        //젤 작은 값 peek. not removing
        System.out.println(pq.peek());

        //젤 작은 값 꺼내기(제거, pq.remove()도 가능)
        System.out.println(pq.poll());

        //비었는지 확인
        pq.isEmpty();

        //사이즈 확인도 가능
        pq.size();

        //포함하는지도 확인 가능. 단 linear time complexity,O(n)
        pq.contains(1);


    }

    //pq에 객체를 쓰려면 pq에 대소 비교 기준을 제공하기 위해 Comparable을 구현해야 함.(compareTo 메서드 구현)
    static class Info implements Comparable<Info>{
        int val;
        int AbsVal;

        public Info(int val,int AbsVal){
            this.val=val;
            this.AbsVal=AbsVal;
        }

        @Override
        public int compareTo(Info o) {
            //natural ordering(오름차순) : this<=o -> -1리턴해야 함
            if(this.AbsVal <o.AbsVal){
                return -1;
            }else if(this.AbsVal==o.AbsVal){
                return this.val<=o.val ? -1:1;
            }else return 1;
        }
    }
}
