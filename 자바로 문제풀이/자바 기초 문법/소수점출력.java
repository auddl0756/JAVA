import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//System.out.printf로 double형 출력
//double형은 소수점 오차 주의

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        int n= Integer.parseInt(br.readLine());
        List<Double> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(Double.parseDouble(br.readLine()));
        
        double answer =0;

        for(int front = 0; front<n;front++){
            double mul =1;
            for(int rear =front;rear<n;rear++){
                mul*=list.get(rear);
                answer = Math.max(answer,mul);
            }
        }

//        System.out.println((double)(Math.round(answer*1000))/1000);
        System.out.printf("%.3f",answer);
    }
}
