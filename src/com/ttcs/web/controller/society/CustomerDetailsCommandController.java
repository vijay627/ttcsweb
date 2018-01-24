package com.ttcs.web.controller.society;


import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Blob;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.ttcs.commons.exception.TtcsException;
import com.ttcs.commons.pojo.society.CustomerDetailsServiceBean;
import com.ttcs.constants.TtcsConstants;
import com.ttcs.web.command.society.CustomerDetailsCommand;
import com.ttcs.web.controller.AbstractTtcsCommandController;




/**
 * The Class CustomerDetailsCommandController.
 */

public class CustomerDetailsCommandController extends AbstractTtcsCommandController {
 	
	private static final Logger log = Logger.getLogger(CustomerDetailsCommandController.class);

	@Override
	public ModelAndView handleInit(HttpServletRequest request,
			HttpServletResponse response, Object inputCommand, BindException be)
			throws Throwable {
		CustomerDetailsCommand customerDetailsCommand = (CustomerDetailsCommand) inputCommand;
		
		return  doNormal(customerDetailsCommand, request, be, response);
		
		
	}
	
	
	/**
	 * Do normal.
	 * 
	 * @param customerDetailsCommand 
	 * @param req the req
	 * @param be the be
	 * @param response the response
	 * 
	 * @return the model and view
	 * 
	 */
	
	private ModelAndView doNormal(
			CustomerDetailsCommand customerDetailsCommand,
			HttpServletRequest req, BindException be, HttpServletResponse response) throws TtcsException,  InvocationTargetException, Throwable  {
		
		ModelAndView modelAndView = null;
		
		modelAndView = new ModelAndView(this.getSuccessView());
		modelAndView.addObject("customerDetailsCommand",customerDetailsCommand);
		
		String function = customerDetailsCommand.getFunction();
		
		CustomerDetailsServiceBean customerDetailsServiceBean = new CustomerDetailsServiceBean();
		
		try 
		{
			
			BeanUtils.copyProperties(customerDetailsCommand,customerDetailsServiceBean, new String[]{"custPhoto","custSign"});
			
			if(TtcsConstants.FUNCTION_ADD.equals(function))
			{
				Blob custPhoto = Hibernate.createBlob(customerDetailsCommand.getCustPhoto().getInputStream());
				Blob custSign = Hibernate.createBlob(customerDetailsCommand.getCustSign().getInputStream());
				
				customerDetailsServiceBean.setCustPhoto(custPhoto);
				customerDetailsServiceBean.setCustSign(custSign);
			}
			
			customerDetailsServiceBean = (CustomerDetailsServiceBean) getCommandExecutor().execute(customerDetailsServiceBean);
			
			
		} catch (Exception e) 
		{
			customerDetailsCommand.setErrorMessage("Internal Server Error Occurred "+e.getMessage());
		}
		
		
		modelAndView.addObject("customerDetailsCommand",customerDetailsCommand);
		
		if(!StringUtils.isNullOrEmpty(customerDetailsCommand.getErrorMessage()) || !StringUtils.isNullOrEmpty(customerDetailsServiceBean.getErrorMessage()))
		{
			modelAndView = new ModelAndView(this.getInputFormView());
			modelAndView.addObject("customerDetailsCommand",customerDetailsCommand);
			return  modelAndView;
			
		}else
		{
			BeanUtils.copyProperties(customerDetailsServiceBean,customerDetailsCommand, new String[]{"custPhoto","custSign"});
			
			if(TtcsConstants.FUNCTION_INQUIRY.equals(function))
			{
				
				Blob blob = null;
				byte[] byteArray;
				
				blob = (Blob)(customerDetailsServiceBean.getCustPhoto());
				byteArray = blob.getBytes(1,(int)blob.length());  
				String path = req.getServletContext().getRealPath("")+"\\cust\\"+customerDetailsCommand.getCustId()+".jpg";
				OutputStream pout=new FileOutputStream(path);
				pout.write(byteArray);
				pout.close();
				
				blob = (Blob)(customerDetailsServiceBean.getCustSign());
				byteArray = blob.getBytes(1,(int)blob.length());  
				String signPath = req.getServletContext().getRealPath("")+"\\sign\\"+customerDetailsCommand.getCustId()+".jpg";
				OutputStream sout=new FileOutputStream(signPath);
				sout.write(byteArray);
				sout.close();
				
			}
			
			
			
			modelAndView.addObject("customerDetailsCommand",customerDetailsCommand);
			req.setAttribute("successMsg", "The details for <b>Customer Id "+customerDetailsCommand.getCustId()+"</b> has been successfully "+function.toLowerCase()+"ed");
			req.setAttribute("nextPage", "customerCriteria.jsp");
		}
		
		
		return modelAndView;
	}

	
	
	public ModelAndView handleValidForm(HttpServletRequest req,
			HttpServletResponse res, Object inputCommand, BindException be)
			throws Throwable 
	{
		
		String pageType = req.getParameter("pageType");
		log.info("pageType :: "+pageType);
		
		if(!StringUtils.isNullOrEmpty(pageType) && TtcsConstants.PAGE_DET.equalsIgnoreCase(pageType))
		{
			this.setInputFormView("customerDetails");
			this.setSuccessView("reusult");
		}else
		{
			this.setInputFormView("customerCriteria");
			this.setSuccessView("customerDetails");
		}
		
		CustomerDetailsCommand customerDetailsCommand = (CustomerDetailsCommand) inputCommand;
		String function = customerDetailsCommand.getFunction();
		log.info("success view :: "+this.getSuccessView());
		log.info("success view :: "+customerDetailsCommand.getFirstName());
		
		if(TtcsConstants.PAGE_CRIT.equalsIgnoreCase(pageType) && TtcsConstants.FUNCTION_ADD.equalsIgnoreCase(function))
		{
			
			ModelAndView modelAndView = new ModelAndView(this.getSuccessView());
			modelAndView.addObject("customerDetailsCommand",	customerDetailsCommand);
			return  modelAndView;
		}
		
		
		return  doNormal(customerDetailsCommand, req, be, res);
	}
	
	

	
}
