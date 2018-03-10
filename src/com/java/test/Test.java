package com.java.test;

public class Test {
	
	byte x;

	public static void main(String[] args) {
		
		
		int max = 1 << 3;
		System.out.println(max);
		
		
		max = 3 >> 1;
		
		System.out.println(max);
		
		System.out.println(3 & 1);

		System.out.println(4 & 1);
		
		
		String s1 = "abcd";
		String s2 = "abcd";
		String s3 = "dcb";
		
		if (s1 == s2) {
			System.out.println("True");
		}
		
		if (s1 == s3) {
			System.out.println("Again True");
		}
		
		
		//byte x;
		
		//System.out.println("byte x : " +x);
		
		Test t = new Test();
		
		t.byteTest(t);
		
		
	}
	
	// interesting 
	
	public void byteTest(Test tt) {
		
		int i;
		
		System.out.println("tt.x : " +tt.x);
		
	}

}
