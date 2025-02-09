package forkJoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SearchOccurenceTask extends RecursiveTask<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int[] arr;
	int start;
	int end;
	int searchEle; 

	public SearchOccurenceTask(int[] arr, int start, int end, int searchEle) {
		super();
		this.arr = arr;
		this.start = start;
		this.end = end;
		this.searchEle = searchEle;
	}

	
	
	@Override
	protected Integer compute() {
		int size = end+start+1;
		if(size >  50) {
			int mid = (start + end) / 2;
			SearchOccurenceTask task1 = new SearchOccurenceTask(arr, start, mid, searchEle);
			SearchOccurenceTask task2 = new SearchOccurenceTask(arr, mid+1, end, searchEle);
			
			task1.fork();
			task2.fork();
			
			return task1.join() + task2.join();
			
		} else {
			return search();
		}
		
	}
	
	private Integer search() {
		int count = 0;
		for (int i = start; i < end; i++) {
			if(arr[i] == searchEle)
				count++;
		}
		return count;
	}

}

class ForkJoinPoolDemo{
	public static void main(String[] args) {
		int arr[] = new int[100];
		Random random = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(10) + 1;
		}
		int searchElement = random.nextInt(10) + 1;
		
		try(ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors())){
			SearchOccurenceTask task = new SearchOccurenceTask(arr, 0, arr.length - 1, searchElement);
			
			Integer occurrence = pool.invoke(task);
			System.out.println("Array is : " + Arrays.toString(arr));
			System.out.printf("%d found % times", searchElement, occurrence);
		}
	}
}
