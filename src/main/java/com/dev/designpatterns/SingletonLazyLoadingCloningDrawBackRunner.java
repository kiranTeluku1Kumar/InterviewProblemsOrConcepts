package com.dev.designpatterns;

/**
 * This class is to test Singleton Lazy Loading with Cloning breaks Singleton.
 * @author teluki
 *
 */
public class SingletonLazyLoadingCloningDrawBackRunner {

	public static void main(String[] args) throws Exception {
		SingletonLazyLoadingCloningDrawBack callSingleton1 = SingletonLazyLoadingCloningDrawBack.getInstance();
		SingletonLazyLoadingCloningDrawBack callSingleton2 = callSingleton1.clone();

		System.out.println(callSingleton1.hashCode()+"<-- 1:::2-->" +callSingleton2.hashCode());
	}

}
