package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		TreeMap<Integer,Integer> mp = new TreeMap<Integer,Integer>();
		Set<Integer> set = new TreeSet<Integer>();
		
	}
	
	
	
	
	/***********************************************************************/
	static int abs(int a) {
		return Math.abs(a);
	}
	
	static int min(int a, int b) {
		return Math.min(a, b);
	}
	
	static int max(int a, int b) {
		return Math.max(a, b);
	}
	
	static long gcd(long a,long b) {
		if(b!=0) return gcd(b,a%b);
		else return a;
	}

	static void debug(int[] a) {
		for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
		System.out.println();
	}
	
	static void sort(int[] a,boolean reverse) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		if(reverse) Collections.sort(l,Collections.reverseOrder());	
		else Collections.sort(l); 
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	
	static int lowerbound(int[] a,int x) {
		int s=0,e=a.length;
		while(s<e) {
			int mid = (s+e)/2;
			if(a[mid]>=x) e=mid;
			else s=mid+1;
		}
		return e;
	}
	
	static class Pair<F,S>{
		final F fs;
		final S sc;
		
		public Pair(F fs,S sc){
			this.fs=fs;
			this.sc=sc;
		}
		
		static <F,S> Pair<F,S> of(F fs,S sc){
			return new Pair<F,S>(fs,sc);
		}
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	
}
