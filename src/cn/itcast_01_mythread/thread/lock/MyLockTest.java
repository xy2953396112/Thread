package cn.itcast_01_mythread.thread.lock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLockTest {
	private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
	static Lock lock = new ReentrantLock();   //注意这个地方
	public static <E> void main(String[] args) {
		new Thread("thread1") {
			public void run() {
				Thread thread = Thread.currentThread();
				
				lock.lock();
				try {
					System.out.println(thread.getName() + "得到了锁");
					for (int i = 0; i < 5; i++) {
						arrayList.add(i);
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					System.out.println(thread.getName() + "释放了锁");
					lock.unlock();
				}

			};
		}.start();
		
		new Thread("thread2") {
			public void run() {
				Thread thread = Thread.currentThread();
				lock.lock();
				try {
					System.out.println(thread.getName() + "得到了锁");
					for (int i = 0; i < 5; i++) {
						arrayList.add(i);
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					System.out.println(thread.getName() + "释放了锁");
					lock.unlock();
				}

			};
		}.start();
	}

}