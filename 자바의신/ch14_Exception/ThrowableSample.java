public class ThrowableSample {
    public static void main(String[] args) {
        throwable();
    }

    public static void throwable(){
        int[] arr = new int[5];
        try{
//            arr=null;
            System.out.println(arr[5]);
        }catch(Throwable t){
//            t.printStackTrace();
            System.out.println(t.toString());


        }
    }
}
