package com.dev.designpatterns;

/**
 * This class is to test Singleton lazy Loading thread safe test which is to prove sometimes it is failing in singleton 
 * @author teluki
 *
 */
public class SingletonLazyLoadingDrawBackRunner {

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(()->{
			SingletonLazyLoading singletonLazyLoading1 = SingletonLazyLoading.getInstance(); 
			System.out.println(singletonLazyLoading1.hashCode()+":::::singletonLazyLoading1,hashCode()");
		});
		thread1.start();
		Thread thread2 = new Thread(()->{
			SingletonLazyLoading singletonLazyLoading2 = SingletonLazyLoading.getInstance(); 
			System.out.println(singletonLazyLoading2.hashCode()+":::::singletonLazyLoading2,hashCode()");
		});
		thread2.start();
	}

}
