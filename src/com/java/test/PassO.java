package com.java.test;



class Two 
{
    byte x;
}

class PassO 
{
    public static void main(String [] args) 
    {
        PassO p = new PassO();
        p.start();
    }

    void start() 
    {
        Two t = new Two();
        System.out.println(t.x + " ");
        System.out.println("t : " +t);
        Two t2 = fix(t);
        System.out.println("After coming out of fix()");
        System.out.println("t2 : " +t2);
        System.out.println(t.x + " " + t2.x);
    }

    Two fix(Two tt) 
    {
    	System.out.println("In fix method");
    	System.out.println("tt : " +tt);
        tt.x = 42;
        return tt;
    }
}
