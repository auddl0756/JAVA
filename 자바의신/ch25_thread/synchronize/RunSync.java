package ch25_thread.synchronize;

public class RunSync {
	public static void main(String[] args) {
		RunSync sample = new RunSync();
		sample.runCommonCalculator();
	}
	
	public void runCommonCalculator() {
		CommonCalculator calc = new CommonCalculator();
		ModifyAmountThread thread1 = new ModifyAmountThread(calc,true);
		ModifyAmountThread thread2 = new ModifyAmountThread(calc,false);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
			System.out.println("final value : "+calc.getAmount());
			//multi threads on one object makes results dirty.
			//calc.getAmount must be 20000. but un synchronized multithreads result in less value.
			//because thread execute the method even though another thread is not finished.
			//"synchronized" 예약어가 이를 해결해준다!
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
