package com.java.eight;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class MultiplyAndReturnlastTwoDigitsTest {

	@Test
	void test() {
		
		List<Integer> collectedIntegersList = IntStream.rangeClosed(1, 100)
														.boxed()
														.filter(i -> i%3 ==0)
														 .collect(Collectors.toList());
		
		Stream<Integer> stream = collectedIntegersList.stream();
		int[] array = stream.mapToInt(i -> i).toArray();
		stream.forEach(System.out::println);
		MultiplyAndReturnlastTwoDigits.findLastTwoDigits((int[])array);
	}

}
