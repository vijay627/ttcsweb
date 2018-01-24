package com.ttcs.commons.pojo.society;

import java.util.List;

import com.ttcs.commons.pojo.Bean;




public class StmtGenSavingsServiceBean implements Bean{
	
	
	
	private String custId;
	private String accountNumber;
	
	private List<TranGenSavingsServiceBean> tranGenSavingsServiceBeanList;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public List<TranGenSavingsServiceBean> getTranGenSavingsServiceBeanList() {
		return tranGenSavingsServiceBeanList;
	}

	public void setTranGenSavingsServiceBeanList(
			List<TranGenSavingsServiceBean> tranGenSavingsServiceBeanList) {
		this.tranGenSavingsServiceBeanList = tranGenSavingsServiceBeanList;
	}
	
	
	
	
	
	
	
	
	
	
}
