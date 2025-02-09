package threadSynchronization;

/**
 * synchronized keyword on method level will create problems. 
 * 
 * If the method contains large code then each thread should wait until the method execution is completed
 * 
 * In the below code, the two threads are having independent resources but still it will create a problem
 * 
 * Because each class thread will have monitor lock/ intrinsic lock. 
 * So in the below scenario in the main class we are having two threads and main thread will have only one lock.
 * So when one thread is running it will acquire the lock and second thread will wait until lock got released weather it
 * has no dependency on the other threads.
 * 
 */
public class SynchronizationDemo {
	private static int counter1 = 0;
	private static int counter2 = 0;

	public static void main(String[] args) throws InterruptedException {
		Thread one = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				getCounter1();
			}
		});

		Thread two = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				getCounter2();
			}
		});

		one.start();
		two.start();
		one.join();
		two.join();

		System.out.println("Counter Value = " + counter1 + "Counter2 Value = " + counter2);
	}
	
	private synchronized static void getCounter1() {
		counter1++;
	}
	
	private synchronized static void getCounter2() {
		counter2++;
	}
}
