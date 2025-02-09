package multiThreadingBasics;

/**
 * In the below scenario first run the code by commenting the join() method and see the output
 * Here the "Done executing the threads!!" will be executed first and next remaining threads will be executed
 * This is because main() function is also a thread and the CPU core will be assigned to it first 
 * Later one's the main() thread is started running it will allocated CPU core to thread one and thread two later
 * The priority will be always the main() methods. Ones it is executed then the threads will start running
 * 
 *  To resolve this or we want to print the threads are completed once they are actually completed then use .join() method
 *  .join() method will wait until the given thread is completed and starts the execution of the main thread
 */
public class JoinThreadExample {
	public static void main(String[] args) throws InterruptedException {
		Thread one = new Thread(()->{
			for(int i=0;i<10;i++)
				System.out.println("Thread1 - 1");
		});
		
		Thread two = new Thread(()->{
			for(int i=0;i<10;i++)
				System.out.println("Thread2 - 2");
		});
		
		one.start();
		two.start();
		one.join();
		two.join();
		System.out.println("Done executing the threads!!");
	}
}
