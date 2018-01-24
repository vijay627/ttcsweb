package com.ttcs.dao.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ttcs.commons.pojo.society.PLEMIBreakupServiceBean;



@Entity
public class HandLoanDetails {
	
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long objId;
	
	private String custId;
	private String custName;
	
	
	private String loanAccountNumber;
	private Integer eligibleLoanAmount;
	private Integer requestedLoanAmount;
	private Double rateOfInterest;
	private Integer numberOfinstallments;
	
	
	private Integer processingCharge;
	private Integer latePaymentStdFee;
	private Integer latePaymentVarFee;
	
	private Date disbursedDate;
	private Date collectionStartDate;
	
	private Boolean enableLoanInsurance;
	private String loanInsuranceAccountNumber;
	private Integer loanInsurancePremium;
	
	private Integer disbursableAmount;
	
	
	private Long guarantorCustId;
	private String guarantorName;
	private Boolean customerDocsRecieved;
	private Boolean guarantorDocsRecieved;
	
	private String loanReason;
	private String accountSatus;
	
	private Long emiAmount;
	
	private Double totalInterest;
	
	private Double totalAmount;
	
	

	public String getAccountSatus() {
		return accountSatus;
	}

	public void setAccountSatus(String accountSatus) {
		this.accountSatus = accountSatus;
	}

	public Date getCollectionStartDate() {
		return collectionStartDate;
	}

	public void setCollectionStartDate(Date collectionStartDate) {
		this.collectionStartDate = collectionStartDate;
	}

	

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Boolean getCustomerDocsRecieved() {
		return customerDocsRecieved;
	}

	public void setCustomerDocsRecieved(Boolean customerDocsRecieved) {
		this.customerDocsRecieved = customerDocsRecieved;
	}

	public Integer getDisbursableAmount() {
		return disbursableAmount;
	}

	public void setDisbursableAmount(Integer disbursableAmount) {
		this.disbursableAmount = disbursableAmount;
	}

	public Date getDisbursedDate() {
		return disbursedDate;
	}

	public void setDisbursedDate(Date disbursedDate) {
		this.disbursedDate = disbursedDate;
	}

	public Integer getEligibleLoanAmount() {
		return eligibleLoanAmount;
	}

	public void setEligibleLoanAmount(Integer eligibleLoanAmount) {
		this.eligibleLoanAmount = eligibleLoanAmount;
	}

	public Boolean getEnableLoanInsurance() {
		return enableLoanInsurance;
	}

	public void setEnableLoanInsurance(Boolean enableLoanInsurance) {
		this.enableLoanInsurance = enableLoanInsurance;
	}

	public Long getGuarantorCustId() {
		return guarantorCustId;
	}

	public void setGuarantorCustId(Long guarantorCustId) {
		this.guarantorCustId = guarantorCustId;
	}

	public Boolean getGuarantorDocsRecieved() {
		return guarantorDocsRecieved;
	}

	public void setGuarantorDocsRecieved(Boolean guarantorDocsRecieved) {
		this.guarantorDocsRecieved = guarantorDocsRecieved;
	}

	public String getGuarantorName() {
		return guarantorName;
	}

	public void setGuarantorName(String guarantorName) {
		this.guarantorName = guarantorName;
	}

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

	public String getLoanAccountNumber() {
		return loanAccountNumber;
	}

	public void setLoanAccountNumber(String loanAccountNumber) {
		this.loanAccountNumber = loanAccountNumber;
	}

	public String getLoanInsuranceAccountNumber() {
		return loanInsuranceAccountNumber;
	}

	public void setLoanInsuranceAccountNumber(String loanInsuranceAccountNumber) {
		this.loanInsuranceAccountNumber = loanInsuranceAccountNumber;
	}

	public Integer getLoanInsurancePremium() {
		return loanInsurancePremium;
	}

	public void setLoanInsurancePremium(Integer loanInsurancePremium) {
		this.loanInsurancePremium = loanInsurancePremium;
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

	public Integer getRequestedLoanAmount() {
		return requestedLoanAmount;
	}

	public void setRequestedLoanAmount(Integer requestedLoanAmount) {
		this.requestedLoanAmount = requestedLoanAmount;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getLoanReason() {
		return loanReason;
	}

	public void setLoanReason(String loanReason) {
		this.loanReason = loanReason;
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

	public Long getEmiAmount() {
		return emiAmount;
	}

	public void setEmiAmount(Long emiAmount) {
		this.emiAmount = emiAmount;
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

	
	
	
	
	
	
	
}
