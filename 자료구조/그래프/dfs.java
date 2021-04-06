package basic;

import java.io.*;
import java.util.*;

public class TopologicalSort {
 	static List<Integer> graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		
		int n=fs.nextInt(),m=fs.nextInt();
		graph=new ArrayList[n];
		for(int i=0;i<n;i++) graph[i]=new ArrayList<Integer>();
		visited= new boolean[n+1];

		for(int i=0;i<m;i++){
		 int u=fs.nextInt(),v=fs.nextInt();
		 graph[u].add(v);
		 graph[v].add(u);
		}

		for(int i=0;i<n;i++){
		 if(visited[i]) continue;
		 dfs(i);
		}

	}

	static void dfs(int here){
	 visited[here]=true;
	 System.out.println(here+" ");
	 for(int nxt:graph[here]) if(visited[nxt]==false) dfs(nxt);

	}

}

