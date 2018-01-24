package com.ttcs.dao.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class TranGenSavings {
	
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tranId;
	
	private String custId;
	private String custName;
	private String accountNumber;
	
	private Date tranDate;
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
	public Date getTranDate() {
		return tranDate;
	}
	public void setTranDate(Date tranDate) {
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
