package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * An Executor Service is used to create multiple threads at a time.
 * 
 * Fixed Thread Executor will have fixed number of threads. The tasks will be shared by the threads. 
 */
public class FixedThreadPoolDemo {

	public static void main(String[] args) {
		try(ExecutorService service = Executors.newFixedThreadPool(2)){
			for(int i = 0;i<7;i++) {
				service.execute(new Work(i));
			}
		}
	}

}

class Work implements Runnable{
	
	private final int workId;
	
	public Work(int workId) {
		this.workId = workId;
	}

	@Override
	public void run() {
		System.out.println("Work Id " + workId + "being executed by thread " + Thread.currentThread().getName());
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}