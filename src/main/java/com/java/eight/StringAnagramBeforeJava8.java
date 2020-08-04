package com.java.eight;

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
public class StringAnagramBeforeJava8 {

	public static void main(String[] args) {
		String[] strArray = new String[] {"eat","tea","nat","tan","bat"};
		getCombinations(strArray);
	}
	
	public static void getCombinations(String[] strArray){

		Map<String, List<String>> groupsOfAnagram = new HashMap<>();
		for(String str: strArray){
			char[] charArray = str.toCharArray();
			System.out.print("::before for::"+str+"--->");
			Arrays.sort(charArray);
			char[] sortedCharArray = charArray.clone();
			String sortedString = new String(sortedCharArray);
			System.out.println(sortedString+"::for::"+str);

			groupsOfAnagram.putIfAbsent(sortedString, new LinkedList<String>());
			groupsOfAnagram.get(sortedString).add(str);
		}

		for(List<String> values: groupsOfAnagram.values()) {
			System.out.println(values);
		}
	}

}
