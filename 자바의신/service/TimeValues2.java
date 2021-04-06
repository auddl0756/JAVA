package ch13_Interfaces.service;

public enum TimeValues2 {
	WEEK_THREE_HOUR(30000),
	WEEKEND_SIX_HOUR(50000);
	
	private final int amount;
	
	TimeValues2(int amount){
		this.amount=amount;
	}
	
	public int getAmount() {
		return amount;
	}
}
