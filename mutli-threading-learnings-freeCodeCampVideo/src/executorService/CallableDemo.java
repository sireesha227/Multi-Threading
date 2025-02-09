package executorService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
 *  Till now we have seen threads which does not return any things. 
 *  
 *  But what if we want to return something from threads? How can we do this?
 *  
 *  For this we are having Callable Interface and Future
 *  
 *  Runnable Interface can useful to run the threads whereas Callable interface is used to return values from a thread
 *  
 *  Callable is a Generic Interface, which means we need to pass the Return Type as a generic. Callable<T>
 *  
 *  Callable have the method called call() and here we can return any value from threads.
 *  
 *  So this method is called. For this we need to use the submit method in executor service. 
 *  submit method will support both runnable and callable interfaces methods but execute will only supports the runnable interface.
 *  
 *  The submit will return a Future Object. The data will be populated into it once the thread execution is completed.
 *  
 *  Here we can get the result from it once the thread execution is done. So we need to handle this by giving times constraints
 *  on it.
 *  
 *  Future is having different methods. Some of them are
 *  	1) Future.cancel(true) -> It will interrupt the thread, if it running
 *  	2) Future.isCancelled() -> returns a boolean value
 *  		If a thread is cancelled then it will return true else it will return false
 *  	3) Future.isDone() -> returns a boolean value
 *  		If a thread is being completed successfully or it is interrupted an exception in both scenarios it will return true
 */
public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
		try(ExecutorService service = Executors.newFixedThreadPool(2)){
		
			Future<Integer> result = service.submit(new ReturnValueTask());
			
			// Will print the result once the thread is completed
			System.out.println(result.get()); 
			
			/*
			It wait till 1sec and checks the result is populated or not. If not it will throw an error
			If we want, we can handle the error too.
			
			In the below scenario it will throw because our thread take 5seconds to complete the task but we checking after 1 sec
			After 5sec only it will return the result and the value will be captured by future
			* 
			*/
//			System.out.println(result.get(1, TimeUnit.SECONDS));
			
			
			// The below scenario will run the task properly
			System.out.println(result.get(5,TimeUnit.SECONDS));
			
			System.out.println("Main thread execution completed");
		}	
	}

}

class ReturnValueTask implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		Thread.sleep(5000);
		return 12;
	}
	
}