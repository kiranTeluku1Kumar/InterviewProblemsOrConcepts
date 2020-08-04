package com.java.eight;

public class RemoveDuplicatesJava8 {

	public static void main(String[] args) {
		String inputString="createeat";
		removeDuplicateChars(inputString);
	}

	private static void removeDuplicateChars(String inputString) {
		StringBuffer strBuff = new StringBuffer();
		inputString.chars()
		.distinct()
		.forEach(c->strBuff.append((char)c));
		System.out.println(strBuff);
	}

}
