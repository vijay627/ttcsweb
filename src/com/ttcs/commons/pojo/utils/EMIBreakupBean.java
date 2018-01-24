package com.ttcs.commons.pojo.utils;

import com.ttcs.commons.pojo.Bean;

public class EMIBreakupBean implements Bean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1594126840727900279L;

	private Integer installmentNumber;
	
	private String installmentDate;
	
	private Double principalPerMonth;
	
	private Double interestPerMonth;
	
	private Double latePaymentStdFee;
	
	private Double latePaymentVarFee;
	
	private Double discountAmount;
	
	private String reason;
	
	private Double totalInstallmentAmount;
	
	private Double paidAmount;
	
	private String paidDate;
	
	private Double balancePrincipal;
	
	private String installmentStatus;

	public Double getBalancePrincipal() {
		return balancePrincipal;
	}

	public void setBalancePrincipal(Double balancePrincipal) {
		this.balancePrincipal = balancePrincipal;
	}

	public String getInstallmentDate() {
		return installmentDate;
	}

	public void setInstallmentDate(String installmentDate) {
		this.installmentDate = installmentDate;
	}

	public Integer getInstallmentNumber() {
		return installmentNumber;
	}

	public void setInstallmentNumber(Integer installmentNumber) {
		this.installmentNumber = installmentNumber;
	}

	public String getInstallmentStatus() {
		return installmentStatus;
	}

	public void setInstallmentStatus(String installmentStatus) {
		this.installmentStatus = installmentStatus;
	}

	public Double getInterestPerMonth() {
		return interestPerMonth;
	}

	public void setInterestPerMonth(Double interestPerMonth) {
		this.interestPerMonth = interestPerMonth;
	}

	public Double getLatePaymentStdFee() {
		return latePaymentStdFee;
	}

	public void setLatePaymentStdFee(Double latePaymentStdFee) {
		this.latePaymentStdFee = latePaymentStdFee;
	}

	public Double getLatePaymentVarFee() {
		return latePaymentVarFee;
	}

	public void setLatePaymentVarFee(Double latePaymentVarFee) {
		this.latePaymentVarFee = latePaymentVarFee;
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}

	public Double getPrincipalPerMonth() {
		return principalPerMonth;
	}

	public void setPrincipalPerMonth(Double principalPerMonth) {
		this.principalPerMonth = principalPerMonth;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Double getTotalInstallmentAmount() {
		return totalInstallmentAmount;
	}

	public void setTotalInstallmentAmount(Double totalInstallmentAmount) {
		this.totalInstallmentAmount = totalInstallmentAmount;
	}
	
	
	

}
