package com.java.test;


public class X 
{
    public static void main(String [] args) 
    {
        X x = new X();
        
        System.out.println("X x = new X() " +x);
        X x2 = m1(x); /* Line 6 */
        System.out.println("X x2 = m1(x) : " +x2);
        System.out.println("x : " +x);
        
        X x4 = new X();
        x2 = x4; /* Line 8 */
        //doComplexStuff();
    }
    static X m1(X mx) 
    {
    	System.out.println("in m1()");
    	System.out.println("mx : " +mx);
        mx = new X();
        System.out.println("mx = new X() : " +mx);
        System.out.println("Bye Bye m1()");
        return mx;
    }
}
