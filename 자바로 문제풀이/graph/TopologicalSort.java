package basic;

import java.io.*;
import java.util.*;

public class TopologicalSort {
	//전역으로 사용하려면 static붙이고 scope밖에 쓰면 됨.
	static int n,m;
	static int[] inDegree;
	//static int[][] graph;
	static List<Integer>[] graph;
	static List<Integer> ans;
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static public boolean tpsort(int n) throws IOException {
		//pq 안쓰고 Queue만 써도 됨.
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		ans = new ArrayList<Integer>();
		
		for(int i=1;i<=n;i++)
			if(inDegree[i]==0) pq.add(i);
		
		for(int i=1;i<=n;i++) {
			
			if(pq.isEmpty()) return false;
			
			int from = pq.remove();
			ans.add(from);
			//bw.write("from.size = "+graph[from].size()+"\n");
			for(int j=0;j<graph[from].size();j++) {
				int to =graph[from].get(j);
				
				inDegree[to]-=1;
				
				if(inDegree[to]==0) pq.add(to);
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		
		String[] inputs=br.readLine().split(" ");
		n=Integer.parseInt(inputs[0]);
		m=Integer.parseInt(inputs[1]);
		
		inDegree = new int[n+1];
		Arrays.fill(inDegree, 0);
		
		//그래프 초기화. c++에서 vector<int>[MAX]와 같은.
		graph = new ArrayList[n+1];
		for(int i=1;i<=n;i++)
			graph[i]=new ArrayList<Integer>();
		
		int u,v;
		for(int i=0;i<m;i++) {
			inputs=br.readLine().split(" ");
			u=Integer.parseInt(inputs[0]);
			v=Integer.parseInt(inputs[1]);
			
			graph[u].add(v);
			inDegree[v]++;
		}
		
		boolean possible= tpsort(n);
		if(possible) {
			for(int x:ans)
				bw.write(String.valueOf(x)+" ");
		}
		
		
		br.close();
		bw.flush();
		bw.close();
	}
}

