package com.java.code.interview.arraystring;

public class ReverseString {

	public static void main(String[] args) {

		revCStyleString("abcd ");
		
		String reverse1 = reverse1("efgh ");
		
		System.out.println("reverse1 : " +reverse1);

	}

	// http://stackoverflow.com/questions/5673155/how-to-reverse-a-c-style-string-completely
	
	public static void revCStyleString(String str) {

		// str = "abcd ";
		char[] myChar = str.toCharArray();

		System.out.println("myChar : " + myChar.toString());

		System.out.println(str);
		int p1 = 0;
		int p2 = myChar.length - 1;

		while (p1 < p2) {
			char temp = myChar[p1];
			myChar[p1] = myChar[p2];
			myChar[p2] = temp;

			p1++;
			p2--;
		}

		//str = str.copyValueOf(myChar);
		
		str = String.copyValueOf(myChar);

		System.out.println(str);
	}
	
	/*
	 * With empty string check
	 * https://xuuuduuuo.wordpress.com/2012/10/28/reverse-a-c-style-string/
	 * 
	 */
	
	public static String reverse1(String str) {
	    if (str.isEmpty()) {
	        return str;
	    }
	    int p1 = 0;
	    int p2 = str.length()-1;
	    char[] characters = str.toCharArray();
	    while (p1 < p2) {
	        char tmp = characters[p1];
	        characters[p1] = characters[p2];
	        characters[p2] = tmp;
	        ++p1;
	        --p2;
	    }
	    return new String(characters);
	}
	 
	public static String reverse2(String str) {
	    if (str.isEmpty() || str.length() == 1) {
	        return str;
	    }
	    int len = str.length();
	    return str.charAt(len-1)+reverse2(str.substring(0,len));
	}

}
