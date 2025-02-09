package multiThreadingBasics;

/**
 * The Daemon Thread will stop executing once the UserThread is done with its execution. 
 * So Until UserThread is not completed the Daemon thread will run once the UserThreads is completed the Daemon Thread
 * will be stopped.
 * 
 * This is done by JVM itself.
 * 
 * Daemon Thread -> The threads which run background. They start once the main thread is started and 
 * stopped once the User threads or main thread is completed
 */
public class DaemonUserThreadDemo {

	public static void main(String[] args) {
		Thread backgroundThread = new Thread(new DaemonThread());
		Thread userThread = new Thread(new UserThread());
		
		// will set the background thread as a daemon thread
		backgroundThread.setDaemon(true);
		
		backgroundThread.start();
		userThread.start();

	}

}

class DaemonThread implements Runnable{

	@Override
	public void run() {
		int count = 0;
		while(count < 500) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			System.out.println("Daemon helper Running....");
		}
		
	}
	
}

class UserThread implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("User thread done with execution...");
	}
	
}
