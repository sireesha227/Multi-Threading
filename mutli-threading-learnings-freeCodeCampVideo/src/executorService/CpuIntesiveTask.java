package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Each Thread is a OS level thread. So each thread will run on one core. So here we will create the threads based on the cores
 * provided by CPU. And we will use those threads only to execute the tasks.
 */
public class CpuIntesiveTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int cores = Runtime.getRuntime().availableProcessors();
		try (ExecutorService service = Executors.newFixedThreadPool(cores)) {
			System.out.println("Created thread pool with : " + cores + " cores");
			for (int i = 0; i < 20; i++) {
				service.execute(new CpuTask());
			}

		}
	}

}

class CpuTask implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Some CPU intensive task being done by : " + Thread.currentThread().getName());
	}
	
}
