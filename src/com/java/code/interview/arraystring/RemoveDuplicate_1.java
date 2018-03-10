package com.java.code.interview.arraystring;

public class RemoveDuplicate_1 {

	public static void main(String[] args) {

		String str = "aabderfghhhh";

		// System.out.println("Dup Removed from " + str +
		// " removeDup1 \nNew Value : "
		// + removeDup1(str));

		System.out.println("Dup Removed from " + str
				+ " by removeDup2 \n New Value : " + removeDup2(str));

		char[] output = removeDuplicates("aabcccdeeea".toCharArray());

		System.out.println("\n FRom removeDuplicates() : ");
		System.out.println("output lenght: " + output.length);

		System.out.println("String.copyValueOf(output) : "
				+ String.copyValueOf(output));
		
		output = removeDuplicatesEff("aabcccdeeea".toCharArray());
		
		System.out.println("\n FRom removeDuplicatesEff() : ");
		System.out.println("output lenght: " + output.length);

		System.out.println("String.copyValueOf(output) : "
				+ String.copyValueOf(output));
	}

	/*
	 * My implementation Input : aabc Output : a bc
	 */
	public static String removeDup1(String str) {

		int ind = 0;
		int i;

		char[] myChar = str.toCharArray();

		for (i = 0; i < myChar.length; i++) {

			System.out.println("myChar[i]" + myChar[i]);

			int val = myChar[i] - 'a';
			System.out.println("val : " + val);

			if ((ind & (1 << val)) > 0) {
				System.out.println("duplicate found");
				myChar[i] = ' ';
			}

			ind |= (1 << val);
		}

		return String.copyValueOf(myChar);
	}

	/*
	 * My 2nd implementation input : aabc output : abc Bingo
	 */
	public static String removeDup2(String str) {

		int ind = 0;
		int size = 0;
		boolean firstChar = true;

		char[] myChar = str.toCharArray();

		for (int i = 0; i < myChar.length; i++) {

			System.out.println("myChar[i]" + myChar[i]);

			int val = myChar[i] - 'a';
			System.out.println("val : " + val);

			if ((ind & (1 << val)) > 0) {
				System.out.println("duplicate found");
				myChar[i] = ' ';
			} else {
				myChar[size] = myChar[i];
				if (!firstChar)
					myChar[i] = ' ';
				size++;

			}

			ind |= (1 << val);
			firstChar = false;

		}

		return String.copyValueOf(myChar);
	}

	/*
	 * Solution given Be careful about returns
	 * 
	 * Warning : Does not work
	 */

	public static char[] removeDuplicates(char[] str) {
		if (str == null)
			return str;
		int len = str.length;
		if (len < 2)
			return str;

		int tail = 1;

		for (int i = 1; i < len; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j])
					break;
			}
			if (j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		str[tail] = 0;
		return str;
	}
	
	/*
	 * Does not work
	 */

	public static char[] removeDuplicatesEff(char[] str) {
		if (str == null)
			return str;
		int len = str.length;
		if (len < 2)
			return str;
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; ++i) {
			hit[i] = false;
		}
		hit[str[0]] = true;
		int tail = 1;
		for (int i = 1; i < len; ++i) {
			if (!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		str[tail] = 0;
		return str;
	}

}
