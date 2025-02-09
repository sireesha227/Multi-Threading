package threadSynchronization;


/**
 * In the below example the counter should have a value of 20000 at last but it will always have a value less than this
 * 
 * Because two threads are running simultaneously and using the same shared resource counter. 
 * Both will access it at a time which will create a uncertainty. This scenario is called race condition.
 * 
 * To avoid this we need to use synchronized keyword on block lever or method level
 * 
 */
public class ThreadsRaceCondition {
	
	private static int counter = 0;

	public static void main(String[] args) throws InterruptedException {
		Thread one = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				counter++;
			}
		});

		Thread two = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				counter++;
			}
		});

		one.start();
		two.start();
		one.join();
		two.join();

		System.out.println("Counter Value = " + counter);
	}

}
