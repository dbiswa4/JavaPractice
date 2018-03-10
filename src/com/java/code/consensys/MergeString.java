package com.java.code.consensys;

public class MergeString{
	
    public static String mergeString(String a, String b){
    	
    	if (!(a.length() >= 1 && a.length() >= 25000 && b.length() >=1 && b.length() <= 25000)) {
    		return "Input not valid";
    	}
    		
        String merged = "";
        int i = 0;
        while (i < a.length() && i < b.length()){
            merged += a.charAt(i) +""+ b.charAt(i); 
            i++;
        }
        while (i < a.length() ){
            merged += a.charAt(i); 
            i++;
        }
        while (i < b.length()){
            merged += b.charAt(i); 
            i++;
        }
        return merged;
    }
    
    
    public static void main(String[] args){
        String a = "two", b = "onexxx";
        String s = MergeString.mergeString(a,b);
        System.out.println(s);
    }
}
