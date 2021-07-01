import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	static final int MAX=Integer.MAX_VALUE;
	static final long LMAX =Long.MAX_VALUE;
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		Map<Integer,Integer> mp = new TreeMap<>();
		Set<Integer> set = new TreeSet<Integer>();
		Queue<Integer> que= new LinkedList<Integer>();
		PriorityQueue<pii<Integer,Integer>> pq = new PriorityQueue<>();
		
		
	}
	
	/***********************************************************************/
	static int gcd(int a,int b) {
		if(b!=0) return gcd(b,a%b);
		else return a;
	}
	
	static long gcd(long a,long b) {
		if(b!=0) return gcd(b,a%b);
		else return a;
	}

	static void debug(int[] a) {
		for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
		System.out.println();
	}
	
	static void debug(long[] a) {
		for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
		System.out.println();
	}
	
	static<F,S> void debug_pii(pii<F,S>[] a) {
		for(int i=0;i<a.length;i++) System.out.print("("+a[i].fs+","+a[i].sc+")");
		System.out.println();
	}
	
	static<T> void debug(List<T> a) {
		for(int i=0;i<a.size();i++) System.out.print(a.get(i)+" ");
		System.out.println();
	}
	
	static<F,S> void debug_pii(List<pii<F,S>> a) {
		for(int i=0;i<a.size();i++) System.out.print("("+a.get(i).fs+","+a.get(i).sc+")");
		System.out.println();
	}

	static void swap(int[] a,int idx1,int idx2) {
		int tmp=a[idx1];
		a[idx1]=a[idx2];
		a[idx2]=tmp;
	}
	
	static void sort(int[] a) {
		List<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);	
		Collections.sort(l); 
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	
	static void rsort(int[] a) {
		List<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l,Collections.reverseOrder()); 
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	
	static void sort(List<Integer> a) {
		Collections.sort(a);
	}
	
	static void rsort(List<Integer> a) {
		Collections.sort(a,Collections.reverseOrder());
	}
	
	static void sort_pii(List<pii<Integer,Integer>> a) {
		Collections.sort(a);
	}
	
	static void rsort_pii(List<pii<Integer,Integer>> a) {
		Collections.sort(a,Collections.reverseOrder());
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
	
	static int lowerbound(List<Integer> a,int x) {
		int s=0,e=a.size();
		while(s<e) {
			int mid=(s+e)/2;
			if(a.get(mid)>=x) e=mid;
			else s=mid+1;
		}
		return e;
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
		
		ArrayList<Integer> readArrayList(int n){
			ArrayList<Integer> a =new ArrayList<Integer>();
			for(int i=0;i<n;i++) a.add(nextInt());
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		long[] readArray_long(int n) {
			long[] a=new long[n];
			for(int i=0;i<n;i++) a[i]=nextLong();
			return a;
		}	
	}
	
	static class pii<F,S> implements Comparable<pii<F,S>>{
		final F fs;
		final S sc;
		
		public pii(F fs,S sc){
			this.fs=fs;
			this.sc=sc;
		}
		
		static <F,S> pii<F,S> of(F fs,S sc){
			return new pii<F,S>(fs,sc);
		}
		
		public int compareTo(pii<F,S> o) {
			if((int)this.fs<(int)o.fs) return -1;
			else if((int)this.fs==(int)o.fs) {
				if((int)this.sc<=(int)o.sc) return -1;
				else return 1;
			}
			return 1;
		}

		
	}
	
	static class ppi<F,S,S2>{
		final F fs;
		final S sc;
		final S2 sc2;
		
		public ppi(F fs,S sc,S2 sc2) {
			this.fs=fs;
			this.sc=sc;
			this.sc2=sc2;
		}
		
		static <F,S,S2> ppi<F,S,S2> of(F fs,S sc,S2 sc2){
			return new ppi<F,S,S2>(fs,sc,sc2);
		}
	}
	
	static class pipi<F,S,F2,S2>{
		final F fs;
		final S sc;
		final F fs2;
		final S2 sc2;
		
		public pipi(F fs,S sc,F fs2,S2 sc2) {
			this.fs=fs;
			this.sc=sc;
			this.fs2=fs2;
			this.sc2=sc2;
		}
		
		static <F,S,F2,S2> pipi<F,S,F2,S2> of(F fs,S sc,F fs2,S2 sc2){
			return new pipi<F,S,F2,S2>(fs,sc,fs2,sc2);
		}
	}
	
	static int abs(int a) {
		return Math.abs(a);
	}
	static long abs(long a) {
		return Math.abs(a);
	}
	
	static int min(int a, int b) {
		return Math.min(a, b);
	}
	static long min(long a,long b) {
		return Math.min(a, b);
	}
	
	static int max(int a, int b) {
		return Math.max(a, b);
	}
	
	static long max(long a,long b) {
		return Math.max(a, b);
	}

	static int max(int[] a) {
		int mx=a[0];
		for(int i=1;i<a.length;i++) if(mx<a[i]) mx=a[i];
		return mx;
	}
	
	static int min(int[] a) {
		int mn=a[0];
		for(int i=1;i<a.length;i++) if(mn>a[i]) mn=a[i];
		return mn;
	}
	
	static int max(List<Integer> a) {
		int mx=a.get(0);
		for(int i=1;i<a.size();i++) if(mx>a.get(i)) mx=a.get(i); 
		return mx;
	}
	
	static int min(List<Integer> a) {
		int mn=a.get(0);
		for(int i=1;i<a.size();i++) if(mn<a.get(i)) mn=a.get(i); 
		return mn;
	}
	
}

