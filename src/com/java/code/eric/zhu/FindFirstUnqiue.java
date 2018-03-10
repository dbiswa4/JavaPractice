package com.java.code.eric.zhu;

import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class FindFirstUnqiue {

	public static void main(String[] args) {
		//This should give 'o', but it returns 'f'
		System.out.println(findFirstUnqiue("geeksofrgeeks"));
		//should be 'o'
		System.out.println(findFirstUnqiue2("geeksofrgeeks"));
		System.out.println(findFirstUnqiue3("geeksofrgeeks"));
	}
	
	public static char findFirstUnqiue(String str) {
		if (str == null) return (Character) null;
		if (str.length() == 0) return (Character) null;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}	
		}
		for (Map.Entry<Character, Integer> m : map.entrySet()) {
			if (m.getValue() == 1) return m.getKey();		
		}
		return (Character) null;
		
	}
	
	public static char findFirstUnqiue2(String str) {
		if (str == null) return (Character) null;
		if (str.length() == 0) return (Character) null;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}	
		}
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int count = map.get(c);
			if(count == 1) return c;			
		}
		return (Character) null;	
	}
	
	public static char findFirstUnqiue3(String str) {
		if(str == null) return (Character) null;
		if(str.length() == 0) return (Character) null;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		//Only for uniqueu character
		LinkedHashSet<Character> linkedSet = new LinkedHashSet<Character>();
		
		for(int i= 0; i < str.length(); i++){
			char c = str.charAt(i);
			linkedSet.add(c);
			if(!map.containsKey(c)) {
				linkedSet.remove(c);
			} else {
				map.put(c, 1);
			}
		}
		// Now the set contains unique characters in the insertion order.
		Iterator<Character> itr = linkedSet.iterator();
		while(itr.hasNext()) {
			return itr.next();
		}		
		return (Character) null;
	}

}



