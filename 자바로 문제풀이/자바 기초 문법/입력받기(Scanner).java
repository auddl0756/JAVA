package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UseScanner {
	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		
		List<Integer> a = new ArrayList<Integer>();

//规过 1
		//int n= sc.nextInt();		
		
		//for(int i=0;i<n;i++) {
		//	a.add(sc.nextInt());
		//}
		
//规过 2
		String[] input=sc.nextLine().split(" ");
		for(int i=0;i<input.length;i++) {
			a.add(Integer.parseInt(input[i]));
		}
		
		for(int i=0;i<input.length;i++) {
			System.out.print(a.get(i));
			System.out.print(" ");
		}System.out.println();
	}

}
