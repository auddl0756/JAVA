package ch25_thread.sample;

public class RunThreads {
	public static void main(String[] args) {
		RunThreads threads = new RunThreads();
		threads.runBasic();
	}
	
	public void runBasic() {
		RunnableSample runnable = new RunnableSample();
		new Thread(runnable).start();
		
		ThreadSample thread = new ThreadSample();
		thread.start();
		System.out.println("RUnThreads.runBasic() method is finished");
	}
}
