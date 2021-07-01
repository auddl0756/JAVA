package basic;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class UseQueue{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		Queue<Integer> q = new LinkedList<>();
		
		//1. push
		q.add(Integer.parseInt(br.readLine()));	//also possible : offer()
		q.add(Integer.parseInt(br.readLine()));
		q.offer(Integer.parseInt(br.readLine()));
		
		//2.pop
		q.remove();	//also possible : poll()
		
		//3.첫번째 값 참조
		System.out.println(q.peek());
		
		//4.마지막 값 참조
		//linked list로 큐를 구현했기 때문에 1번째 값 참조는 O(1)이지만 
		//마지막 값 참조는 O(n)이 걸린다.
		//배열로 바꿔서 마지막 값을 참조해볼 수 있다.
		System.out.println(q.toArray()[q.size()-1]);
		
		br.close();
		bw.flush();
		bw.close();

	}

}
