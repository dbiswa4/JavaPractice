package com.java.code.interview.recursion;

/*****
 * @author dbiswas
 * 
 * http://stackoverflow.com/questions/1106929/find-all-combinations-of-coins-when-given-some-dollar-value
 *
 */

public class RepresentCents {

	public static void main(String[] args) {
		System.out.println(sum(100));

	}
	
	public static int sum(int n) {

        int count = 0;
        for (int i = 0; i <= n / 25; i++) {
            for (int j = 0; j <= n / 10; j++) {
                for (int k = 0; k <= n / 5; k++) {
                    for (int l = 0; l <= n; l++) {
                        int v = i * 25 + j * 10 + k * 5 + l;
                        if (v == n) {
                            count++;
                        } else if (v > n) {
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }

}
