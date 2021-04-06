package ch15_String;

public class StringManiuplate {
	public static void main(String[] args) {
		String str="   my name is leemr";
		
		//split 
		String[] splitted = str.split(" ");
		for(String s:splitted) System.out.println(s);
		
		
		System.out.println(str);
		str =str.trim();		// 맨 앞,맨 뒤 공백 제거
		System.out.println(str);
		
		
		//replace
		String str2=str;
		System.out.println(str2.replace("m", "!"));
		str2=str;
		System.out.println(str2.replace("my", "your"));
		
		//대소문자 변환
		System.out.println(str2.toUpperCase());
		System.out.println(str2.toLowerCase());
		
		
		//문자열로 변환
		int a=123;
		String sa=String.valueOf(a);
		
		double b= 3.141592;
		String sb=String.valueOf(b);
		System.out.println(sb);
		
		System.out.println(a+b);
		System.out.println(sa+sb);
	}
}
