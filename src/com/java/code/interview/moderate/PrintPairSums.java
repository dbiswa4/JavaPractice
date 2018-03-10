package com.java.code.interview.moderate;

import java.util.*;

public class PrintPairSums {

	public static void main(String[] args) {

		int[] a = { -2, -1, 0, 3, 5, 6, 7, 9, 13, 14 };
		
		PrintPairSums p = new PrintPairSums();
		
		p.printPairSums(a, 11);

	}

	public void printPairSums(int[] array, int sum) {
		Arrays.sort(array);
		int first = 0;
		int last = array.length - 1;
		while (first < last) {
			int s = array[first] + array[last];
			if (s == sum) {
				System.out.println(array[first] + " " + array[last]);
				++first;
				--last;
			} else {
				if (s < sum)
					++first;
				else
					--last;
			}
		}
		
		//System.out.println("Does not exist");
	}
}
