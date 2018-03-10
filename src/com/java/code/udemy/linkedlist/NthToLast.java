package com.java.code.udemy.linkedlist;

public class NthToLast {
	
	public static Node getNthToLast(LinkedList list, int n) {
		
		Node p1 = list.getHead();
		Node p2 = list.getHead();
		
		if (p1 == null || n < 1) {
			return null;
		}
		
		for(int i = 0; i < n; i++ ) {
			if (p2 == null) {
				return null;
			}
			p2 = p2.getNextNode();			
		}
		
		while(p2 != null) {
			p1 = p1.getNextNode();
			p2 = p2.getNextNode();			
		}		
		
		return p1;
		
		
	}

}
