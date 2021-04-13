package jpabook.ch7_AdvancedMapping.MappedSuperClass;

import java.util.Objects;

public class Equality {
    public static void main(String[] args) {
        System.out.println("String with same contents");
        String s= new String("aaa");
        String t = new String("aaa");

        System.out.println(s==t);
        System.out.println(s.equals(t));
        System.out.println("hashcode of new Creation of String with same contents="+s.hashCode()+" "+t.hashCode());

        String s2="aaa";
        String t2="aaa";

        System.out.println(s2==t2);
        System.out.println(s2.equals(t2));
        System.out.println("hascode of \"\" creation of String with same contents="+s2.hashCode()+" "+t2.hashCode());

//        System.out.println("Integer with same contents");
//        Integer a= 1,b=1;
//        System.out.println(a==b);
//        System.out.println(a.equals(b));
//        System.out.println(a.hashCode()+" "+b.hashCode());

        System.out.println("User Object with same with same contents");
        Node node1 = new Node(1,1025-993);
        Node node2 = new Node(2,1);
        Node node3 = node1;

        System.out.println(node1==node2);
        System.out.println(node1.equals(node2));

        System.out.println(Node.class.hashCode());
        System.out.println("hashcode = "+node1.hashCode()+" "+node2.hashCode());

        System.out.println(node1==node3);

    }

    static class Node{
        int r,c;
        public Node(int r,int c){
            this.r=r;
            this.c=c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true; //주소 같은지 비교
            //존재 확인
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            //그게 아니면 객체의 내용을 비교
            return r == node.r && c == node.c;
        }

        @Override
        public int hashCode() {
            System.out.println("hash value of this Node with r= "+r+" c= "+c+" ="+Objects.hash(r,c));
            return Objects.hash(r, c);
        }
    }
}
