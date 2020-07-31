/**
 * 
 */
package com.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author Developer
 * This program will sort/swap the elements so that all even numbers will be moved to start of array
 * Example:-
 * [1,4,3,10] after our execution it should be [4,10,3,1]
 */
public class GetAllEvenNumbersFirst {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> randomIntegers = Arrays.asList(1,4,3,10);
		AtomicInteger moveCountOrCur = new AtomicInteger(0);
		IntStream.rangeClosed(0, randomIntegers.size()-1)
			.filter(index -> randomIntegers.get(index) % 2 == 0) 
			.forEach( firstCur -> {Collections.swap(randomIntegers, firstCur, moveCountOrCur.getAndIncrement());});
		System.out.println(randomIntegers);
		System.out.println(moveCountOrCur);
	}

}
