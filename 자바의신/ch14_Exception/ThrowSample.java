public class ThrowSample {
    public static void main(String[] args) {
        //throwException(13);

        try{
            throwsException(13);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void throwsException(int number) throws Exception{
        if(number>12) throw new Exception("number is over 12");

        System.out.println("number = "+number);
    }

    public static void throwException(int number){
        try{
            if(number>12) throw new Exception("number is over 12");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
