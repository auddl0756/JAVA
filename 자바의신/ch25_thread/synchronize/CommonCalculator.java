package ch25_thread.synchronize;

public class CommonCalculator {
	private int amount;
	
	public CommonCalculator() {
		amount=0;
	}
	
	//synchronized 예약어
//	public synchronized void plus(int value) {	
	//메서드 전체를 synchronized 처리를 하는 것은 성능상의 저하 유발.
	//메서드 내에서 관련된 부분만 싱크처리해 줄 수 있다
	
	Object lock = new Object();
	
	public void plus(int value) {
//		synchronized(this) {
//			amount+=value;
//		}
		synchronized(lock) {
			amount+=value;
		}
	}
	
	public void minus(int value) {
//		synchronized(this) {
//			amount-=value;
//		}
		synchronized(lock) {
			amount-=value;
		}
	}
	
	public int getAmount() {
		return amount;
	}
	
	
}
