package executorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * An Executor Service is used to create multiple threads at a time.
 * 
 * Scheduled Thread Executor will have threads in a schedule manner. Here we need to mention after how much time the 
 * next thread should run.
 * 
 * Based on that the tasks will be placed in a priority queue and once the thread is available then it will run the next
 * task.
 */
public class ScheduledExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
		service.scheduleAtFixedRate(new ProbeTask(), 1000, 2000, TimeUnit.MILLISECONDS);
		
		// This is to terminate the service
		try {
			if(!service.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
				service.shutdownNow();
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

class ProbeTask implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Probing endpoints for updates...");
	}
	
}