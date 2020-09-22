package com.dev.designpatterns;

/**
 * This class is to test Singleton Eager Loading 
 * @author teluki
 *
 */
public class SingletonEagerLoadingRunner {

	public static void main(String[] args) throws InterruptedException {
		SingletonEagerLoading singletonEagerLoading1 = SingletonEagerLoading.getInstance();
		SingletonEagerLoading singletonEagerLoading2 = SingletonEagerLoading.getInstance();
		//Here we can see both instances are having same hash code which will prove singleton design pattern
		System.out.println(singletonEagerLoading1.hashCode()+"<-- 1:::2-->"+singletonEagerLoading2.hashCode());
	}

}
