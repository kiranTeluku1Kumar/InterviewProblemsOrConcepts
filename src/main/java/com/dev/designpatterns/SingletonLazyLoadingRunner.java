package com.dev.designpatterns;

/**
 * This class is to test Singleton Eager Loading 
 * @author teluki
 *
 */
public class SingletonLazyLoadingRunner {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * SingletonLazyLoading singletonLazyLoading1 =
		 * SingletonLazyLoading.getInstance(); SingletonLazyLoading
		 * singletonLazyLoading2 = SingletonLazyLoading.getInstance(); //Here we can see
		 * both instances are having same hash code which will prove singleton design
		 * pattern System.out.println(singletonLazyLoading1.hashCode()+"<-- 1:::2-->"
		 * +singletonLazyLoading2.hashCode());
		 */
		
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
