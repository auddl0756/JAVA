package ch15_String;

public class StringIndex {
	public static void main(String[] args) {
		String s="abcdabcdabcd";
		System.out.println(s.indexOf("a"));
		System.out.println(s.indexOf('a'));
		System.out.println(s.lastIndexOf("a"));
		
		
		System.out.println(s.charAt(0));
		
		System.out.println(s.substring(0,4));
		
		
	}
}
