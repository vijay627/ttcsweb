package com.ttcs.dao.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ttcs.commons.pojo.society.PLEMIBreakupServiceBean;



@Entity
public class HLEMIBreakupDetails {
	
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tranId;
	
	private String custId;
	private String custName;
	
	
	private String loanAccountNumber;
	
	private Integer installmentNumber;
	
	private Date installmentDate;
	
	private Double principalPerMonth;
	
	private Double interestPerMonth;
	
	private Double latePaymentStdFee;
	
	private Double latePaymentVarFee;
	
	private Double discountAmount;
	
	private String reason;
	
	private Double totalInstallmentAmount;
	
	private Double paidAmount;
	
	private Date paidDate;
	
	private Double balancePrincipal;
	
	private String installmentStatus;

	public Double getBalancePrincipal() {
		return balancePrincipal;
	}

	public void setBalancePrincipal(Double balancePrincipal) {
		this.balancePrincipal = balancePrincipal;
	}

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

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
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

	public String getLoanAccountNumber() {
		return loanAccountNumber;
	}

	public void setLoanAccountNumber(String loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	

	public Date getInstallmentDate() {
		return installmentDate;
	}

	public void setInstallmentDate(Date installmentDate) {
		this.installmentDate = installmentDate;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public Double getPrincipalPerMonth() {
		return principalPerMonth;
	}

	public void setPrincipalPerMonth(Double principalPerMonth) {
		this.principalPerMonth = principalPerMonth;
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

	public Long getTranId() {
		return tranId;
	}

	public void setTranId(Long tranId) {
		this.tranId = tranId;
	}
	
	

	
	
	
	
	
	
}
