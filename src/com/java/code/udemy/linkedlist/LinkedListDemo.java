package com.java.code.udemy.linkedlist;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		LinkedList<Integer> integers = new LinkedList<Integer>();
		
		integers.addAtStart(10);
		integers.addAtStart(20);
		integers.addAtStart(20);
		//integers.addAtStart(40);
		
		System.out.println("my linkedlist : " +integers.toString());
		
		integers.addAtEnd(11);
		
		System.out.println("my linkedlist : " +integers.toString());
		
		System.out.println("Lenght : " +integers.length());
		

		//Node<Integer> n = integers.deleteAtStart();
		
		//both gives same result
		//this because that toString() method is implemented
		
		//System.out.println("Deleted Node : " +n.toString());
		//System.out.println("Deleted Node : " +n);
		
		Node<Integer> f = integers.find(20);
		
		System.out.println("Found Object : " +f);
		
		Node<Integer> insert = integers.insertAfter(33, 3);
		
		System.out.println("Inserted Node : " +insert);
		
		System.out.println("my linkedlist : " +integers.toString());
		
		integers.insertAt(45, 3);
		
		System.out.println("my linkedlist after  insertAt() : " +integers.toString());
		
		RemoveLinkedListDup.deleteDups(integers);
		
		RemoveLinkedListDup.deleteDups1(integers);
		
		Node nThLast = NthToLast.getNthToLast(integers, 1);
		
		System.out.println("nThLast : " +nThLast);
		
		integers.deleteFromMiddle(10);
		
		System.out.println("my linkedlist after  deleteFromMiddle() : " +integers.toString());
		
	}

}
