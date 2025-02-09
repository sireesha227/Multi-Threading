package concurrentCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
 * The collections in java are not thread safe. To make them as thread safe we are having two options
 * 		1) Use Collections.Synchronize() method
 * 		2) Use the concurrent collections which are synchronized
 *
 * Run the below code and see the length output. Ideally the size should be 2000 but in the below case it will be not like that.
 * 
 * So use Synchronized Collections
 * 
 * Disadvantages of using Synchronized Collections
 * 	1) Coarse Grained Locking
 * 			It uses a single lock to synchronize all the operations on the collections. That means there will be one thread can 
 * 			access the collection at a given point of time. This will reduce the speed or concurrency if multiple threads are 
 * 			using the same collection.
 * 	2) Limited Functionality
 * 	3) No Fail Fast Iterators
 * 			Collections returned by Collections.Synchorize() method will not return any fail fast iterators.
 *  
 * 			The fail fast iterator throw a concurrent modification exception if the collection is structurally modified when an 
 * 			iterator is iterate overhead. 
 * 			
 * 			Without Fail Fast Iterators it is possible for concurrent modifications to the collections unnoticed and 
 * 			this leads to certain unexpected behaviors.
 * 	4) Performance Overhead
 */
public class SynchornisedCollections {

	public static void main(String[] args) throws InterruptedException {
		
		// Normal collection which is not thread safe
//		List<Integer> list = new ArrayList<>();
		
		// The below list is thread safe because we used synchronized list
		List<Integer> list = Collections.synchronizedList(new ArrayList<>());
		
		Thread one = new Thread(() -> {
			for(int i=0;i<1000;i++) {
				list.add(i);
			}
		});
		
		Thread two = new Thread(() -> {
			for(int i=0;i<1000;i++) {
				list.add(i);
			}
		});
		
		one.start();
		two.start();
		
		one.join();
		two.join();
		
		System.out.println("The size of the list is " + list.size());
	}

}
