package com.java.ocjp;

public class TryCatch {

	static void test() throws RuntimeException {
		/*
		try {
			System.out.print("test ");
			throw new RuntimeException();
		} catch (Exception ex) {
			System.out.print("exception ");
		}
		*/
		System.out.print("test ");
		throw new RuntimeException();
		
	}

	public static void main(String[] args) {
		try {
			test();
		} catch (RuntimeException ex) {
			System.out.print("runtime ");
		}
		System.out.print("end ");
	}
}
