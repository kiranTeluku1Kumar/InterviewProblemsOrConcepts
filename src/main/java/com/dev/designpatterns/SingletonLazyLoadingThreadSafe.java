package com.dev.designpatterns;

/**
 * This class is to correct the issue of singleton in multiple threaded ENV
 * @author teluki
 *
 */
public class SingletonLazyLoadingThreadSafe {
	
	private static SingletonLazyLoadingThreadSafe singletonInitialization;
	
	private String name;
	
	private SingletonLazyLoadingThreadSafe() {
		
	}

	public static synchronized SingletonLazyLoadingThreadSafe getInstance() {
		if(singletonInitialization == null) {
			singletonInitialization = new SingletonLazyLoadingThreadSafe();
		}
		return singletonInitialization;
	}

	public String getName() {
		return getInstance().name;
	}

	public void setName(String name) {
		getInstance().name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
