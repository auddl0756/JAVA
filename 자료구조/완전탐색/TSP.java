import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import e.FastScanner;
import e.pii;

public class TSP {
	static boolean[] visited =new boolean[20];
	static int minans=1000000000;
	static int[][] cost= new int[20][20];
	
	public static void main(String[] args) {
		//FastScanner fs = new FastScanner();
		
		int n=fs.nextInt();
		
		for(int i=0;i<n;i++) for(int j=0;j<n;j++) cost[i][j]=fs.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) visited[j]=false;
			
			visited[i]=true;
			solve(n,i,i,0);
			 
		}
		System.out.println(minans);
	}
	
	/***********************************************************************/
	
	static void solve(int n,int src,int here,int c) {
		boolean finished=true;
		for(int i=0;i<n;i++) if(visited[i]==false) finished=false;
		
		if(finished) {
			if(cost[here][src]!=0) minans=min(minans,c+cost[here][src]);
			return;
		}
			
		for(int i=0;i<n;i++) {
			if(visited[i] || cost[here][i]==0) continue;
			
			visited[i]=true;
			solve(n,src,i,c+cost[here][i]);
			visited[i]=false;
		}
	
	}
}
