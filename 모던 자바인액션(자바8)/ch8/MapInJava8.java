package Java8.ch8;

import java.util.*;

public class MapInJava8 {
    static Map<String,String> favouriteSkills = new HashMap<>();   //filed,name

    public static void main(String[] args) {
        favouriteSkills.put("Lee","JPA");
        favouriteSkills.put("Kim","MySQL");
        favouriteSkills.put("Park","JAVA");
        favouriteSkills.put("Hong","Spring");

        //forEachMethod();
        //SortMap();
        //GetDefault();
        ComputeIfAbsent();
        Replace();
    }

    public static void Replace(){
        favouriteSkills.replaceAll((name,skill)->skill.toLowerCase());
        System.out.println(favouriteSkills);
    }

    public static void ComputeIfAbsent(){
        List<String> languages= new ArrayList<>();
        languages.add("java");
        languages.add("c++");
        languages.add("python");
        languages.add("java");

        Map<String,Integer> languagePerPersons = new HashMap<>();

        for(String lang:languages){
            languagePerPersons.computeIfAbsent(lang,x->0);
            languagePerPersons.replace(lang,languagePerPersons.get(lang)+1);
        }

        System.out.println(languagePerPersons);


    }

    public static void GetDefault(){
        System.out.println(favouriteSkills.getOrDefault("SomeOne","-1"));
        System.out.println(favouriteSkills.getOrDefault("Lee","-1"));
    }



    public static void SortMap(){
//        favouriteSkills.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByKey())
//                .forEachOrdered(System.out::println);


        favouriteSkills.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(System.out::println);

        //forEachOrdered
            //Performs an action for each element of this stream,
            // in the encounter order of the stream if the stream has a defined encounter order.

    }


    public static void forEachMethod(){
        Map<String,Integer> ageOfMen = new HashMap<>();
        ageOfMen.put("lee",20);
        ageOfMen.put("kim",30);
        ageOfMen.put("han",40);

        ageOfMen.forEach((name,age)-> System.out.println(name+" "+age));

    }
}
