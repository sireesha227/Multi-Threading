package multiThreadingBasics;

/***
 * This example shows, In general the programs will run in sequentialManner
 */
public class SequentialExecution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		demo1();
		demo2();

	}
	
	private static void demo1() {
		for(int i = 0;i<5;i++)
			System.out.println("I am demo1");
	}
	
	private static void demo2() {
		for(int i = 0;i<5;i++)
			System.out.println("I am demo2");
	}

}
