package com.ttcs.web.controller.society;


import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.ttcs.commons.exception.TtcsException;
import com.ttcs.commons.pojo.society.GenSavingsDetailsServiceBean;
import com.ttcs.commons.pojo.society.PersonalLoanDetailsServiceBean;
import com.ttcs.web.command.society.CustomerAccountDetailsCommand;
import com.ttcs.web.command.society.CustomerDetailsCommand;
import com.ttcs.web.command.society.GenSavingsDetailsCommand;
import com.ttcs.web.command.society.PersonalLoanDetailsCommand;
import com.ttcs.web.controller.AbstractTtcsCommandController;



// TODO: Auto-generated Javadoc
/**
 * The Class PrintManagementController.
 */
@SuppressWarnings("unchecked")
public class CustomerAccountDetailsCommandController extends AbstractTtcsCommandController {
 	
	 

	public ModelAndView handleInit(HttpServletRequest request,
			HttpServletResponse response, Object inputCommand, BindException be)
			throws Throwable {
		CustomerAccountDetailsCommand customerAccountDetailsCommand = (CustomerAccountDetailsCommand) inputCommand;
		
		System.out.println("Hitting User  controller");
		
		return  doNormal(customerAccountDetailsCommand, request, be, response);
		
		
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
			CustomerAccountDetailsCommand customerAccountDetailsCommand,
			HttpServletRequest req, BindException be, HttpServletResponse response) throws TtcsException,  InvocationTargetException, Throwable  {
		ModelAndView modelAndView = null;
		
		try
		{
		
		System.out.println("Hitting account details");
			/*
			 * GetCustomer Details
			 */
			
			CustomerDetailsCommand customerDetailsCommand = (CustomerDetailsCommand)req.getSession().getAttribute("customerDetailsCommand");
			
			customerAccountDetailsCommand.setCustomerDetailsCommand(customerDetailsCommand);
			
			/*
			 * Get Saving Account Details
			 */
			GenSavingsDetailsServiceBean genSavingsDetailsServiceBean = new GenSavingsDetailsServiceBean();		
			genSavingsDetailsServiceBean.setFunction("R");		
			
			genSavingsDetailsServiceBean = (GenSavingsDetailsServiceBean) getCommandExecutor().execute(genSavingsDetailsServiceBean);
			
			GenSavingsDetailsCommand genSavingsDetailsCommand = new GenSavingsDetailsCommand();
			
			PropertyUtils.copyProperties(genSavingsDetailsCommand, genSavingsDetailsServiceBean);
			
			customerAccountDetailsCommand.setGenSavingsDetailsCommand(genSavingsDetailsCommand);
			
			/*
			 * Get Personal Account Details
			 */
			PersonalLoanDetailsServiceBean personalLoanDetailsServiceBean = new PersonalLoanDetailsServiceBean();		
			personalLoanDetailsServiceBean.setFunction("R");		
			
			personalLoanDetailsServiceBean = (PersonalLoanDetailsServiceBean) getCommandExecutor().execute(personalLoanDetailsServiceBean);
			
			PersonalLoanDetailsCommand personalLoanDetailsCommand = new PersonalLoanDetailsCommand();
			
			PropertyUtils.copyProperties(personalLoanDetailsCommand, personalLoanDetailsServiceBean);
			
			
			
			customerAccountDetailsCommand.setPersonalLoanDetailsCommand(personalLoanDetailsCommand);
			
			modelAndView = new ModelAndView(this.getInputFormView());
			modelAndView.addObject("customerAccountDetailsCommand",	customerAccountDetailsCommand);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return modelAndView;
	}

	
	
	public ModelAndView handleValidForm(HttpServletRequest req,
			HttpServletResponse res, Object inputCommand, BindException be)
			throws Throwable {
		return handleInit(req, res, inputCommand, be);
	}
	

	
}
