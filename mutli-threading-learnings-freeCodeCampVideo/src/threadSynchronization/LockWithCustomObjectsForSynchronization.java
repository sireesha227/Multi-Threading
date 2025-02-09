package threadSynchronization;

/**
 * In the below scenario we handled the threads with customized locks. Each thread have its own lock and
 * we used the block level synchronization
 */
public class LockWithCustomObjectsForSynchronization {
	
	private static int count1 = 0;
	private static int count2 = 0;
	
	private static final Object lock1 = new Object();
	private static final Object lock2 = new Object();
	
	
	public static void main(String[] args) {
		
		Thread one = new Thread(() ->{
			for(int i= 0;i<10000;i++)
				getCount1();
		});
		
		Thread two = new Thread(() ->{
			for(int i= 0;i<10000;i++)
				getCount2();
		});
		
		one.start();
		two.start();
		
		try {
			one.join();
			two.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count1 = " + count1 + "\nCount2 = " + count2);
	}
	
	private static void getCount1() {
		synchronized(lock1) {
			count1++;
		};
	}
	
	private synchronized static void getCount2() {
		synchronized(lock2) {
			count2++;
		};
	}

}
