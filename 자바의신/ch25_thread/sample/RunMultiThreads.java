package ch25_thread.sample;

public class RunMultiThreads {
	public static void main(String[] args) {
		RunMultiThreads sample = new RunMultiThreads();
		sample.runMultiThread();
	}
	
	public void runMultiThread() {
		RunnableSample[] runnables = new RunnableSample[5];
		ThreadSample[] threads = new ThreadSample[5];
		
		for(int i=0;i<5;i++) {
			runnables[i] = new RunnableSample();
			threads[i] = new ThreadSample();
			
			new Thread(runnables[i]).start();
			threads[i].start();
		}
		
		//한 thread가 다른 thread가 끝날 때 까지 기다리지 않고 그 다음 줄의 명령을 실행하기 때문에
		//가장 마지막에 있는 이 문장이 가장 마지막에 수해되는것은 아니다!
		System.out.println("RunMultipleThreads.runMultiThread() method is finished");
	}

}
