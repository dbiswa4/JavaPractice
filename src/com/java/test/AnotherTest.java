package com.java.test;

public class AnotherTest {


		    static int s;
		    public static void main(String [] args) 
		    {
		    	AnotherTest p = new AnotherTest();
		        p.start();
		        System.out.println(s);
		    }

		    void start() 
		    {
		        int x = 7;
		        twice(x);
		        System.out.print(x + " ");
		    }

		    void twice(int x) 
		    {
		        x = x*2;
		        s = x;
		    }
	

}
