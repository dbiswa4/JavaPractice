package com.java.code.interview.recursion;

/**************************************************************************************************
 * 
 * 1,2,3,5,8,13,21,34,55
 * 
 **************************************************************************************************/

public class Fibonacci {

	public static void main(String[] args) {

		int n = 8;

		System.out.println("nth Fibonacci No : " + nThFibonacci(n));

		// print n Fibonacci number
		System.out.println("Recursive way...");
		for (int i = 0; i <= n; i++) {
			System.out.println(+nThFibonacci(i) + " ");
		}

		// print n Fibonacci number
		System.out.println("Iterative way...");
		for (int i = 1; i <= n; i++) {
			System.out.println(+nThFibonacciIterative(i) + " ");
		}
		
		//to print the series itself recursively
		System.out.println("Print in method itself - recursive way...");
		//doen't print the series, only print the nth number
		nThFibonacciRecursive(n);
		
		//Print in the method itself
		System.out.println("Print in method itself - iterative way...");
		nFibonacciIterative(n);

	}

	public static int nThFibonacci(int n) {

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (n > 1) {
			return nThFibonacci(n - 1) + nThFibonacci(n - 2);

		} else {
			return -1; // error condition
		}
	}

	public static int nThFibonacciIterative(int n) {

		if (n == 0) {
			return 0;
		} else if (n == 1 || n ==2) {
			return 1;
		}

		int fibo1 = 1;
		int fibo2 = 1;
		int fibo = 0;

		for (int i = 3; i <= n; i++) {
			fibo = fibo1 + fibo2;
			fibo1 = fibo2;
			fibo2 = fibo;
		}
		return fibo;

	}
	
	
	//to print the series itself
	public static int nThFibonacciRecursive(int n) {

		if (n == 0) {
			System.out.println(0);
			return 0;
		} else if (n == 1) {
			System.out.println(1);
			return 1;
		} else if (n > 1) {
			System.out.println(nThFibonacci(n - 1) + nThFibonacci(n - 2));
			return(nThFibonacci(n - 1) + nThFibonacci(n - 2));
		} else {
			System.out.println("Error"); // error condition
			return -1;
		}
	}
	
	public static void nFibonacciIterative(int n) {

		if (n == 0) {
			System.out.println(0);
		} else if (n == 1 || n ==2) {
			System.out.println(1);
		}

		int fibo1 = 1;
		int fibo2 = 1;
		int fibo = 0;

		System.out.println(fibo1);
		System.out.println(fibo2);
		
		for (int i = 3; i <= n; i++) {
			fibo = fibo1 + fibo2;
			System.out.println(fibo);
			fibo1 = fibo2;
			fibo2 = fibo;
		}

	}

}
