package ch13_Interfaces.service;

//enum 객체의 사용.
//enum 객체는 생성할 필요가 없음. 그냥 쓰면 됨. 
public class UseTimeValues {
	public int getTimeAmount(TimeValues value) {
		int ret=0;
		System.out.println(value);

		if(value.equals(TimeValues.WEEK_THREE_HOUR)) {
			ret=30000;
		}else if (value.equals(TimeValues.WEEKEND_SIX_HOUR)) {
			ret=50000;
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		UseTimeValues sample = new UseTimeValues();
		int res=sample.getTimeAmount(TimeValues.WEEK_THREE_HOUR);
		System.out.println(res);
	}
}
