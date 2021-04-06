package basic;

import java.io.*;
import java.util.Arrays;

public class useArray {
	public static void main(String[] args) throws IOException{
		
	//<console io>
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		int n= Integer.parseInt(br.readLine());
		
		//선언,할당
		int[] a = new int[n];
		
		//초기화
		Arrays.fill(a, 0);
		
		//초기화 2
		for(int i=0;i<n;i++) a[i]=0;
		
		
		//입력 : 1 2 3 4
		String[] input = br.readLine().split(" ");
		for(int i=0;i<input.length;i++)
			a[i]=Integer.parseInt(input[i]);
		
		
		//출력
		for(int x:a)
			bw.write(String.valueOf(x)+" ");
		
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}

