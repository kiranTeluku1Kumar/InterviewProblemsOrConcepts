package com.dev.designpatterns;

/**
 * 
 * @author teluki
 *
 */
public class SingletonLazyLoadingCloningDrawBack implements Cloneable{
	
	private static SingletonLazyLoadingCloningDrawBack singletonLazyLoadingCloningDrawBack;
	
	private SingletonLazyLoadingCloningDrawBack() {
		
	}

	public static SingletonLazyLoadingCloningDrawBack getInstance() {
		if(singletonLazyLoadingCloningDrawBack == null) {
			singletonLazyLoadingCloningDrawBack = new SingletonLazyLoadingCloningDrawBack();
		}
		return singletonLazyLoadingCloningDrawBack;
	}
	
	@Override
	protected SingletonLazyLoadingCloningDrawBack clone() throws CloneNotSupportedException {
		return (SingletonLazyLoadingCloningDrawBack) super.clone();
	}
}
