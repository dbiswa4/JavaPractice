package com.java.code.interview.arraystring;

import java.util.Collection;
import java.util.Collections;

public class AnagramTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(anagram2("cimena","iceman"));
		System.out.println(anagram2("cimena","icemav"));
		
	}

	public boolean anagram(String s, String t) {

		// return (sort(s), sort(t));

		// dummy return
		return false;
	}

	public static boolean anagram2(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			System.out.println("out : " +c);
			if (letters[c] == 0)
				++num_unique_chars;
			++letters[c];
			System.out.println("letters[c]" +letters[c]);
		}
		System.out.println("num_unique_chars : " +num_unique_chars);
		
		for (int i = 0; i < t.length(); ++i) {
			//int c = (int) t.charAt(i);			
			int c = t.charAt(i);
			
			if (letters[c] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// it’s a match if t has been processed completely
					//return i == t.length() - 1;
					return true;
				}
			}
		}
		return false;
	}

}
