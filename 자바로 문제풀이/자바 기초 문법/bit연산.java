 public static void main(String[] args) {
        //205 = 11001101(2)
        System.out.println(Integer.toBinaryString(205));    //이진수 표현
        System.out.println(Integer.bitCount(205));  //이진수로 표현했을 때 1인 비트가 몇개인지 리턴
        System.out.println(Integer.highestOneBit(205)); //Returns an int value with at most a single one-bit
        System.out.println(Integer.lowestOneBit(205));
        int LeftRotated = Integer.rotateLeft(205,1);
        System.out.println(Integer.toBinaryString(LeftRotated));
        
        //Long 타입도 위의 것듫을 사용 가능        
        System.out.println(Long.bitCount(205));
        
//        int RightRotated = Integer.rotateRight(205,1);
//        System.out.println(Integer.toBinaryString(RightRotated));

    }
