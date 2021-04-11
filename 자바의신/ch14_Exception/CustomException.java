
public class CustomException extends Exception{
    public static void main(String[] args) {
        try{
            throwMyException(13);
        }catch(MyException me){
            me.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void throwMyException(int number) throws MyException{
        if(number>12) throw new MyException("number is over 12");

    }

}
