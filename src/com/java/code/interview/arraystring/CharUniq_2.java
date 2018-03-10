package com.java.code.interview.arraystring;

public class CharUniq_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean unique = isUniqueChars("aba");
		
		//boolean unique = isUniqueChars("abcdefghijklmnopqrstuvwxyz");
		
		System.out.println("Uniqueness  : "+unique);

	}

	public static boolean isUniqueChars(String str) {
		
		int checker = 0; // 00000
		
		
		for (int i = 0; i < str.length(); i++) {
		int val = str.charAt(i) - 'a';
		
		System.out.println("checker : " +checker);
		System.out.println("(1 << val)" +(1 << val));
		
		/*
		 * 1st :  (1 << val) => 00001
		 * 2nd : (1 << val)  => 00010 (& 00011 => 00010)
		 * 
		 *  00100 & 00011 => 00000
		 */
		
		// 11 & (1<<0) => 11 & 01
		
		System.out.println("logical set : " +(1 << val));
		
		if ((checker & (1 << val)) > 0) {
			
			return false;
		}
		
		
		//checker |= (1 << val);
		
		checker = checker | (1 << val);
		
		/*
		 * 0th : checker => 00000
		 * 1st : checker => 00001
		 * 2nd : checker => 00011
		 * 3rd : checker => 00111
		 */
		
		System.out.println("after set : " +i + " checker : " +checker);
		
		}
		return true;
	 }
}
