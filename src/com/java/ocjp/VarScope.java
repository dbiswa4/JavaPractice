package com.java.ocjp;

/*
 * OCJP
 * P 32
 * 
 */

class Foo {
	public int a = 3;

	public void addFive() {
		a += 5;
		System.out.print("f ");
	}
}

class Bar extends Foo {
	public int a = 8;

	public void addFive() {
		this.a += 5;
		System.out.print("b ");
		System.out.println("new a : " +this.a);
	}
}

public class VarScope {

	public static void main(String[] args) {
		Foo f = new Bar();
		f.addFive();
		System.out.println(f.a);
		f.addFive();

	}

}
