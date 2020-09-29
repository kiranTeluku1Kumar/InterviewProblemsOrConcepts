package com.dev.designpatterns;

/**
 * This class is to minimize performance issues of singleton instance creation
 * @author teluki
 *
 */
public class SingletonBetterPerformedThreadSafe {
	private static volatile SingletonBetterPerformedThreadSafe singletonBetterPerformedThreadSafe;

	private SingletonBetterPerformedThreadSafe() {
		
	}
	
	public static SingletonBetterPerformedThreadSafe getInstance() {
		if(singletonBetterPerformedThreadSafe == null) {
			synchronized (SingletonBetterPerformedThreadSafe.class) {
				if(singletonBetterPerformedThreadSafe == null) {
					singletonBetterPerformedThreadSafe = new SingletonBetterPerformedThreadSafe();
				}
			}
		}
		return singletonBetterPerformedThreadSafe;
	}
}
