package com.java.code.consensys;

class MaximumDiffrence {
	/*
	 * The function assumes that there are at least two elements in array. The
	 * function returns a negative value if the array is sorted in decreasing
	 * order. Returns 0 if elements are equal
	 */
	int maxDiff(int arr[]) {

		int maxDiff = arr[1] - arr[0];
		int minElm = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - minElm > maxDiff)
				maxDiff = arr[i] - minElm;
			if (arr[i] < minElm)
				minElm = arr[i];
		}
		return maxDiff;
	}

	int maxDiff2(int arr[]) {
		int maxDiff = -Integer.MAX_VALUE;
		int minElm = 0;
		int firstPos = 0;
		boolean firstValidFound = false;
		while (!firstValidFound && firstPos < arr.length) {
			if (arr[firstPos] >= Math.pow(10, -6)
					&& arr[firstPos] <= Math.pow(10, 6)) {
				minElm = arr[firstPos];
				firstValidFound = true;
			}
			firstPos++;
		}

		for (int i = firstPos; i < arr.length; i++) {
			if (arr[firstPos] >= Math.pow(10, -6)
					&& arr[firstPos] <= Math.pow(10, 6)) {
				if (arr[i] - minElm > maxDiff)
					maxDiff = arr[i] - minElm;
				if (arr[i] < minElm)
					minElm = arr[i];
			}
		}
		return maxDiff;
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		MaximumDiffrence maxdif = new MaximumDiffrence();
		// int arr[] = {1, 2, 90, 10, 110};
		int arr[] = { 10000000, 1, 2, 90, 10, 110, -10000000 };
		int size = arr.length;
		System.out.println("MaximumDifference is " + maxdif.maxDiff(arr));
		System.out.println("MaximumDifference is " + maxdif.maxDiff2(arr));
	}
}