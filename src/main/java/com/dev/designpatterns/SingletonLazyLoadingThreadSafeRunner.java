package com.dev.designpatterns;

import java.util.stream.IntStream;

/**
 * This class is to test Singleton Lazy Loading thread safe runner
 * @author teluki
 *
 */
public class SingletonLazyLoadingThreadSafeRunner {

	public static void main(String[] args) throws InterruptedException {
		IntStream.range(0, 50).boxed().forEach(i -> SingletonLazyLoadingThreadSafeRunner.threadRunMethod());
	}
	
	public static void threadRunMethod() {
		Thread thread1 = new Thread(()->{
			SingletonLazyLoadingThreadSafe singletonLazyLoading1 = SingletonLazyLoadingThreadSafe.getInstance(); 
			System.out.println(singletonLazyLoading1.hashCode()+":::::SingletonLazyLoadingThreadSafe2,hashCode()");
		});
		thread1.start();
		Thread thread2 = new Thread(()->{
			SingletonLazyLoadingThreadSafe singletonLazyLoading2 = SingletonLazyLoadingThreadSafe.getInstance(); 
			System.out.println(singletonLazyLoading2.hashCode()+":::::SingletonLazyLoadingThreadSafe2,hashCode()");
		});
		thread2.start();
		System.out.println("------------------------------------------------------------------");
	}

}
