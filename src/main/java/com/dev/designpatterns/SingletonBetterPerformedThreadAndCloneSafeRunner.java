package com.dev.designpatterns;

/**
 * This class is to test Singleton Lazy Loading thread safe and clone runner
 * @author teluki
 *
 */
public class SingletonBetterPerformedThreadAndCloneSafeRunner {

	public static void main(String[] args) throws Exception {
		SingletonBetterPerformedThreadAndCloneSafe sbptcs1 = SingletonBetterPerformedThreadAndCloneSafe.getInstance();
		
		SingletonBetterPerformedThreadAndCloneSafe sbptcs2 = sbptcs1.clone();
		
		System.out.println(sbptcs1.hashCode()+"<---1::2-->"+sbptcs2.hashCode());
	}

}
