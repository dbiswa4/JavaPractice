package com.java.code.dp.factory;

public abstract class Plan {
	
	protected double rate;
	
	abstract void getRate();
	
	public double calculateRate(int units){
		//System.out.println(units*rate);
		return units*rate;
	}
}
