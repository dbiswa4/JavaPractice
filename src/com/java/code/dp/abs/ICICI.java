package com.java.code.dp.abs;

public class ICICI implements Bank {
	
	public final String BNAME;
	
	public ICICI(){
		BNAME = "ICICI BANK";
	}

	@Override
	public String getBankName() {
		return BNAME;
	}

}
