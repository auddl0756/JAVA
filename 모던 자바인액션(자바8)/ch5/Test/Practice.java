package Java8.ch5.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Practice {
    static List<Transaction> transactions;
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

         transactions= Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

         //p4();
//        p6();
        p7();
    }

    public static void p7(){
        // 7. 전체 트랜잭션 중 최댓값/최솟값은?
        Optional<Integer> max=transactions.stream()
                .map(Transaction::getValue)
                .reduce((a,b)->Integer.max(a,b));

        System.out.println(max);

        //다른 방법
        Optional<Transaction> min = transactions.stream()
                .reduce((t1,t2)->t1.getValue()<t2.getValue() ? t1:t2);

        System.out.println(min);

        //다른방법 2
        min= transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));

        System.out.println(min);

    }

    public static void p6(){
        // 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오
        transactions.stream()
                .filter(t->t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    public static void p5(){
        //5.밀라노에 거래자가 있는지?
        transactions.stream()
                .anyMatch(t->t.getTrader().getCity().equals("Milan"));
    }

    public static void p4(){
        //4.모든 거래자의 이름을 알파벳 순으로 정렬해서 반환하세요
        String res= transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce("",(name1,name2)->name1+" "+name2);

        System.out.println(res);
    }

    public static void p3(){
        // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하세요
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader->trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);
    }

    public static void p2(){
        // 2. 거래자가 근무하는 모든 도시를 중복없이 나열하세요
        transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .forEach(System.out::println);
    }

    public static void p1(){
        // 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하세요
        transactions.stream()
                .filter(x-> x.getYear()==2011)
                //.sorted((t1,t2)->t1.getValue()-t2.getValue())
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);
    }


}
