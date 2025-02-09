package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
 * An Executor Service is used to create multiple threads at a time.
 * 
 * Single Thread Executor will have only one thread and run the tasks in the sequential manner
 */
public class SingleThreadExecutorDemo {
	public static void main(String[] args) {

		try (ExecutorService service = Executors.newSingleThreadExecutor()) {

			for (int i = 0; i < 5; i++) {
				service.execute(new Task(i));
			}
		}

	}
}

class Task implements Runnable{
	
	private final int taskId;
	
	public Task(int taskId){
		this.taskId = taskId;
	}

	@Override
	public void run() {
		System.out.println("Task with Id " + taskId + " being executed by Thread" + Thread.currentThread().getName());
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
