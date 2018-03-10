package com.java.ocjp;

public class Boxer1 {
	//Integer i; // will give a null pointer exception
	int i;
	int x;

	public Boxer1(int y) {
		x = i + y;
		System.out.println(x);
	}

	public static void main(String[] args) {
		new Boxer1(new Integer(4));
	}
}
