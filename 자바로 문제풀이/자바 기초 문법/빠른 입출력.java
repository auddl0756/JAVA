package ProblemSolving;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        //[InputStreamReader]
        //An InputStreamReader is a bridge from byte streams to character streams:
        // It reads bytes and decodes them into characters using a specified charset

        // [BufferedReader]
        // Reads text from a character-input stream,
        // buffering characters so as to provide for the efficient reading of characters, arrays, and lines.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try{
            //읽기 1. 정수 입력받을 때
            int n = Integer.parseInt(br.readLine());

            //읽기 2. 한 줄에 공백으로 구분된 배열을 입력받을 때
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> arr = new ArrayList<>();
            while(st.hasMoreTokens()){
                arr.add(Integer.parseInt(st.nextToken()));
            }

            //쓰기 1.
            System.out.println();

            //쓰기 2 : 이게 더 빠름.
            // 보통 BufferedReader까지 하면 충분하지만 백준같은데선 BufferedWriter까지 필요할 때도 있음
            for(int i=0;i<n;i++)  bw.write(String.valueOf(arr.get(i)));
            bw.flush();
            bw.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

