package com.java.code.random;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * Four ways to iterate a map
 * 
 * http://javarevisited.blogspot.sg/2011/12/how-to-traverse-or-loop-hashmap-in-java.html
 * 
 */

public class IterateMap {

	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "Milk");
		map.put(2, "Fruits");
		
		//1st
		System.out.println("1st.....");
		for(Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("id : " + entry.getKey() + " " + "value : " +entry.getKey());		
		}
		
		//2nd
		
		System.out.println("2nd.....");
		
		for(Integer key : map.keySet()) {	
			System.out.println("id : " +key + " " + "value : " +map.get(key));
		}
		
		//3rd
		System.out.println("3rd.....");
		
		Set<Integer> key = map.keySet();
		Iterator<Integer> itr = key.iterator();	
		while(itr.hasNext()) {
			Integer k = itr.next(); 
			System.out.println("key : " + k + " " + "value : " +map.get(k));
		}
		
		//4th
		//Combination of Iterator and EntrySet
		System.out.println("4rd.....");		
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		
		Iterator<Entry<Integer, String>> itr1 = entrySet.iterator(); 
		
		while(itr1.hasNext()) {
			
			Entry entry = itr1.next();
			
			System.out.println("id : " + entry.getKey() + " " + "value : " +entry.getValue());
			
		}
		
		
	}

}
