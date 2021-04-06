package ch15_String;

public class StringCompare {
	public static void main(String[] args) {
		String s="abcdefg";
		System.out.println(s.length());
		System.out.println(s.isEmpty());
		
		String s2="abcdefgh";
		System.out.println(s.equals(s2));
		
		
		StringCompare sample = new StringCompare();
		sample.checkCompare();
		
		
		sample.checkCompareTo();
	}
	
	public void checkCompare() {
		String s1="abcd efgh";
		String s2="abcd efgh";
		
		if(s1==s2) {		//because of Constant Pool.
			System.out.println("s1 ==s2");
		}else {
			System.out.println("s1 != s2");
		}
		
		if(s1.equals(s2)) System.out.println("s1 is equals with s2");
	}
	
	public void checkCompareTo() {
		String alpha="a";
		for(char c='b';c<='z';c++) {
			String s =""+c;
			System.out.print(alpha.compareTo(s)+" ");
		}System.out.println();
	}
	
	
}
