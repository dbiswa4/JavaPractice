package com.java.code.interview.bit;

/*************************************************************************
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to set all bits between i and j in N equal to M (e.g., M
 * becomes a substring of N located at i and starting at j). 
 * 
 * EXAMPLE: Input: N =
 * 10000000000, M = 10101, i = 2, j = 6 Output: N = 10001010100
 * 
 * http://stackoverflow.com/questions/4765201/int-max-0-what-does-it-mean
 * 
 *
 *************************************************************************/

public class UpdateBits {

	public static void main(String[] args) {
		
		updateBits(8, 3, 2, 5);

	}
	
	public static int updateBits(int n, int m, int i, int j) {
		
		int max = ~0;
		
		System.out.println("max : " +max);
		
		return 1;
	}

}
