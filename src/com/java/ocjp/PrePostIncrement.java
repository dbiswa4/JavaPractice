package com.java.ocjp;

/*
 * Output:
 * 
 *  doStuff x = 5 main x = 5
 *  
 */

public class PrePostIncrement {
	public static void main(String[] args) {
		int x = 5;
		PrePostIncrement p = new PrePostIncrement();
		p.doStuff(x);
		System.out.print(" main x = " + x);
	}

	void doStuff(int x) {
		System.out.print(" doStuff x = " + x++);
		
		//System.out.print(" doStuff x = " + ++x);
		
		System.out.print(" doStuff x = " + x);
	}
}