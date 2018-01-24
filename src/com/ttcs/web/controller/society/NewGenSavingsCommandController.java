package com.ttcs.web.controller.society;


import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.ttcs.commons.exception.TtcsException;
import com.ttcs.commons.pojo.society.AdminParamGSServiceBean;
import com.ttcs.commons.pojo.society.GenSavingsDetailsServiceBean;
import com.ttcs.web.command.society.CustomerDetailsCommand;
import com.ttcs.web.command.society.ExistingCustomerCommand;
import com.ttcs.web.command.society.GenSavingsDetailsCommand;
import com.ttcs.web.controller.AbstractTtcsCommandController;



// TODO: Auto-generated Javadoc
/**
 * The Class PrintManagementController.
 */
@SuppressWarnings("unchecked")
public class NewGenSavingsCommandController extends AbstractTtcsCommandController {
 	
	 

	public ModelAndView handleInit(HttpServletRequest request,
			HttpServletResponse response, Object inputCommand, BindException be)
			throws Throwable {
		GenSavingsDetailsCommand genSavingsDetailsCommand = (GenSavingsDetailsCommand) inputCommand;
		
		
		
		return  doNormal(genSavingsDetailsCommand, request, be, response);
		
		
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
			GenSavingsDetailsCommand genSavingsDetailsCommand,
			HttpServletRequest req, BindException be, HttpServletResponse response) throws TtcsException,  InvocationTargetException, Throwable  {
		ModelAndView modelAndView = null;
		
		
		modelAndView = new ModelAndView(this.getInputFormView());
		
		String strBtnPressed = (String)req.getParameter("btnPressed");
		
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
					GenSavingsDetailsServiceBean newGenSavingsServiceBean = new GenSavingsDetailsServiceBean();
					
					
						PropertyUtils.copyProperties(newGenSavingsServiceBean, genSavingsDetailsCommand);
						newGenSavingsServiceBean.setFunction("A");
						
						newGenSavingsServiceBean = (GenSavingsDetailsServiceBean) getCommandExecutor().execute(newGenSavingsServiceBean);
						
						PropertyUtils.copyProperties(genSavingsDetailsCommand, newGenSavingsServiceBean);
					
				}else
				{
					
					AdminParamGSServiceBean adminParamGSServiceBean = new AdminParamGSServiceBean();
					
					adminParamGSServiceBean.setFunction("R");
					
					adminParamGSServiceBean = (AdminParamGSServiceBean) getCommandExecutor().execute(adminParamGSServiceBean);
					
					genSavingsDetailsCommand.setBalanceAmount((double)adminParamGSServiceBean.getMinimumDeposit());
					genSavingsDetailsCommand.setRateOfInterest(adminParamGSServiceBean.getRateOfInterest());
					genSavingsDetailsCommand.setFrequency(adminParamGSServiceBean.getFrequency());
					
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Date date = new Date();
					String currentDate = formatter.format(date);
					
					
			        
			        
			        
			        genSavingsDetailsCommand.setOpeningDate(currentDate);
			        genSavingsDetailsCommand.setSavingsAccountNumber("GS"+currentDate.replace("/", ""));
			        
			       
			        
					String custName = customerDetailsCommand.getFirstName();
					
					
					
					//genSavingsDetailsCommand.setCustId(customerDetailsCommand.getCustId());
					genSavingsDetailsCommand.setCustName(custName);
			        
			        
				}
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		modelAndView.addObject("genSavingsDetailsCommand",	genSavingsDetailsCommand);	
		
		
		return modelAndView;
	}

	
	
	public ModelAndView handleValidForm(HttpServletRequest req,
			HttpServletResponse res, Object inputCommand, BindException be)
			throws Throwable {
		return handleInit(req, res, inputCommand, be);
	}
	

	
}
