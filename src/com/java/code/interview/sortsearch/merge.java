package com.java.code.interview.sortsearch;

public class merge {

	public static void main(String[] args) {

		int[] a = { 1, 3, 5, 7, 0, 0, 0, 0 };
		int[] b = { 2, 6, 7 };
		merge(a, b, 4, 3);

	}

	public static void merge(int[] a, int[] b, int n, int m) {

		int k = m + n - 1;
		int i = n - 1;
		int j = m - 1;

		while (i >= 0 && j >= 0) {

			if (a[i] > b[j]) {
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}
		}

		while (j >= 0) {
			a[k--] = b[j--];
		}

		for (int x= 0; x < a.length; x++) {
			System.out.println(a[x]);

		}

	}

}
