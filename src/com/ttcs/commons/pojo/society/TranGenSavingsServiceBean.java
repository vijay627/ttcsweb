package com.ttcs.commons.pojo.society;

import java.util.Date;

import com.ttcs.commons.pojo.Bean;




public class TranGenSavingsServiceBean implements Bean{
	
	private String function;
	private Long tranId;
	
	private String custId;
	private String custName;
	private String accountNumber;
	
	private String tranDate;
	private String tranDesc;
	private Double depositAmount;
	private Double withdrawalAmount;
	private Double closingBalance;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(Double closingBalance) {
		this.closingBalance = closingBalance;
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
	public Double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public String getTranDesc() {
		return tranDesc;
	}
	public void setTranDesc(String tranDesc) {
		this.tranDesc = tranDesc;
	}
	public Long getTranId() {
		return tranId;
	}
	public void setTranId(Long tranId) {
		this.tranId = tranId;
	}
	public Double getWithdrawalAmount() {
		return withdrawalAmount;
	}
	public void setWithdrawalAmount(Double withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}
	
	
	
	
	
	
	
	
}
