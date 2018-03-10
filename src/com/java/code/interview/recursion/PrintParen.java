package com.java.code.interview.recursion;

public class PrintParen {

	public static void main(String[] args) {
		int count = 3;
		char[] str = new char[count * 2];
		printParen(count, count, str, 0);

	}

	public static void printParen(int l, int r, char[] str, int count) {

		if (l > r)
			return;

		if (l == 0 && r == 0)
			System.out.println(str);
		else {
			if (l > 0) {
				str[count] = '(';
				printParen(l - 1, r, str, count + 1);

			}
			if (r > l) {
				str[count] = ')';
				printParen(l, r - 1, str, count + 1);
			}

		}
	}

}
