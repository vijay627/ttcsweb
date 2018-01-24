package com.ttcs.commons.pojo.utils;

import com.ttcs.commons.pojo.Bean;

public class EMIBean implements Bean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1594126840727900279L;

	private Double principal;
	
	private Double rateOfInterest;
	
	private Integer numberOfInstallments =0;
	
	private Long emiAmount;
	
	private Double totalInterest;
	
	private Double totalAmount;
	
	private EMIBreakupBean[] breakupBeanArray;

	public EMIBreakupBean[] getBreakupBeanArray() {
		
		                                      
		return breakupBeanArray;
	}

	public void setBreakupBeanArray(EMIBreakupBean[] breakupBeanArray) {
		
		if(numberOfInstallments != null){
			this.breakupBeanArray = new EMIBreakupBean[numberOfInstallments.intValue()];
		}
		
		this.breakupBeanArray = breakupBeanArray;
	}

	public Long getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(Long emiAmount) {
		this.emiAmount = emiAmount;
	}



	public Double getPrincipal() {
		return principal;
	}

	public void setPrincipal(Double principal) {
		this.principal = principal;
	}

	public Double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getTotalInterest() {
		return totalInterest;
	}

	public void setTotalInterest(Double totalInterest) {
		this.totalInterest = totalInterest;
	}

	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}

	
	
	

}
