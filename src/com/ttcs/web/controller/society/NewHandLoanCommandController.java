package com.ttcs.web.controller.society;


import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.ttcs.commons.exception.TtcsException;
import com.ttcs.commons.pojo.society.AdminParamHLServiceBean;
import com.ttcs.commons.pojo.society.GenSavingsDetailsServiceBean;
import com.ttcs.commons.pojo.society.HLEMIBreakupServiceBean;
import com.ttcs.commons.pojo.society.HandLoanDetailsServiceBean;
import com.ttcs.web.command.society.CustomerDetailsCommand;
import com.ttcs.web.command.society.ExistingCustomerCommand;
import com.ttcs.web.command.society.HandLoanDetailsCommand;
import com.ttcs.web.controller.AbstractTtcsCommandController;



// TODO: Auto-generated Javadoc
/**
 * The Class PrintManagementController.
 */
@SuppressWarnings("unchecked")
public class NewHandLoanCommandController extends AbstractTtcsCommandController {
 	
	 

	public ModelAndView handleInit(HttpServletRequest request,
			HttpServletResponse response, Object inputCommand, BindException be)
			throws Throwable {
		HandLoanDetailsCommand handLoanDetailsCommand = (HandLoanDetailsCommand) inputCommand;
		
		System.out.println("why it is not coming");
		
		return  doNormal(handLoanDetailsCommand, request, be, response);
		
		
	}
	
	
	/**
	 * Do normal.
	 * 
	 * @param printManagementCommand the Print Management command
	 * @param req the req
	 * @param drawing the drawing
	 * @param be the be
	 * @param response the response
	 * 
	 * @return the model and view
	 * 
	 */
	private ModelAndView doNormal(
			HandLoanDetailsCommand handLoanDetailsCommand,
			HttpServletRequest req, BindException be, HttpServletResponse response) throws TtcsException,  InvocationTargetException, Throwable  {
		ModelAndView modelAndView = null;
		
		
		modelAndView = new ModelAndView(this.getInputFormView());
		
		String strBtnPressed = (String)req.getParameter("btnPressed");
		
		System.out.println("strBtnPressed ::"+strBtnPressed);
		
		try {
			
			if(req.getSession().getAttribute("customerDetailsCommand") ==null)
			{
				ExistingCustomerCommand existingCustomerCommand = new ExistingCustomerCommand();
				modelAndView = new ModelAndView("existingCustomer");
				modelAndView.addObject("existingCustomerCommand",	existingCustomerCommand);
			}else
			{
			
				CustomerDetailsCommand customerDetailsCommand = (CustomerDetailsCommand)req.getSession().getAttribute("customerDetailsCommand");
				
				if(StringUtils.isNotEmpty(strBtnPressed) )
				{
					HandLoanDetailsServiceBean newHandLoanServiceBean = new HandLoanDetailsServiceBean();
					
					
						PropertyUtils.copyProperties(newHandLoanServiceBean, handLoanDetailsCommand);
						newHandLoanServiceBean.setFunction("A");
						
						
						newHandLoanServiceBean = calcMonthlyEMI(newHandLoanServiceBean);
						
						
						newHandLoanServiceBean = (HandLoanDetailsServiceBean) getCommandExecutor().execute(newHandLoanServiceBean);
						
						PropertyUtils.copyProperties(handLoanDetailsCommand, newHandLoanServiceBean);
					
				}else
				{
					
					System.out.println("Hitting controller");
					AdminParamHLServiceBean adminParamHLServiceBean = new AdminParamHLServiceBean();
					
					adminParamHLServiceBean.setFunction("R");
					
					adminParamHLServiceBean = (AdminParamHLServiceBean) getCommandExecutor().execute(adminParamHLServiceBean);
					
					handLoanDetailsCommand.setNumberOfinstallments(adminParamHLServiceBean.getNumberOfinstallments());
					handLoanDetailsCommand.setRateOfInterest(adminParamHLServiceBean.getRateOfInterest());
					handLoanDetailsCommand.setProcessingCharge(adminParamHLServiceBean.getProcessingCharge());
					handLoanDetailsCommand.setLatePaymentStdFee(adminParamHLServiceBean.getLatePaymentStdFee());
					handLoanDetailsCommand.setLatePaymentVarFee(adminParamHLServiceBean.getLatePaymentVarFee());
					
					
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Date date = new Date();
					String disbursedDate = formatter.format(date);
					
					Calendar calstart=Calendar.getInstance();
					calstart.setTime(date);
					calstart.add(Calendar.MONTH, 1);
			        date = calstart.getTime();
			        String collectionStartDate = formatter.format(calstart.getTime());
			        
			        
			        
			        handLoanDetailsCommand.setDisbursedDate(disbursedDate);
			        handLoanDetailsCommand.setCollectionStartDate(collectionStartDate);
			        handLoanDetailsCommand.setLoanAccountNumber("HL"+disbursedDate.replace("/", ""));
			        handLoanDetailsCommand.setLoanInsuranceAccountNumber("LI"+disbursedDate.replace("/", ""));
			        
			        handLoanDetailsCommand.setLoanReason("Personal");
			        
			       
					
					String custName = customerDetailsCommand.getFirstName();
					
					
					
					//handLoanDetailsCommand.setCustId(customerDetailsCommand.getCustId());
					handLoanDetailsCommand.setCustName(custName);
					
					/*
					 * Get Saving Account Details
					 */
					GenSavingsDetailsServiceBean genSavingsDetailsServiceBean = new GenSavingsDetailsServiceBean();
					//genSavingsDetailsServiceBean.setCustId(customerDetailsCommand.getCustId());
					genSavingsDetailsServiceBean.setFunction("R");		
					
					genSavingsDetailsServiceBean = (GenSavingsDetailsServiceBean) getCommandExecutor().execute(genSavingsDetailsServiceBean);
					
					Integer eligibleLoanAmount = adminParamHLServiceBean.getDepositPcnt() !=null?(int)Math.round(genSavingsDetailsServiceBean.getBalanceAmount()*adminParamHLServiceBean.getDepositPcnt()):(int)Math.round(genSavingsDetailsServiceBean.getBalanceAmount()*10);
					
					handLoanDetailsCommand.setEligibleLoanAmount(eligibleLoanAmount);
					handLoanDetailsCommand.setAccountSatus("Active");
					
					
			        System.out.println("return");
			        
				}
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("handLoanDetailsCommand",	handLoanDetailsCommand);	
		
		
		return modelAndView;
	}
	
	
		private HandLoanDetailsServiceBean calcMonthlyEMI(HandLoanDetailsServiceBean emiBean) {
			
			double p=emiBean.getRequestedLoanAmount();
			double r=emiBean.getRateOfInterest(); 
			int n =(int)emiBean.getNumberOfinstallments(); 
			String startDate = emiBean.getCollectionStartDate();
			
			
			
			 
			try {
				
				
				double rateOfinterest = (r / 12) / 100;
				double monthlyPrincipal = 0;
				double remainingPrincipal = p;
				double monthlyInterest =0;
				double totalInterest =0;
				double totalAmount = p;
				
				double emiAmount = 0;
				
				
				
				
				
				List<HLEMIBreakupServiceBean> breakupBeanArray = new ArrayList<HLEMIBreakupServiceBean>();
				
				HLEMIBreakupServiceBean breakupBean = null;
				
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
					
					
					breakupBean = new HLEMIBreakupServiceBean();
			        
					breakupBean.setCustId(emiBean.getCustId());
					breakupBean.setCustName(emiBean.getCustName());
					breakupBean.setLoanAccountNumber(emiBean.getLoanAccountNumber());
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
			        
			        
			        
			        breakupBeanArray.add(breakupBean);
			        
			      
			        
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
				
				
				emiBean.setHLEMIBreakupServiceBeanList(breakupBeanArray);
			}catch (RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        return emiBean;
	}

	
	
	public ModelAndView handleValidForm(HttpServletRequest req,
			HttpServletResponse res, Object inputCommand, BindException be)
			throws Throwable {
		return handleInit(req, res, inputCommand, be);
	}
	

	
}
