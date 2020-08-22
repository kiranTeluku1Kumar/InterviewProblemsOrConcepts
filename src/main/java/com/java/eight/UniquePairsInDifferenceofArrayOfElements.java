package com.java.eight;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * this is used to find the unique pairs possible when we combined the value with k result in another element of the list.
 * EX:- k value is 1 and the list is  [1, 1, 2, 2, 3, 3]
 * 	So here sum of first element of list and k produces third element or fourth element of list i.e, 1+1 =2
 * 	In same way sum of second element of list and k produces third element or fourth element of list i.e, 1+1 =2
 *  In same way sum of third element of list and k produces fifth element or sixth element of list i.e, 2+1=3
 *  In same way sum of fourth element of list and k produces fifth element or sixth element of list i.e, 2+1=3
 *  so here we end up with (1,2), (1,2), (2,3) and (2,3). but we need unique pairs so we should finally have (1,2) and(2,3) and answer should be 2
 * @author saiki
 *
 */
public class UniquePairsInDifferenceofArrayOfElements {

	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(new Integer[]{1, 1, 2, 2, 3, 3});
		int k = 1;
		findTheMatched(listOfIntegers, k );
	}

	private static void findTheMatched(List<Integer> listOfIntegers, int k) {
		System.out.println(listOfIntegers.stream()
					  .filter( c -> listOfIntegers.contains(c+k))
					  .map(c -> c+","+(c+k))
					  .collect(Collectors.toSet()).size());
	}
}
