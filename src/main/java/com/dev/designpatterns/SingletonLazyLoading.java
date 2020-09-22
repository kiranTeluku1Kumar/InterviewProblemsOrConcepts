package com.dev.designpatterns;

/**
 * 
 * @author teluki
 *
 */
public class SingletonLazyLoading {
	
	private static SingletonLazyLoading singletonInitialization;
	
	private SingletonLazyLoading() {
		
	}

	public static SingletonLazyLoading getInstance() {
		if(singletonInitialization == null) {
			singletonInitialization = new SingletonLazyLoading();
		}
		return singletonInitialization;
	}
}
