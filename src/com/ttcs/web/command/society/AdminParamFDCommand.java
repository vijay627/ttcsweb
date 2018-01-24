package com.ttcs.web.command.society;






public class AdminParamFDCommand {
	

	private String function;
	private Long objId;
	
	private Integer minimumDeposit;	
	private Double rateOfInterest;
	
	private String  frequency;

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public Integer getMinimumDeposit() {
		return minimumDeposit;
	}

	public void setMinimumDeposit(Integer minimumDeposit) {
		this.minimumDeposit = minimumDeposit;
	}

	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}

	public Double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	
	
}
