package basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class UseStack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//스택 선언.
		Stack<Integer> st = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		int[] a= new int[n];
		int[] ans=new int[n];
		Arrays.fill(ans, -1);
		
		String[] input=br.readLine().split(" ");
		
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(input[i]);
		}

		
		for(int i=0;i<n;i++) {
			while(!(st.isEmpty())) {		//스택이 비었는지
				if(a[st.peek()] < a[i]) {	//스택 top 참조 : peek()
					ans[st.peek()]=a[i];
					st.pop();				//스택 top 제거 : pop()
				}else break;
			}
			
			st.push(i);						//스택 top에 넣기 : push()
		}
		
		for(int i=0;i<n;i++) {
			bw.write(ans[i]+" ");
		}
		
		br.close();
		bw.flush();
		bw.close();

	}

}
