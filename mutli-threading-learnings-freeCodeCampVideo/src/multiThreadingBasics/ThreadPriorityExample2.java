package multiThreadingBasics;

public class ThreadPriorityExample2 {

	public static void main(String[] args) {
		// Example Two
		System.out.println(Thread.currentThread().getName() + "Says Hi");
		Thread one = new Thread(() -> {
			System.out.println("Thread 1 says Hi as well");
		});

		one.setPriority(Thread.MAX_PRIORITY);
		one.start();

	}

}
