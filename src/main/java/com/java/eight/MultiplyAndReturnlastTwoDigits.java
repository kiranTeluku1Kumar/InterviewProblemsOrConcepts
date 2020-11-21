package com.java.eight;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * This program to multiple all the elements in array and return last two digits from final end product.
 * @author Developer
 *
 */
public class MultiplyAndReturnlastTwoDigits {

	public static void main(String[] args) {
		int[] listOfInts = {1,2,3,4,5,6,7};
		findLastTwoDigits(listOfInts);
		System.out.println(":::1111"+(IntStream.of(1,4,2,7,5).reduce(1, (a, b) -> a * b)));
//		System.out.println(":::"+(IntStream.range(1,101).reduce(1, (a, b) -> Math::multiplyExact)));
	}

	public static void findLastTwoDigits(int[] listOfInts) {	
		System.out.println("findLastTwoDigits Start");
//		Arrays.stream(listOfInts).forEach(System.out::println);
		AtomicLong acc =new AtomicLong(1);
		if(listOfInts == null ) 
		{
			System.out.println("-1");
			return;
		}
//		Stream<Integer> intStream = Arrays.stream(listOfInts).boxed();
		//121645100408832000
		//2432902008176640000
		//616513966934065152
		AtomicLong finalReturn = new AtomicLong();
		IntStream intStream = Arrays.stream(listOfInts);
		long num = intStream
				.mapToLong(i -> i)
				.reduce(acc.get(), (long a,long b) ->{
					long l = a*b;
					System.out.println("a::"+a);
					System.out.println("b::"+b);
					String aNum = String.valueOf(a);
					System.out.println("aNum.length()::"+aNum.length());
					if(a > 0 && a < Long.MAX_VALUE && (aNum .length() == 19)  )
					{
						System.out.println("::::::::::::::::::::::::::::::::::::::::::Returning from a");
						return a; 
					}
					
					String numbMul = String.valueOf(l);
					if(l > 0 && l < Long.MAX_VALUE && numbMul.length() <= 19 ){
						if( aNum.length() < 19 || (aNum.length() == 19 &&b <5)  ) {
							finalReturn.set(l);
							System.out.println("inside if condition");
						}
					}
					System.out.println("::::::::::::::::::::::::::::::::::::::::::Returning");
					return finalReturn.get();
				});
		System.out.println("num::"+num);
		String finalNumStr = String.valueOf(num);
		int strLen = finalNumStr.length();
		if(strLen >2) {
			System.out.println(finalNumStr.substring(strLen-2));
		}else if(strLen >0){
			System.out.println(finalNumStr);
		}else {
			System.out.println("-1");
		}
	}

}
