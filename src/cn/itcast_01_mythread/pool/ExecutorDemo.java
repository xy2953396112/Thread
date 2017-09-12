package cn.itcast_01_mythread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 列出并发包中的各种线程池
 * @author
 *
 */

public class ExecutorDemo {
	
	public static void main(String[] args) {
		//单线程池  只有一个线程的线程池，因此所有提交的任务是顺序执行
		//缓存线程池  如果线程超过60秒内没执行，那么将被终止并从池中删除，
		//线程数量固定的线程池
		//可调度的线程池  只有一个线程，用来调度任务在指定时间执行  用来调度即将执行的任务的线程池，可能是不是直接执行, 每隔多久执行一次... 策略型的
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		
		int cpuNums = Runtime.getRuntime().availableProcessors();
		System.out.println(cpuNums);
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(cpuNums);
		
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(8);
		
		
		ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
	}
}
