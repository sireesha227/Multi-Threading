package threadSynchronization;

import java.util.ArrayList;
import java.util.List;


/**
 * PRODCUER - CONSUMERE PROBLEM
 * 
 * This one of famous problem or example in multi threading using wait() and notify()
 * 
 * A producers will continuously produce the data till the container is full and the consumers will consume the data
 * till the container is empty. This is a never ending process.
 */
public class ProducerCosumer {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Worker worker = new Worker(5,0);
		
		Thread producer = new Thread(() -> {
			try {
				worker.produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread consumer = new Thread(() -> {
			try {
				worker.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		producer.start();
		consumer.start();

	}

}

class Worker{
	private int sequence = 0;
	private final Integer top;
	private final Integer bottom;
	private final List<Integer> container;
	private final Object LOCK = new Object();
	
	public Worker(Integer top, Integer bottom) {
		this.top = top;
		this.bottom = bottom;
		this.container = new ArrayList<Integer>();
	}
	
	public void produce() throws InterruptedException {
		synchronized (LOCK){
			while(true) {
				if(this.container.size() == top) {
					System.out.println("Container full, waiting for items to be removed");
					LOCK.wait();
				}
				else {
					System.out.println("sequence " + sequence + " added to the container");
					container.add(sequence++);
					LOCK.notify();
				}
				
				Thread.sleep(500);
			}
		}
	}
	
	public void consume() throws InterruptedException {
		synchronized (LOCK){
			while(true) {
				if(this.container.size() == bottom) {
					System.out.println("Container empty, waiting for items to be added");
					LOCK.wait();
				}
				else {
					System.out.println("sequence " + container.removeFirst() + " removed from the container");
					LOCK.notify();
				}
				
				Thread.sleep(500);
			}
		}
	}
}