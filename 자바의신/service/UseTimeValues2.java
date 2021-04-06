package ch13_Interfaces.service;

public class UseTimeValues2 {
	public static void main(String[] args) {
		UseTimeValues2 sample = new UseTimeValues2();
		TimeValues2 value = TimeValues2.WEEK_THREE_HOUR;
		System.out.println(value);
		System.out.println(value.getAmount());
		
		
		//////////////////////////
		
		TimeValues2[] valueList = TimeValues2.values();
		for(TimeValues2 t:valueList) System.out.println(t);
	}
}
