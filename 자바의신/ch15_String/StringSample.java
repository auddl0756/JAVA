package ch15_String;

public class StringSample {
	public static void main(String[] args) {
		StringSample sample = new StringSample();
		String korean="한글";
		sample.convert(korean);
	}
	
	public void convert(String s) {		
		try {
			byte[] arr = s.getBytes("UTF-16");
			printBytes(arr);
			
			String korean2 = new String(arr,"UTF-16");
			System.out.println(korean2);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void printBytes(byte[] arr) {
		for (byte b : arr) {
			System.out.print(b+" ");
		}System.out.println();
	}
}
