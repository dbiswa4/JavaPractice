package com.java.test;



class PreNPostIncrement2 
{
    public static void main(String [] args) 
    {
        int x= 0;
        int y= 0;
        for (int z = 0; z < 5; z++)
        {
        	System.out.println("Before x++ : " +x);
        	
            if (( ++x > 2 ) && (++y > 2)) 
            {
            	
            	System.out.println("Inside if....");
                x++;
                

                
            }
            System.out.println("After x++ : " +x);
            System.out.println("y" +y);
        }
        System.out.println(x + " " + y);
    }
}