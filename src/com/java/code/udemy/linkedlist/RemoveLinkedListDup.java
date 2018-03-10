package com.java.code.udemy.linkedlist;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class RemoveLinkedListDup {
	
	public static void deleteDups (LinkedList<Integer> list) {
		Hashtable<Integer,String> table = new Hashtable();
		
		Node curNode = list.getHead();
		
		while (curNode != null) {
			
			if(table.contains(curNode.getData())) {
				System.out.println("Dup found");
			} else {
				System.out.println("Element : " +(Integer) curNode.getData());
				table.put((Integer) curNode.getData(), "true");
			}	
			curNode = curNode.getNextNode();
		}
		
		String output="";
		
		for(Object data : table.keySet()) {
			output += (Integer) data + " " ;
			
		}
		
		System.out.println("Unique Elements : " + "[" + output + "]");
		
	}
	
	//my implementation using a List
	
	public static void deleteDups1 (LinkedList<Integer> list) {
		List newList = new ArrayList();
		
		Node curNode = list.getHead();
		
		while (curNode != null) {
			
			if(!newList.contains(curNode.getData())) {
				newList.add(curNode.getData());
			}	
			curNode = curNode.getNextNode();
		}
		
		String output="";
		
		for(Object data : newList) {
			output += data + " " ;
			
		}
		
		System.out.println("Unique Elements : " + "[" + output + "]");
		
	}
		

}
