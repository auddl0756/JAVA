package ch15_String;

public class StringNull {
	public static void main(String[] args) {
		StringNull sample = new StringNull();
		String s=null;
		System.out.println(sample.nullCheck2(s));
	}
	
	public boolean nullCheck(String s) {
		System.out.println(s.length());
		return s==null ? true : false; 	
	}
	
	public boolean nullCheck2(String s) {
		if(s==null) {
			return true;
		}else {
			System.out.println(s.length());
			return false;
		}
	}
}
