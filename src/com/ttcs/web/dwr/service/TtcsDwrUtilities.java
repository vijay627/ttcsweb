package com.ttcs.web.dwr.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;

import com.ttcs.commons.CommandExecutorInterface;
import com.ttcs.commons.pojo.society.GenSavingsDetailsServiceBean;
import com.ttcs.commons.pojo.society.HLEMIBreakupServiceBean;
import com.ttcs.commons.pojo.society.HandLoanDetailsServiceBean;
import com.ttcs.commons.pojo.society.PLEMIBreakupServiceBean;
import com.ttcs.commons.pojo.society.PersonalLoanDetailsServiceBean;
import com.ttcs.commons.pojo.society.StmtGenSavingsServiceBean;
import com.ttcs.commons.pojo.society.TranGenSavingsServiceBean;
import com.ttcs.commons.pojo.utils.EMIBean;
import com.ttcs.commons.pojo.utils.EMIBreakupBean;

public class TtcsDwrUtilities {

	/** The command executor. */
	private static CommandExecutorInterface commandExecutor;
	
	public TtcsDwrUtilities()
	{
		
	}
	
	
	public EMIBean generateEMI(String principal, String roi, String numberOfInstallments, String startDate)
	{
		
		System.out.println("Loan ::"+principal+" :: "+roi+ " :: "+numberOfInstallments);
		double loanAmount = Double.parseDouble(principal);
		double rateOfInterest = Double.parseDouble(roi);
		int numberOfMonths = Integer.parseInt(numberOfInstallments);
		
		//return calcEmiAllMonths(loanAmount, rateOfInterest, numberOfMonths, startDate);
		return calcMonthlyEMI(loanAmount, rateOfInterest, numberOfMonths, startDate);
		
		
	}
	
	private Double calcEmi(double p, double r, int n) {
        double R = (r / 12) / 100;
        double e = (p * R * (Math.pow((1 + R), n)) / ((Math.pow((1 + R), n)) - 1));

        return e;
}

		 private EMIBean calcEmiAllMonths(double p, double r, int n, String startDate) {
	
			EMIBean emiBean = null;
			 
			try {
				
				emiBean = new EMIBean();
				double R = (r / 12) / 100;
				double P = p;
				double e = calcEmi(P, r, n);
				double totalInt = Math.round((e * n) - p);
				double totalAmt = Math.round((e * n));
				long emiAmount = Math.round(e);
	      
				emiBean.setPrincipal(p);        
				emiBean.setRateOfInterest(r);
				emiBean.setNumberOfInstallments(n);
				emiBean.setEmiAmount(emiAmount);
				emiBean.setTotalInterest(totalInt);
				emiBean.setTotalAmount(totalAmt);
				
				/*System.out.println("***************************");
				System.out.println(" Principal-> " + P);
				System.out.println(" Rate of Interest-> " + r);
				System.out.println(" Number of Months-> " + n);
				System.out.println(" EMI -> " + Math.round(e));
				System.out.println(" Total Interest -> " + totalInt);
				System.out.println(" Total Amount -> " + totalAmt);
				System.out.println("***************************");*/
				double intPerMonth = Math.round(totalInt / n);
				
				EMIBreakupBean[] breakupBeanArray = new EMIBreakupBean[n];
				
				EMIBreakupBean breakupBean = null;
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				Date date = formatter.parse(startDate);
			    Calendar calstart=Calendar.getInstance();  
	
			    String emiDate = formatter.format(date);
			    System.out.println("emiDate :: "+emiDate);
				for (int i = 1; i <= n; i++) {
				        intPerMonth = (P * R);
				        P = ((P) - ((e) - (intPerMonth)));
				        
				        
				        breakupBean = new EMIBreakupBean();
				        
				        breakupBean.setInstallmentNumber(i);                
				        breakupBean.setInstallmentDate(emiDate);
				        breakupBean.setPrincipalPerMonth(new Double(Math.round((e) - intPerMonth)));
				        breakupBean.setInterestPerMonth(new Double(Math.round(intPerMonth)));
				        breakupBean.setBalancePrincipal(new Double(Math.round(P)));
				        breakupBean.setTotalInstallmentAmount(new Double(emiAmount));
				        
				        breakupBean.setLatePaymentStdFee(0D);
				        breakupBean.setLatePaymentVarFee(0D);
				        breakupBean.setDiscountAmount(0D);
				        breakupBean.setReason("");
				        breakupBean.setInstallmentStatus("Pending");
				        breakupBean.setPaidAmount(0D);
				        breakupBean.setPaidDate("");
				        
				        
				        /* System.out.println(" Month -> " + (int) i);
				        System.out.println(" Interest per month -> "
				                        + Math.round(intPerMonth));
				        System.out.println(" Principal per month -> "
				                        + Math.round((e) - intPerMonth));
				        System.out.println(" Balance Principal -> " + Math.round(P));
				        System.out.println("***************************");*/
				        
				        //System.out.println(breakupBean.getInstallmentNumber());
				        
				        breakupBeanArray[i-1] = breakupBean;
				        
				        //date = DateUtils.addMonths(date, 1);
				        
				        calstart.setTime(date);
				        calstart.add(Calendar.MONTH, 1);  
				        System.out.println(calstart.getTime());
				        date = calstart.getTime();
				        emiDate = formatter.format(calstart.getTime());  
	
	
	
				        
				}
				//System.out.println("length :: "+breakupBeanArray);
				emiBean.setBreakupBeanArray(breakupBeanArray);
			}catch (RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        return emiBean;
	}
	
		 
		 private EMIBean calcMonthlyEMI(double p, double r, int n, String startDate) {
				
				EMIBean emiBean = null;
				 
				try {
					
					emiBean = new EMIBean();
					double rateOfinterest = (r / 12) / 100;
					double monthlyPrincipal = 0;
					double remainingPrincipal = p;
					double monthlyInterest =0;
					double totalInterest =0;
					double totalAmount = p;
					
					double emiAmount = 0;
					
					emiBean.setPrincipal(p);        
					emiBean.setRateOfInterest(r);
					emiBean.setNumberOfInstallments(n);
					//emiBean.setEmiAmount(emiAmount);
					
					
					
					EMIBreakupBean[] breakupBeanArray = new EMIBreakupBean[n];
					
					EMIBreakupBean breakupBean = null;
					
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Date date = formatter.parse(startDate);
				    Calendar calstart=Calendar.getInstance();  
		
				    String emiDate = formatter.format(date);
					
					int j=0;
				    for (int i = n; i>0; i--) {
						
						monthlyPrincipal =  Math.round(remainingPrincipal/i);						
						monthlyInterest =  Math.round(remainingPrincipal*rateOfinterest);
						totalInterest = Math.round(totalInterest + monthlyInterest);
						remainingPrincipal = Math.round(remainingPrincipal-monthlyPrincipal);	
						emiAmount = monthlyPrincipal+monthlyInterest;
						
						
						breakupBean = new EMIBreakupBean();
				        
				        breakupBean.setInstallmentNumber(j+1);                
				        breakupBean.setInstallmentDate(emiDate);
				        breakupBean.setPrincipalPerMonth(monthlyPrincipal);
				        breakupBean.setInterestPerMonth(monthlyInterest);
				        breakupBean.setBalancePrincipal(remainingPrincipal);
				        breakupBean.setTotalInstallmentAmount(emiAmount);
				        
				        
				        breakupBean.setLatePaymentStdFee(0D);
				        breakupBean.setLatePaymentVarFee(0D);
				        breakupBean.setDiscountAmount(0D);
				        breakupBean.setReason("");
				        breakupBean.setInstallmentStatus("Pending");
				        breakupBean.setPaidAmount(0D);
				        breakupBean.setPaidDate("");
				        
				        
				        
				        breakupBeanArray[j] = breakupBean;
				        
				      
				        
				        calstart.setTime(date);
				        calstart.add(Calendar.MONTH, 1);  
				        //System.out.println(calstart.getTime());
				        date = calstart.getTime();
				        emiDate = formatter.format(calstart.getTime()); 
						
				        j++;
					}
					
					totalAmount = totalAmount+totalInterest;
					emiBean.setTotalInterest(totalInterest);
					emiBean.setTotalAmount(totalAmount);
					
					
					emiBean.setBreakupBeanArray(breakupBeanArray);
				}catch (RuntimeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		        
		        return emiBean;
		}
	
	
	public String signOutFromApplication(HttpServletRequest req)
	{
		
		req.getSession().invalidate();
		
		return null;
	}
	
	
	public String genSavingsTranPopup(String custId, String custName, String accountNumber, String avaialableAmount, String tranTYpe, String tranAmount)
	{
		String returnMessage = "Operation has been successfully completed";
		
		try {
			
			TranGenSavingsServiceBean tranGenSavingsServiceBean = new TranGenSavingsServiceBean();
			
			tranGenSavingsServiceBean.setCustId(custId);
			tranGenSavingsServiceBean.setCustName(custName);
			tranGenSavingsServiceBean.setAccountNumber(accountNumber);
			
			double availableAmt = Double.parseDouble(avaialableAmount);
			double tranAmt = Double.parseDouble(tranAmount);
			double closingBalance = 0;
			
			if("D".equalsIgnoreCase(tranTYpe))
			{
				closingBalance = availableAmt+tranAmt;
				tranGenSavingsServiceBean.setDepositAmount(tranAmt);
				tranGenSavingsServiceBean.setTranDesc("By Cash");
				
			}else if("W".equalsIgnoreCase(tranTYpe))
			{
				closingBalance = availableAmt-tranAmt;
				tranGenSavingsServiceBean.setWithdrawalAmount(tranAmt);
				tranGenSavingsServiceBean.setTranDesc("To Cash");
			}
			tranGenSavingsServiceBean.setClosingBalance(closingBalance);
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String tranDate = formatter.format(new Date());
			
			formatter.parse(tranDate);
			
			tranGenSavingsServiceBean.setTranDate(tranDate);
			
			
			
			
			
			tranGenSavingsServiceBean.setFunction("A");
			
			tranGenSavingsServiceBean = (TranGenSavingsServiceBean) getCommandExecutor().execute(tranGenSavingsServiceBean);
			
			
			GenSavingsDetailsServiceBean newGenSavingsServiceBean = new GenSavingsDetailsServiceBean();
			newGenSavingsServiceBean.setFunction("R");
			newGenSavingsServiceBean.setCustId(custId);
			
			newGenSavingsServiceBean = (GenSavingsDetailsServiceBean) getCommandExecutor().execute(newGenSavingsServiceBean);
			newGenSavingsServiceBean.setBalanceAmount(closingBalance);
			newGenSavingsServiceBean.setFunction("U");
			newGenSavingsServiceBean = (GenSavingsDetailsServiceBean) getCommandExecutor().execute(newGenSavingsServiceBean);
			
		} catch (Exception e) {
			returnMessage = "Operation failed due to "+e.getMessage();
		}
		return returnMessage;
	}
	
	
	public TranGenSavingsServiceBean[] genSavingsStmtPopup(String custId, String custName, String accountNumber)
	{
		
		TranGenSavingsServiceBean[] tranGenSavingsServiceBean = null;
		
		try {
			
			StmtGenSavingsServiceBean stmtGenSavingsServiceBean = new StmtGenSavingsServiceBean();
			
			
			stmtGenSavingsServiceBean.setCustId(custId);
			stmtGenSavingsServiceBean.setAccountNumber(accountNumber);
			
			
			stmtGenSavingsServiceBean = (StmtGenSavingsServiceBean) getCommandExecutor().execute(stmtGenSavingsServiceBean);
			
			List<TranGenSavingsServiceBean> tranServiceBeanList = stmtGenSavingsServiceBean.getTranGenSavingsServiceBeanList();
			
			Collections.sort(tranServiceBeanList, new GenSavingsTranComparator());
			
			if(tranServiceBeanList !=null && tranServiceBeanList.size()>0)
			{
				tranGenSavingsServiceBean = new TranGenSavingsServiceBean[tranServiceBeanList.size()];
				
				int i=0;
				for (TranGenSavingsServiceBean tranGenSavingsBean:tranServiceBeanList) {
					tranGenSavingsServiceBean[i] = tranGenSavingsBean;
					i++;
				}
				
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tranGenSavingsServiceBean;
	}
	
	
	public PersonalLoanDetailsServiceBean personalLoanTranDetails(String custId, String custName, String accountNumber)
	{
		
		PersonalLoanDetailsServiceBean newPersonalLoanServiceBean = new PersonalLoanDetailsServiceBean();
		
		
		 
		try {
			
			newPersonalLoanServiceBean.setCustId(custId);
			newPersonalLoanServiceBean.setCustName(custName);
			newPersonalLoanServiceBean.setLoanAccountNumber(accountNumber);
			newPersonalLoanServiceBean.setFunction("ER");
			
			
			newPersonalLoanServiceBean = (PersonalLoanDetailsServiceBean) getCommandExecutor().execute(newPersonalLoanServiceBean);
			
			
			
			
			List<PLEMIBreakupServiceBean> plEMIBreakupServiceBeanList = newPersonalLoanServiceBean.getPLEMIBreakupServiceBeanList();
			
			PLEMIBreakupServiceBean breakupBean = null;
			
			
			
			if(plEMIBreakupServiceBeanList !=null && plEMIBreakupServiceBeanList.size()>0)
			{
				
				PLEMIBreakupServiceBean[] breakupBeanArray = new PLEMIBreakupServiceBean[plEMIBreakupServiceBeanList.size()];
				
				int j=0;
				for(PLEMIBreakupServiceBean plEMIBreakupServiceBean:plEMIBreakupServiceBeanList)
				{
					breakupBean = new PLEMIBreakupServiceBean();
					BeanUtils.copyProperties(plEMIBreakupServiceBean,breakupBean);
					breakupBeanArray[j] = breakupBean;
					
					j++;
				}
				
				newPersonalLoanServiceBean.setBreakupBeanArray(breakupBeanArray);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newPersonalLoanServiceBean;
	}
	
	
	
	public String personalLoanEMIPayment(PersonalLoanDetailsServiceBean personalLoanServiceBean)
	{
		String returnMessage = "Operation has been successfully completed";
		
		try {
			
			List<PLEMIBreakupServiceBean> plEMIBreakupServiceBeanList = new ArrayList<PLEMIBreakupServiceBean>();
			
			PLEMIBreakupServiceBean[] beanArray =  personalLoanServiceBean.getBreakupBeanArray();
			
			for (int i = 0; i < beanArray.length; i++) {
				plEMIBreakupServiceBeanList.add(beanArray[i]);
			}
			
			personalLoanServiceBean.setPLEMIBreakupServiceBeanList(plEMIBreakupServiceBeanList);
				
			personalLoanServiceBean.setFunction("U");			
			
			personalLoanServiceBean = (PersonalLoanDetailsServiceBean) getCommandExecutor().execute(personalLoanServiceBean);
			
			
		} catch (Exception e) {
			returnMessage = "Operation failed due to "+e.getMessage();
		}
		return returnMessage;
	}
	
	public HandLoanDetailsServiceBean handLoanTranDetails(String custId, String custName, String accountNumber)
	{
		
		HandLoanDetailsServiceBean newHandLoanServiceBean = new HandLoanDetailsServiceBean();
		
		
		 
		try {
			
			newHandLoanServiceBean.setCustId(custId);
			newHandLoanServiceBean.setCustName(custName);
			newHandLoanServiceBean.setLoanAccountNumber(accountNumber);
			newHandLoanServiceBean.setFunction("ER");
			
			
			newHandLoanServiceBean = (HandLoanDetailsServiceBean) getCommandExecutor().execute(newHandLoanServiceBean);
			
			
			
			
			List<HLEMIBreakupServiceBean> hlEMIBreakupServiceBeanList = newHandLoanServiceBean.getHLEMIBreakupServiceBeanList();
			
			HLEMIBreakupServiceBean breakupBean = null;
			
			
			
			if(hlEMIBreakupServiceBeanList !=null && hlEMIBreakupServiceBeanList.size()>0)
			{
				
				HLEMIBreakupServiceBean[] breakupBeanArray = new HLEMIBreakupServiceBean[hlEMIBreakupServiceBeanList.size()];
				
				int j=0;
				for(HLEMIBreakupServiceBean hlEMIBreakupServiceBean:hlEMIBreakupServiceBeanList)
				{
					breakupBean = new HLEMIBreakupServiceBean();
					BeanUtils.copyProperties(hlEMIBreakupServiceBean,breakupBean);
					breakupBeanArray[j] = breakupBean;
					
					j++;
				}
				
				newHandLoanServiceBean.setBreakupBeanArray(breakupBeanArray);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newHandLoanServiceBean;
	}
	
	
	
	public String handLoanEMIPayment(HandLoanDetailsServiceBean handLoanServiceBean)
	{
		String returnMessage = "Operation has been successfully completed";
		
		try {
			
			List<HLEMIBreakupServiceBean> hlEMIBreakupServiceBeanList = new ArrayList<HLEMIBreakupServiceBean>();
			
			HLEMIBreakupServiceBean[] beanArray =  handLoanServiceBean.getBreakupBeanArray();
			
			for (int i = 0; i < beanArray.length; i++) {
				hlEMIBreakupServiceBeanList.add(beanArray[i]);
			}
			
			handLoanServiceBean.setHLEMIBreakupServiceBeanList(hlEMIBreakupServiceBeanList);
				
			handLoanServiceBean.setFunction("U");			
			
			handLoanServiceBean = (HandLoanDetailsServiceBean) getCommandExecutor().execute(handLoanServiceBean);
			
			
		} catch (Exception e) {
			returnMessage = "Operation failed due to "+e.getMessage();
		}
		return returnMessage;
	}
	
	public static CommandExecutorInterface getCommandExecutor() {
		return commandExecutor;
	}

	public void setCommandExecutor(CommandExecutorInterface commandExecutor) {
		TtcsDwrUtilities.commandExecutor = commandExecutor;
	}

	
	
	public class GenSavingsTranComparator implements Comparator<TranGenSavingsServiceBean>
	{
	    public int compare(TranGenSavingsServiceBean t1, TranGenSavingsServiceBean t2)
	    {
	        return (int)(t2.getTranId() - t1.getTranId());
	    }
	}
	

	
}
