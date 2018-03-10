package com.java.code.udemy.linkedlist;

public class LinkedList<T> {

	private Node<T> head;

	public Node<T> getHead() {
		return this.head;
	}

	// add at start of linked list
	
	public void addAtStart(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.setNextNode(this.head);
		this.head = newNode;

	}
	
	// add at end
	
	public void addAtEnd(T data) {
		
		Node<T> newNode = new Node<T>(data);
		
		Node<T> currentNode = this.head;
		
		while(currentNode.getNextNode() != null) {
			currentNode = currentNode.getNextNode();			
		}	
		currentNode.setNextNode(newNode);
		
	}
	
	//delete at start
	
	public Node<T> deleteAtStart() {
		
		Node<T> currentNode = this.head;
		
		if(currentNode == null)
			return null;
		this.head = currentNode.getNextNode();		
		
		return currentNode;
	}
	
	//find length of linked list
	
	public int length() {
		
		if(this.head == null)
			return 0;
			
		int len = 0;
		Node<T> currentNode = this.head;
		while(currentNode != null) {
			currentNode = currentNode.getNextNode();
			len +=1;
		}
		return len;
	}
	
	//Find an element in a linked list
	
	public Node<T> find(T data) {
		
		Node<T> currentNode = this.head;
		
		if (currentNode == null)
			return null;
		while(currentNode.getNextNode() != null) {
			
			if(currentNode.getData().equals(data)) {
				return currentNode;
			}
			
			currentNode = currentNode.getNextNode();
		}
		
		return null;	
		
	}
	
	//insert a node in a particular position in a linked lit
	
	public Node<T> insertAfter(T data, int pos) {
		
		Node<T> temp = new Node<T>(data);
		
		Node<T> currentNode = this.head;
		int count = 0;
		
		while (currentNode != null) {
			count += 1;
			if(count == (pos -1)) {
				
				temp.setNextNode(currentNode.getNextNode());
				currentNode.setNextNode(temp);				
			}
			
			currentNode = currentNode.getNextNode();
			
		}
		
		//dummy return
		return temp;
	}
	
	public void insertAt(T data, int pos) {
		
		System.out.println("In insertAt() loop : ");
		
		Node<T> temp = new Node<T>(data);
		Node<T> curNode = this.head;
		Node<T> prevNode = null;
		if (curNode == null)
			return;
		
		if (pos == 1) {
			addAtStart(data);
			return;
			
		} else if ( pos == length()) {
			addAtEnd(data);
			return;
		}
				
		int counter = 0;
		
		while (curNode != null) {
			
			System.out.println("curNode : " +curNode );
			
			if (counter == (pos -1)) {
				
				prevNode.setNextNode(temp);
				temp.setNextNode(curNode);
				return;
			}
			
			prevNode = curNode;
			System.out.println("prevNode : " +prevNode);
			curNode = curNode.getNextNode();
			counter += 1;
		}		
		
	}
	
	/*
	Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
	EXAMPLE
	Input: the node ‘c’ from the linked list a->b->c->d->e
	Result: nothing is returned, but the new linked list looks like a->b->d->e
	*/
	
	public void deleteFromMiddle(T data) {
		
		System.out.println("deleteFromMiddle()");
		Node<T> temp = find(data);
		
		System.out.println("Node to be deleted : "+temp);
		
		if(temp == null || temp.getNextNode() == null) {
			return;
		}
		
		Node<T> next = temp.getNextNode();
		
		temp.setData(next.getData());
		temp.setNextNode(next.getNextNode());
		
	}
	
	
	@Override

	public String toString(){

		Node<T> currentNode = this.head;
		
		if ( currentNode == null)
				return null;

		String output ="";
		while(currentNode != null) {
			
			//System.out.println("Node data : " +currentNode.getData().toString());
			output += currentNode.getData().toString() + " ";	
			
			currentNode = currentNode.getNextNode();
		}
		
		//return "[" + output + currentNode.getData().toString() + "]";
		
		return "[" + output + "]";
	}
}
