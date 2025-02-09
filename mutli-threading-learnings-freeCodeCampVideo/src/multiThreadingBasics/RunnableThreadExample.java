package multiThreadingBasics;

public class RunnableThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread threadOne = new Thread(new ThreadOne());
		Thread threadTwo = new Thread(new ThreadTwo());
		
		threadOne.start();
		threadTwo.start();
		
		System.gc();

	}

}

class ThreadOne implements Runnable{

	@Override
	public void run() {
		for(int i = 0;i<5;i++)
			System.out.println("I am thread One - 1");
		
	}
}

class ThreadTwo implements Runnable{
	
	@Override
	public void run() {
		for(int i = 0 ; i< 5;i++) {
			System.out.println("I am thread Two - 2");
		}
	}
}