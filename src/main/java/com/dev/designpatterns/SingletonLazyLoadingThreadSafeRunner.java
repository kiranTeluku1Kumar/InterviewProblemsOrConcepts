package com.dev.designpatterns;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

/**
 * This class is to test Singleton Lazy Loading thread safe runner
 * @author teluki
 *
 */
public class SingletonLazyLoadingThreadSafeRunner {

	public static void main(String[] args) throws InterruptedException {
		LocalDateTime start = LocalDateTime.now();
		IntStream.range(0, 1).boxed().forEach(i -> {
			try {
				SingletonLazyLoadingThreadSafeRunner.threadRunMethod();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		LocalDateTime end = LocalDateTime.now();
		System.out.println("Time Taken "+Duration.between(start, end));
	}
	
	public static void threadRunMethod() throws InterruptedException{
		Thread thread1 = new Thread(()->{
			SingletonLazyLoadingThreadSafe singletonLazyLoading1 = SingletonLazyLoadingThreadSafe.getInstance(); 
			singletonLazyLoading1.setName("singletonLazyLoading1");
			System.out.println(singletonLazyLoading1.hashCode()+":::::SingletonLazyLoadingThreadSafe1,hashCode()::"+singletonLazyLoading1);
		});
		thread1.start();
		thread1.join();
		Thread thread2 = new Thread(()->{
			SingletonLazyLoadingThreadSafe singletonLazyLoading2 = SingletonLazyLoadingThreadSafe.getInstance(); 
			singletonLazyLoading2.setName("singletonLazyLoading2");
			System.out.println(singletonLazyLoading2.hashCode()+":::::SingletonLazyLoadingThreadSafe2,hashCode()::"+singletonLazyLoading2);
		});
		thread2.start();
		System.out.println("------------------------------------------------------------------");
	}

}
