package com.java.code.interview.hard;

public class AddWithoutArithmatic {

	public static void main(String[] args) {
		System.out.println("Sum without arithmatic : " +addNoArithmatic(4, 5));

	}
	
	public static int addNoArithmatic(int a, int b){
		if (b == 0) return a;
		
		int sum = a^b; // add without carrying
		int carry = (a & b) << 1; //carry but don't add
		
		return addNoArithmatic(sum, carry); //recurse until there’s nothing to carry. 
	}

}
