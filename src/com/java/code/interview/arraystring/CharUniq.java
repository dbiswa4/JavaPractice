package com.java.code.interview.arraystring;

public class CharUniq {

	public static void main(String[] args) {

		boolean[] bool = new boolean[5];

		bool[0] = true;

		System.out.println("bool.toString() : " + bool.toString());
		System.out.println("bool : " + bool);
		
		boolean flag = isUniqueChars2("School");
		
		System.out.println("flag : " +flag);

	}

	public static boolean isUniqueChars2(String str) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			//int val = str.charAt(i);
			char val = str.charAt(i);
			
			char c = str.charAt(i);
			
			System.out.println("c : " +c);
			System.out.println("val : " +val);
			
			if (char_set[val])
				return false;
			
			char_set[val] = true;
		}
		return true;
	}

}
