package com.java.ocjp;

interface TestA {
	String toString();
}

public class AnonymousClass {
	public static void main(String[] args) {
		System.out.println(new TestA() {
			public String toString() {
				return "test";
			}
		});
	}
}
