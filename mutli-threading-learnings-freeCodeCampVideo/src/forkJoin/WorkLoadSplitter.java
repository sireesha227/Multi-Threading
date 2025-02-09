package forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class WorkLoadSplitter extends RecursiveAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final long workload;
	public WorkLoadSplitter(long workload) {
		super();
		this.workload = workload;
	}
	
	@Override
	protected void compute() {
		
		if (workload > 16) {
			System.out.println("Work load too big!! So splitting : " + workload);
			long firstWorkload = workload / 2;
			long secondWorkload = workload - firstWorkload;

			WorkLoadSplitter firstSplit = new WorkLoadSplitter(firstWorkload);
			WorkLoadSplitter secondSplit = new WorkLoadSplitter(secondWorkload);
			
			firstSplit.fork();
			secondSplit.fork();

		}
		
		else {
			System.out.println("Work load with in limits! Task being executed for workload :" + workload);
		}
	}
	
}

class WorkLoadSplitDemo {
	public static void main(String[] args) {
		try(ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors())){
			WorkLoadSplitter workLoadSplitter = new WorkLoadSplitter(128);
			pool.invoke(workLoadSplitter);
		}
		
		
	}
}
