package com.java.sevenorbefore;

public class RemoveDuplicatesBeforeJava8 {

	public static void main(String[] args) {
		String inputString="createeat";
		removeDuplicateChars(inputString);
	}

	private static void removeDuplicateChars(String inputString) {
		StringBuffer strBuff = new StringBuffer();
		for(char ch: inputString.toCharArray()) {
			String curReturnString = strBuff.toString();
			String curStrCh = String.valueOf(ch);
			if(!curReturnString.contains(curStrCh)) {
				strBuff.append(curStrCh);
			}
		}
		System.out.println(strBuff);
	}

}
