package concurrentCollections;

import java.util.concurrent.CountDownLatch;

public class Restaurant {

	public static void main(String[] args) throws InterruptedException {
		
		int numberOfChefs = 3;
		
		CountDownLatch latch = new CountDownLatch(numberOfChefs);
		new Thread(new Chef("Chef A","Pizza",latch)).start();
		new Thread(new Chef("Chef B","Pani Puri",latch)).start();
		new Thread(new Chef("Chef C","KFC",latch)).start();
		
		latch.await();
		
		System.out.println("All the dishes are ready... Lets serve them..");
	}

}

class Chef implements Runnable{
	
	private final String name;
	private final String dish;
	private final CountDownLatch latch;
	
	public Chef(String name, String dish, CountDownLatch latch) {
		this.name = name;
		this.dish = dish;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			System.out.println(name + " is preparing " + dish );
			Thread.sleep(2000);
			System.out.println(name + " has prepared finishing " + dish);
			latch.countDown();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
}