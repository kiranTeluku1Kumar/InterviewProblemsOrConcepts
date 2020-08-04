package com.java.sevenorbefore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class to separate the anagrams ex:- "eat" and "tea" are anagrams
 * @author saiki
 *
 */
public class StringAnagram {

	public static void main(String[] args) {
		String[] strArray = new String[] {"eat","tea","nat","tan","bat"};
		getCombinations(strArray);
		//getCombinationsJava8(strArray);
		/*
		 * String[] strArraySorted = new String[strArray.length]; strArraySorted =
		 * strArray; Arrays.sort(strArraySorted); for(String strFromArraySorted:
		 * strArraySorted)
		 * System.out.println(strFromArraySorted+"::::strFromArraySorted");
		 */
	}
	
	public static void getCombinationsJava8(String[] strArray){

		Map<String, List<String>> groupsOfAnagram = Arrays.stream(strArray)
				.map( str -> str.toCharArray())
				.map( charArray -> {char[] beforeSort = charArray.clone(); Arrays.sort(charArray);return new String[] {new String(charArray),new String(beforeSort)};})
				.collect(Collectors.groupingBy(str -> str[0], Collectors.mapping(str -> str[1], Collectors.toList())));
		
		groupsOfAnagram.values().stream().forEach(System.out::println);
	}
	
	
	public static void getCombinations(String[] strArray){

		Map<String, List<String>> groupsOfAnagram = new HashMap<>();
		for(String str: strArray){
			char[] charArray = str.toCharArray();
			char[] beforeSort = charArray.clone();
			String unsortedString = new String(beforeSort);
			Arrays.sort(charArray);
			System.out.println(unsortedString+"::for::"+str);

			groupsOfAnagram.putIfAbsent(str, new LinkedList<String>());
			groupsOfAnagram.get(str).add(unsortedString);
		}

		for(List<String> values: groupsOfAnagram.values()) {
			System.out.println(values);
		}
	}

}
