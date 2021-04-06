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
		
		//map 사용법
		
		//{key,value}로 넣기
		mp.put(1, 2);
		mp.put(3, 4);
		mp.put(-1, 1);
		
		//교체
		if(mp.get(1)==null) mp.put(1, 1);
		else mp.replace(1, mp.get(1)+1);
		
		//삭제
		mp.remove(1);
		
		//디버깅
		System.out.println(mp);
		
		//for each로 콜렉션타입처럼 순회 가능
		for(Map.Entry<Integer, Integer> e:mp.entrySet()) {
			int key=e.getKey();
			int value=e.getValue();
			System.out.println(key+" "+value);
		}
		
		//key들만 출력
		for(Integer i:mp.keySet()) {
			System.out.print(i+" ");
		}System.out.println();
		
		
		//values만 출력
		for(Integer v:mp.values()) {
			System.out.print(v+" ");
		}System.out.println();
		
		
	}
	
}

