package ch25_thread.sample;

public class EndlessThread extends Thread{
	//Thread.sleep() 을 사용하려면 try-catch로 묶어줘야 한다
	//exception으로 catch
	
	public void run() {
		while(true) {
			try {
				System.out.println(System.currentTimeMillis());
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
