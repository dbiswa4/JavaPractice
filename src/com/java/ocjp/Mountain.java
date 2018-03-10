package com.java.ocjp;

class Atom {
	//Atom(String abc) {	
	// gives an error in Rock constructor as it tries to search for defaut constructor of immediate 
	//parent Atom
	 Atom() {	
		System.out.print("atom ");
	}
}

class Rock extends Atom {
	Rock(String type) {
		System.out.print(type);
	}
}

public class Mountain extends Rock {
	Mountain() {
		super("granite ");
		new Rock("granite ");
	}

	public static void main(String[] a) {
		new Mountain();
	}
}
