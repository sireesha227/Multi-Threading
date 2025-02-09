package multiThreadingBasics;

public class ThreadPriorityExample {

	public static void main(String[] args) {
		
		// Example One
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		System.out.println(Thread.currentThread().getPriority());
		
		
		

	}

}
