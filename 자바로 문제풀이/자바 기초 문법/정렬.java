package 정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//객체 정렬하기
public class 정렬 {
    public static void main(String[] args) {
        정렬 sample = new 정렬();

        List<Music> musics = new ArrayList<>();
        //access via sample and create "Music" object
        //or just make "Music" object exist using "static" keyword
	//then you can access Music object not via Outer class.
        musics.add(sample.new Music("classic",123));
        musics.add(sample.new Music("pop",1234));
        musics.add(sample.new Music("hip",12345));
        musics.add(sample.new Music("ballad",123456));

//        Collections.sort(musics,new Comparator<Music>(){
//            @Override
//            public int compare(Music o1, Music o2) {
//                return o1.played-o2.played;
//            }
//        });

        musics.sort((c1,c2)->c1.played-c2.played);

        for(int i=0;i<4;i++){
            System.out.println(musics.get(i).genre);
        }
    }

    class Music{
        String  genre;
        int played;

        Music(String genre,int played){
            this.genre=genre;
            this.played=played;
        }
    }
}




