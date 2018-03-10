package com.java.code.consensys;

public class Alternator{
    public static String alternate(String a, String b){
        String s = "";
        int i = 0;
        while (i < a.length() && i < b.length()){
            s += a.charAt(i) +""+ b.charAt(i); 
            i++;
        }
        while (i < a.length() ){
            s += a.charAt(i); 
            i++;
        }
        while (i < b.length()){
            s += b.charAt(i); 
            i++;
        }
        return s;
    }
    
    
    public static void main(String[] args){
        String a = "two", b = "onexxx";
        String s = Alternator.alternate(a,b);
        System.out.println(s);
    }
}
