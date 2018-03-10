package com.java.code.interview.arraystring;

public class StringReplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReplaceFun("a b c ".toCharArray(),5);

		ReplaceFun2("a b c ".toCharArray(),5);
		
	}

	public static void ReplaceFun(char[] str, int length) {
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length-1; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		//str[newLength] = '\0';
		char[] newStr = new char[newLength];
		
		//System.out.println("str[newLength] : " +str[newLength]);
		
		
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				newStr[newLength - 1] = '0';
				newStr[newLength - 2] = '2';
				newStr[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				newStr[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		
		System.out.println("New Array : " +String.copyValueOf(newStr));
	}

	/*
	 * My implementation
	 * Drawback is that I will have to maintain one additional counter
	 */
	
	public static void ReplaceFun2(char[] str, int length) {
		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		
		System.out.println("newLength : " +newLength);
		
		char[] newStr = new char[newLength];
		
		int j = 0;
		for(i = 0; i < length; i++) {
			
			System.out.println("i : " +i);
			System.out.println("str[i] : " +str[i]);
			
			if(str[i] == ' '){
				newStr[j] = '%';
				newStr[j+1] = '2';
				newStr[j+2] = '0';
				j = j + 3;
				
			} else {
				newStr[j] = str[i];
				j++;
			}			
		}
		
		System.out.println("New Array : " +String.copyValueOf(newStr));
	}
}
