package com.java.code.dp.factory;

//generate object of concrete classes based on given information
public class GetPlanFactory {
	
	public Plan getPlan(String planType) {
		
		if (planType == null)
			return null;
		
		if(planType.equalsIgnoreCase("DOMESTICPLAN"))
			return new DomesticPlan();
		
		if(planType.equalsIgnoreCase("COMMERCIALPLAN"))
			return new CommercialPlan();
		
		if(planType.equalsIgnoreCase("INSTITUTIONALPLAN"))
			return new InstitutionalPlan();
		
		return null;
	}

}
