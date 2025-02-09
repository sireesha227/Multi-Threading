package threadSynchronization;


// If we want to stop the thread execution we need to use volatile keyword

// See the below example 
public class ProducerAndConsumerDemo2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Worker1 worker = new Worker1();
		
		Thread one = new Thread(() -> {
			try {
				worker.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread two = new Thread(() -> {
			try {
				worker.consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		one.start();
		two.start();
		
		
		Thread.sleep(4500); // Each thread takes 500 milliseconds to complete the two threads it will take 4500. Calculate from 0
		worker.stop();

	}

}

class Worker1{
	private static int sequence = 0;
	private final Object LOCK = new Object();
	
	private volatile boolean running = true;
	
	public void produce() throws InterruptedException {
		synchronized (LOCK) {
//			while (true) {
			while (running) {
				sequence++;

//				if (sequence == 5) {
//					sequence = 0;
//					}

				System.out.println("sequence " + sequence + " added to the container");

				LOCK.notify();
				LOCK.wait();

				Thread.sleep(500);
			}
		}
	}
	
	public void consume() throws InterruptedException {
		synchronized (LOCK) {
//			while (true) {
			while (running) {
				System.out.println("sequence " + sequence + " removed from the container");
					
				LOCK.notify();
				LOCK.wait();

				Thread.sleep(500);
			}
		}
	}
	
	public void stop() {
		running = false;
		synchronized (LOCK) {
			LOCK.notifyAll();
		}
	}
}