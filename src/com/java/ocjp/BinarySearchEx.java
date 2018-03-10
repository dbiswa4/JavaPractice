package com.java.ocjp;

import java.util.Arrays;

/*
 * Output:
 * 2 -5
 * 
 * Doubt:
 * why it gives 5 for violet?
 */

public class BinarySearchEx {


		public static void main(String[] args) {
			String[] colors = { "blue", "red", "green", "yellow", "orange" };
			Arrays.sort(colors);
			//int s2 = Arrays.binarySearch(colors, "blue");
			int s2 = Arrays.binarySearch(colors, "orange");
			int s3 = Arrays.binarySearch(colors, "violet");
			System.out.println(s2 + " " + s3);
		}
	
}
