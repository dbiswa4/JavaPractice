package com.java.test;


class A 
{ 
	public A(){}
    public A(int x){} 
} 
class B extends A { 
	
	public B(int y) {}
} 
public class DefConstructor 
{ 
    public static void main (String args []) 
    {
        A a = new B(7); 
        System.out.println("complete"); 
    } 
}


