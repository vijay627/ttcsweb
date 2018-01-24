package com.ttcs.dao.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class GenSavingsDetails {
	
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long objId;
	
	private String custId;
	private String custName;
	
	
	private String savingsAccountNumber;
	private Double balanceAmount;
	private Double rateOfInterest;
	private Date openingDate;
	private String frequency;
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	public Double getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public Long getObjId() {
		return objId;
	}
	public void setObjId(Long objId) {
		this.objId = objId;
	}
	
	public Date getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	public Double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public String getSavingsAccountNumber() {
		return savingsAccountNumber;
	}
	public void setSavingsAccountNumber(String savingsAccountNumber) {
		this.savingsAccountNumber = savingsAccountNumber;
	}

	
	
	
	
	
	
}
