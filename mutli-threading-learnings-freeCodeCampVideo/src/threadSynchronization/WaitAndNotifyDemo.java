package threadSynchronization;

public class WaitAndNotifyDemo {
	
	private static final Object LOCK = new Object();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread one = new Thread(() -> {
			try {
				one();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Thread two = new Thread(() -> {
			try {
				two();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		one.start();
		two.start();
	}
	
	
	private static void one() throws InterruptedException{
		synchronized(LOCK){
			System.out.println("Hello from Thread1...");
			LOCK.wait();
			System.out.println("Back Again into the Thread1");
		} 
	}
	
	private static void two() throws InterruptedException{
		synchronized(LOCK){
			System.out.println("Hello from Thread2...");
			LOCK.notify();
			System.out.println("Hello from Thread2 even after notifying");
		}
	}

}
