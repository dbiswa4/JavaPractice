package com.java.ocjp;

public class Barn {
		
		public static void main(String[] args) {
			new Barn().go("hi", 1);
			new Barn().go("hi", 2);
			}
		
			public void go(String... y, int x) {
			System.out.print(y[y.length - 1] + " ");
			}
			

	}
