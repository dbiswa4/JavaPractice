package com.java.ocjp;

public class BreakTest {

	public static void main(String[] args) {

		go();
		
	}

	public static void go() {
		String o = "";
		z: 
			//System.out.println();
			for (int x = 0; x < 3; x++) {
			System.out.println("x : " +x);
			for (int y = 0; y < 2; y++) {
				if (x == 1)
					break;
				if (x == 2 && y == 1)
					break z;
				o = o + x + y;
			}
		}
		System.out.println(o);
	}
}
