package com.dev.designpatterns;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * This class is to test Singleton Lazy Loading thread safe runner
 * @author teluki
 *
 */
public class SingletonBetterPerformedThreadSafeRunner {

	public static void main(String[] args) throws InterruptedException {
		LocalDateTime start = LocalDateTime.now();
//		IntStream.range(0, 50).boxed().forEach(i -> SingletonBetterPerformedThreadSafeRunner.threadRunMethod());
		for(int i=0; i< 50; i++) {
			SingletonBetterPerformedThreadSafeRunner.threadRunMethod();
		}
		LocalDateTime end = LocalDateTime.now();
		System.out.println("Time Taken "+Duration.between(start, end));
		System.out.println("Time Taken BY chronical millis "+ChronoUnit.MILLIS.between(start, end));
		start = LocalDateTime.now();
//		IntStream.range(0, 50).boxed().forEach(i -> SingletonLazyLoadingThreadSafeRunner.threadRunMethod());
		for(int i=0; i< 50; i++) {
			SingletonLazyLoadingThreadSafeRunner.threadRunMethod();
		}
		end = LocalDateTime.now();
		System.out.println("Time Taken BY SingletonLazyLoadingThreadSafeRunner "+Duration.between(start, end));
		System.out.println("Time Taken BY chronical millis SLLTSR "+ChronoUnit.MILLIS.between(start, end));
	}
	
	public static void threadRunMethod() throws InterruptedException {
		Thread thread1 = new Thread(()->{
			SingletonBetterPerformedThreadSafe singletonLazyLoading1 = SingletonBetterPerformedThreadSafe.getInstance(); 
			System.out.println(singletonLazyLoading1.hashCode()+":::::SingletonBetterPerformedThreadSafe1,hashCode()");
		});
		thread1.start();
		thread1.join();
		Thread thread2 = new Thread(()->{
			SingletonBetterPerformedThreadSafe singletonLazyLoading2 = SingletonBetterPerformedThreadSafe.getInstance(); 
			System.out.println(singletonLazyLoading2.hashCode()+":::::SingletonBetterPerformedThreadSafe2,hashCode()");
		});
		thread2.start();
		System.out.println("------------------------------------------------------------------");
	}

}
