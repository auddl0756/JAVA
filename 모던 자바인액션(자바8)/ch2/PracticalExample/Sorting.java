package Java8.ch2.PracticalExample;

import java.util.ArrayList;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        //example 1
        List<Integer> samples = new ArrayList<>();
        samples.add(2);
        samples.add(1);
        samples.add(6);
        samples.add(4);

        samples.sort((x, y)-> x-y);
        for(int x:samples) System.out.println(x);

        List<Point> samples2 = new ArrayList<>();
        samples2.add(new Point(1,2));
        samples2.add(new Point(3,2));
        samples2.add(new Point(1,6));
        samples2.add(new Point(-1,-1));

        //example 2
        System.out.println("x 좌표 기준으로 정렬");
        samples2.sort((p1,p2)->p1.x-p2.x);
        for(Point p:samples2) System.out.println(p.toString());
    }


    static class Point{
        int x,y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
