package com.java.code.dp.abs;

//Concrete classes that implement the Bank interface

public class HDFC implements Bank {
	private final String BNAME;
	
	public HDFC() {
		BNAME = "HDFC BANK";
	}

	@Override
	public String getBankName() {
		// TODO Auto-generated method stub
		return BNAME;
	}

}
