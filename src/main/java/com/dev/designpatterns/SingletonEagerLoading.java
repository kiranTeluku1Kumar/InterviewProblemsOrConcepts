package com.dev.designpatterns;

/**
 * This class will provide singleton class object with eager loading
 * @author teluki
 *
 */
public class SingletonEagerLoading {
	private static SingletonEagerLoading singletonEagerLoad = new SingletonEagerLoading();
	private SingletonEagerLoading() {
		
	}
	
	public static SingletonEagerLoading getInstance() {
		return singletonEagerLoad;
	}

}
