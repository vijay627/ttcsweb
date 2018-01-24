package com.ttcs.web.controller.society;


import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.ttcs.commons.exception.TtcsException;
import com.ttcs.commons.pojo.society.CustomerDetailsServiceBean;
import com.ttcs.commons.pojo.society.GenSavingsDetailsServiceBean;
import com.ttcs.commons.pojo.society.HandLoanDetailsServiceBean;
import com.ttcs.commons.pojo.society.PersonalLoanDetailsServiceBean;
import com.ttcs.web.command.society.CustomerAccountDetailsCommand;
import com.ttcs.web.command.society.CustomerDetailsCommand;
import com.ttcs.web.command.society.ExistingCustomerCommand;
import com.ttcs.web.command.society.GenSavingsDetailsCommand;
import com.ttcs.web.command.society.HandLoanDetailsCommand;
import com.ttcs.web.command.society.PersonalLoanDetailsCommand;
import com.ttcs.web.controller.AbstractTtcsCommandController;



// TODO: Auto-generated Javadoc
/**
 * The Class PrintManagementController.
 */
@SuppressWarnings("unchecked")
public class ExistingCustomerCommandController extends AbstractTtcsCommandController {
 	
	 

	public ModelAndView handleInit(HttpServletRequest request,
			HttpServletResponse response, Object inputCommand, BindException be)
			throws Throwable {
		ExistingCustomerCommand existingCustomerCommand = (ExistingCustomerCommand) inputCommand;
		
		
		
		return  doNormal(existingCustomerCommand, request, be, response);
		
		
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
			ExistingCustomerCommand existingCustomerCommand,
			HttpServletRequest req, BindException be, HttpServletResponse response) throws TtcsException,  InvocationTargetException, Throwable  {
		ModelAndView modelAndView = null;
		
		String custId = null;
		
		if(req.getParameter("customer") !=null){
			
			req.getSession().setAttribute("customerDetailsCommand", null);
		}else if(StringUtils.isNotEmpty(existingCustomerCommand.getCustId()))
		{
			custId = existingCustomerCommand.getCustId();
		}else if(req.getSession().getAttribute("customerDetailsCommand") !=null)
		{
			CustomerDetailsCommand customerDetailsCommand =(CustomerDetailsCommand)req.getSession().getAttribute("customerDetailsCommand");
			//custId = customerDetailsCommand.getCustId();
		}
		
		if(StringUtils.isEmpty(custId))
		{
			modelAndView = new ModelAndView(this.getInputFormView());
			modelAndView.addObject("existingCustomerCommand",	existingCustomerCommand);
		}else
		{
			CustomerAccountDetailsCommand  customerAccountDetailsCommand = new CustomerAccountDetailsCommand();
			
			/*
			 * Get Customer details and save in session
			 */
			
			CustomerDetailsServiceBean customerServiceBean = new CustomerDetailsServiceBean();
			
			try {
				
				//customerServiceBean.setCustId(custId);
				customerServiceBean.setFunction("R");
				
				customerServiceBean = (CustomerDetailsServiceBean) getCommandExecutor().execute(customerServiceBean);
				
				CustomerDetailsCommand customerDetailsCommand = new CustomerDetailsCommand();
				
				PropertyUtils.copyProperties(customerDetailsCommand, customerServiceBean);
				
				req.getSession().setAttribute("customerDetailsCommand", customerDetailsCommand);
				
				
				customerAccountDetailsCommand.setCustomerDetailsCommand(customerDetailsCommand);
				
				/*
				 * Get Saving Account Details
				 */
				GenSavingsDetailsServiceBean genSavingsDetailsServiceBean = new GenSavingsDetailsServiceBean();
				//genSavingsDetailsServiceBean.setCustId(customerDetailsCommand.getCustId());
				genSavingsDetailsServiceBean.setFunction("R");		
				
				genSavingsDetailsServiceBean = (GenSavingsDetailsServiceBean) getCommandExecutor().execute(genSavingsDetailsServiceBean);
				
				GenSavingsDetailsCommand genSavingsDetailsCommand = new GenSavingsDetailsCommand();
				
				PropertyUtils.copyProperties(genSavingsDetailsCommand, genSavingsDetailsServiceBean);
				
				customerAccountDetailsCommand.setGenSavingsDetailsCommand(genSavingsDetailsCommand);
				
				/*
				 * Get Personal Account Details
				 */
				PersonalLoanDetailsServiceBean personalLoanDetailsServiceBean = new PersonalLoanDetailsServiceBean();		
				//personalLoanDetailsServiceBean.setCustId(customerDetailsCommand.getCustId());
				personalLoanDetailsServiceBean.setFunction("R");		
				
				personalLoanDetailsServiceBean = (PersonalLoanDetailsServiceBean) getCommandExecutor().execute(personalLoanDetailsServiceBean);
				
				PersonalLoanDetailsCommand personalLoanDetailsCommand = new PersonalLoanDetailsCommand();
				
				PropertyUtils.copyProperties(personalLoanDetailsCommand, personalLoanDetailsServiceBean);
				
				
				
				customerAccountDetailsCommand.setPersonalLoanDetailsCommand(personalLoanDetailsCommand);
				
				/*
				 * Get Hand Account Details
				 */
				HandLoanDetailsServiceBean handLoanDetailsServiceBean = new HandLoanDetailsServiceBean();		
				//handLoanDetailsServiceBean.setCustId(customerDetailsCommand.getCustId());
				handLoanDetailsServiceBean.setFunction("R");		
				
				handLoanDetailsServiceBean = (HandLoanDetailsServiceBean) getCommandExecutor().execute(handLoanDetailsServiceBean);
				
				HandLoanDetailsCommand handLoanDetailsCommand = new HandLoanDetailsCommand();
				
				PropertyUtils.copyProperties(handLoanDetailsCommand, handLoanDetailsServiceBean);
				
				
				
				customerAccountDetailsCommand.setHandLoanDetailsCommand(handLoanDetailsCommand);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			modelAndView = new ModelAndView(this.getSuccessView());
			modelAndView.addObject("customerAccountDetailsCommand",	customerAccountDetailsCommand);
		}
		
		
		
		
		
		
		
		return modelAndView;
	}

	
	
	public ModelAndView handleValidForm(HttpServletRequest req,
			HttpServletResponse res, Object inputCommand, BindException be)
			throws Throwable {
		return handleInit(req, res, inputCommand, be);
	}
	

	
}
