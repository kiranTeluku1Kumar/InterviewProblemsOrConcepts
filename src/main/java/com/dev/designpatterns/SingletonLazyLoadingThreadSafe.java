package com.dev.designpatterns;

/**
 * This class is to correct the issue of singleton in multiple threaded ENV
 * @author teluki
 *
 */
public class SingletonLazyLoadingThreadSafe {
	
	private static SingletonLazyLoadingThreadSafe singletonInitialization;
	
	private SingletonLazyLoadingThreadSafe() {
		
	}

	public static synchronized SingletonLazyLoadingThreadSafe getInstance() {
		if(singletonInitialization == null) {
			singletonInitialization = new SingletonLazyLoadingThreadSafe();
		}
		return singletonInitialization;
	}
}
