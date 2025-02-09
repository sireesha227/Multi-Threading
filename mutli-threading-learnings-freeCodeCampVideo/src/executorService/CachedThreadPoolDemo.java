package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * An Executor Service is used to create multiple threads at a time.
 * 
 * Cached Thread Executor will have no fixed number of threads. Based on the tasks it will create the threads
 */
public class CachedThreadPoolDemo {

	public static void main(String[] args) {
		try(ExecutorService service = Executors.newCachedThreadPool()){
			for(int i = 0 ;i<1000;i++) {
				service.execute(new Task1(i));
			}
		}
	}

}

class Task1 implements Runnable{
	
	private final int taskId;
	
	public Task1(int taskId){
		this.taskId = taskId;
	}

	@Override
	public void run() {
		System.out.println("Task with Id " + taskId + " being executed by Thread " + Thread.currentThread().getName());
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}