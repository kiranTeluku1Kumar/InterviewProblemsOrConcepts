package com.dev.designpatterns;

/**
 * This class is to minimize performance issues of singleton instance creation
 * @author teluki
 *
 */
public class SingletonBetterPerformedThreadAndCloneSafe implements Cloneable{
	private static volatile SingletonBetterPerformedThreadAndCloneSafe singletonBetterPerformedThreadAndCloneSafe;

	private SingletonBetterPerformedThreadAndCloneSafe() {
		
	}
	
	public static SingletonBetterPerformedThreadAndCloneSafe getInstance() {
		if(singletonBetterPerformedThreadAndCloneSafe == null) {
			synchronized (SingletonBetterPerformedThreadAndCloneSafe.class) {
				if(singletonBetterPerformedThreadAndCloneSafe == null) {
					singletonBetterPerformedThreadAndCloneSafe = new SingletonBetterPerformedThreadAndCloneSafe();
				}
			}
		}
		return singletonBetterPerformedThreadAndCloneSafe;
	}
	
	@Override
	protected SingletonBetterPerformedThreadAndCloneSafe clone() throws CloneNotSupportedException {
		return singletonBetterPerformedThreadAndCloneSafe;
	}
}
