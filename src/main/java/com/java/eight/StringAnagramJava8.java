package com.java.eight;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class to separate the anagrams ex:- "eat" and "tea" are anagrams
 * @author teluki
 *
 */
public class StringAnagramJava8 {

	public static void main(String[] args) {
		String[] strArray = new String[] {"eat","tea","nat","tan","bat"};
		getCombinationsJava8(strArray);
	}
	
	public static void getCombinationsJava8(String[] strArray){

		Map<String, List<String>> groupsOfAnagram = Arrays.stream(strArray)
				.map( str -> str.toCharArray())
				.map( charArray -> {char[] beforeSort = charArray.clone(); Arrays.sort(charArray);return new String[] {new String(charArray),new String(beforeSort)};})
				.collect(Collectors.groupingBy(str -> str[0], Collectors.mapping(str -> str[1], Collectors.toList())));
		
		groupsOfAnagram.values().stream().forEach(System.out::println);
	}
}
