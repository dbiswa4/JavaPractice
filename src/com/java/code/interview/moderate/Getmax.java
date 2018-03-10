package com.java.code.interview.moderate;

public class Getmax {

	public static void main(String[] args) {
		System.out.println("Max : " +getMax(5,10));

		System.out.println("" +bitTest(-5));
	}
	
	public static int getMax(int a, int b) {
		
		int c = a - b;
		//int k = (c >> 31) & 0x1;
		int k = (c >> 31) & 1;
		System.out.println("k : " +k);
		int max = a - k * c;
		return max;
	}
	
	public static int bitTest(int a) {
		
		return a >> 31;
		
	}
	

}
