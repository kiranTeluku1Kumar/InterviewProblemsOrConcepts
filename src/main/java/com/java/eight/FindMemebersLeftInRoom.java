package com.java.eight;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindMemebersLeftInRoom {

	public static void main(String[] args) {
		//in this comma separated values treat number as employee id and '<' and '>' as in and out to the room
		List<String> membersInList = Arrays.asList("1, >","2, >", "3, >","1, <","5, >","2, >");
		Predicate<String> pred = t ->  t != null && (t.contains(RoomEntry.OUT.getEntry()) || t.contains(RoomEntry.In.getEntry()));
		
		Map<Object, Object> remMembers =
				membersInList.stream()
					 .filter(pred)
					 .map(s ->s.split(","))
					 .map(strArr -> Arrays.asList(strArr))
					 .filter(strArr -> strArr.size() ==2)
					 .collect(Collectors.toMap(s -> getKey(s), s->getValue(s), extracted()));
		
		System.out.println(remMembers.entrySet().stream().filter(entry -> entry.getValue().equals(RoomEntry.In.getEntry())).map(Entry::getKey).collect(Collectors.toList()));
	}

	private static BinaryOperator<Object> extracted() {
		return (prev, curr)-> {
			 String prevValue = (String) prev;
			 String currValue = (String) curr;
			 String returnString = "";
			 if( prevValue.equals(currValue) && prevValue.equals(RoomEntry.In.getEntry())){
				 returnString = prevValue;
			 } else if( prevValue.equals(currValue) && prevValue.equals(RoomEntry.OUT.getEntry())){
				 returnString = prevValue;
			}else {
				 returnString = currValue;
			}
			 return returnString;
		 };
	}

	private static String getValue(List<String> s) {
		String inputValueStr = s.get(1).trim();
		String strLitIn = RoomEntry.OUT.getEntry();
		String strLitOut = RoomEntry.In.getEntry();
		return inputValueStr.equals(strLitIn) ? inputValueStr : (inputValueStr.equals(strLitOut)? inputValueStr : "");
	}

	private static String getKey(List<String> s) {
		return s.get(0);
	}

}

enum RoomEntry{
	In(">"),OUT("<");

	public String getEntry() {
		return this.entry;
	}
	private String entry;

	RoomEntry(String string) {
		this.entry = string;
	}
}
