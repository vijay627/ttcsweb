package com.ttcs.web.command.society;

import java.util.Date;




public class OfficeDepositAccountCommand {
	
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
	
	private String disbursedDate;
	private String collectionStartDate;
	
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

	public String getAccountSatus() {
		return accountSatus;
	}

	public void setAccountSatus(String accountSatus) {
		this.accountSatus = accountSatus;
	}

	

	

	public String getCollectionStartDate() {
		return collectionStartDate;
	}

	public void setCollectionStartDate(String collectionStartDate) {
		this.collectionStartDate = collectionStartDate;
	}

	public void setDisbursedDate(String disbursedDate) {
		this.disbursedDate = disbursedDate;
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

	

	public String getDisbursedDate() {
		return disbursedDate;
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

	
	
	
	
	
	
}
