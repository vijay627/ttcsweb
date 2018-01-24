package com.ttcs.dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class AdminParamGS {
	
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
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
