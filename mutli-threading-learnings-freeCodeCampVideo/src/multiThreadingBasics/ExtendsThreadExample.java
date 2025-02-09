package multiThreadingBasics;

public class ExtendsThreadExample {
	public static void main(String[] args) {
		Thread thread1 = new Thread1();
		Thread thread2 = new Thread2();
		
		thread1.start();
		thread2.start();
		
	}

}

class Thread1 extends Thread{
	@Override
	public void run() {
		for(int i = 0;i<5;i++)
			System.out.println("This is thread one - 1");
	}
}

class Thread2 extends Thread{
	@Override
	public void run() {
		for(int i = 0;i<5;i++)
			System.out.println("This is thread two - 2");
	}
}
