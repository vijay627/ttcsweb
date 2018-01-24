package com.ttcs.dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class AdminParamPL {
	
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long objId;
	
	private Integer depositPcnt;
	private Integer numberOfinstallments;	
	private Double rateOfInterest;
	
	private Integer processingCharge;
	private Integer latePaymentStdFee;
	private Integer latePaymentVarFee;
	
	
	public Integer getLatePaymentStdFee() {
		return latePaymentStdFee;
	}
	public void setLatePaymentStdFee(Integer latePaymentStdFee) {
		this.latePaymentStdFee = latePaymentStdFee;
	}
	public Integer getLatePaymentVarFee() {
		return latePaymentVarFee;
	}
	public void setLatePaymentVarFee(Integer latePaymentVarFee) {
		this.latePaymentVarFee = latePaymentVarFee;
	}
	public Integer getNumberOfinstallments() {
		return numberOfinstallments;
	}
	public void setNumberOfinstallments(Integer numberOfinstallments) {
		this.numberOfinstallments = numberOfinstallments;
	}
	public Long getObjId() {
		return objId;
	}
	public void setObjId(Long objId) {
		this.objId = objId;
	}
	public Integer getProcessingCharge() {
		return processingCharge;
	}
	public void setProcessingCharge(Integer processingCharge) {
		this.processingCharge = processingCharge;
	}
	public Double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public Integer getDepositPcnt() {
		return depositPcnt;
	}
	public void setDepositPcnt(Integer depositPcnt) {
		this.depositPcnt = depositPcnt;
	}
	
	

	
	
	
	
	
	
}
