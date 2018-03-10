package com.java.code.dp.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//Generate Bill by using the GetPlanFactory to get the object of concrete classes by passing an 
//information such as type of plan DOMESTICPLAN or COMMERCIALPLAN or INSTITUTIONALPLAN

public class GenerateBill {
	
	public static void main(String[] args) throws IOException {
		GetPlanFactory planFactory = new GetPlanFactory();
		
		System.out.print("Enter the name of plan for which the bill will be generated: ");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String planName=br.readLine();
		
		System.out.print("Enter the number of units for bill will be calculated: ");  
		int units=Integer.parseInt(br.readLine());
		
		Plan p = planFactory.getPlan(planName);
		p.getRate();
		double bill = p.calculateRate(units);
		System.out.print("Bill amount for "+planName+" of  "+units+" units is: " +bill);
	}
}
