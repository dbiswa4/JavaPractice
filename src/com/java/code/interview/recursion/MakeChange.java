package com.java.code.interview.recursion;

public class MakeChange {

	public static void main(String[] args) {
		
		System.out.println("Number of ways : " +makeChange(10));
		//System.out.println("Number of ways : " +makeChangeIterative(100));

		//System.out.println("Number of ways : " +makeChangeIterative2(100));
	}

	/**
	 * Recursive solution. The idea is to select coins from the biggest to the
	 * smallest to ensure the correct order. Then Substract the selected value
	 * from the total and solve the problem recursively.
	 */
	private static int makeChange(int total, int denom) {
		int nextCoin = 0;
		switch (denom) {
		case 25:
			nextCoin = 10;
			break;
		case 10:
			nextCoin = 5;
			break;
		case 5:
			nextCoin = 1;
			break;
		case 1:
			return 1; // Found a combination.Base case.
		default:
			return 0;
		}

		int ways = 0;
		for (int count = 0; count * denom <= total; ++count) {
			//System.out.println("count : " +count);
			ways += makeChange(total - count * denom, nextCoin);
		}
		return ways;
	}

	public static int makeChange(int total) {
		if (total < 0)
			return 0;
		// Select coins with the biggest denomination first.
		return makeChange(total, 25);
	}

	/**
	 * Iterative solution.
	 */
	public static int makeChangeIterative(int total) {
		int ways = 0;
		for (int count25 = 0; count25 * 25 <= total; ++count25) {
			for (int count10 = 0; count10 * 10 <= total; ++count10) {
				for (int count5 = 0; count5 * 5 <= total; ++count5) {
					int sum = count25 * 25 + count10 * 10 + count5 * 5;
					// when the first three types of coins are selected, the way
					// of selecting coins
					// with denomination 1 cent has already known.
					if (sum <= total) {
						++ways;
					}
				}
			}
		}
		return ways;
	}
	
	//instead of ++count, count++ used
	
	public static int makeChangeIterative2(int total) {
		int ways = 0;
		for (int count25 = 0; count25 * 25 <= total; count25++) {
			for (int count10 = 0; count10 * 10 <= total; count10++) {
				for (int count5 = 0; count5 * 5 <= total; count5++) {
					int sum = count25 * 25 + count10 * 10 + count5 * 5;
					// when the first three types of coins are selected, the way
					// of selecting coins
					// with denomination 1 cent has already known.
					if (sum <= total) {
						ways++;
					}
				}
			}
		}
		return ways;
	}

}
