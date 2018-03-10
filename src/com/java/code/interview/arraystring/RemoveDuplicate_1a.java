package com.java.code.interview.arraystring;

public class RemoveDuplicate_1a {

	public static void main(String[] args) {

		String str = "aabc";
		
		int ind = 0;
		int i;
		
		char[] myChar = str.toCharArray();
		
		for(i = 0; i< myChar.length; i++) {
			
			System.out.println("myChar[i]" +myChar[i]);
			
			int val = myChar[i] - 'a';
			System.out.println("val : " +val);
			
			if ((ind & (1 << val) ) > 0) {
				System.out.println("duplicate found");
				myChar[i] = ' ';		
			}
			
			ind |= (1<<val);
		}	
		
		System.out.println("Duplicate Removed : " +String.copyValueOf(myChar));
	}

}
