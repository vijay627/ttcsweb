package com.ttcs.web.controller.society;


import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.ttcs.commons.exception.TtcsException;
import com.ttcs.commons.pojo.society.UserDetailsServiceBean;
import com.ttcs.constants.TtcsConstants;
import com.ttcs.web.command.society.UserDetailsCommand;
import com.ttcs.web.controller.AbstractTtcsCommandController;




/**
 * The Class UserDetailsCommandController.
 */

public class UserDetailsCommandController extends AbstractTtcsCommandController {
 	
	private static final Logger log = Logger.getLogger(UserDetailsCommandController.class);

	public ModelAndView handleInit(HttpServletRequest request,
			HttpServletResponse response, Object inputCommand, BindException be)
			throws Throwable {
		UserDetailsCommand userDetailsCommand = (UserDetailsCommand) inputCommand;
		
		return  doNormal(userDetailsCommand, request, be, response);
		
		
	}
	
	
	/**
	 * Do normal.
	 * 
	 * @param userDetailsCommand 
	 * @param req the req
	 * @param drawing the drawing
	 * @param be the be
	 * @param response the response
	 * 
	 * @return the model and view
	 * 
	 */
	private ModelAndView doNormal(
			UserDetailsCommand userDetailsCommand,
			HttpServletRequest req, BindException be, HttpServletResponse response) throws TtcsException,  InvocationTargetException, Throwable  {
		
		ModelAndView modelAndView = null;
		
		modelAndView = new ModelAndView(this.getSuccessView());
		
		UserDetailsServiceBean userDetailsServiceBean = new UserDetailsServiceBean();
		
		try 
		{
			
			PropertyUtils.copyProperties(userDetailsServiceBean, userDetailsCommand);
			
			userDetailsServiceBean = (UserDetailsServiceBean) getCommandExecutor().execute(userDetailsServiceBean);
			
			if(TtcsConstants.FUNCTION_LOGIN.equals(userDetailsCommand.getFunction()) &&
					!validateUserCredentials(userDetailsCommand,userDetailsServiceBean))
			{
				userDetailsCommand.setErrorMessage("The user id or password is incorrect.");
			}
			
		} catch (Exception e) 
		{
			userDetailsCommand.setErrorMessage("Internal Server Error Occurred "+e.getMessage());
		}
		
		
		modelAndView.addObject("userDetailsCommand",userDetailsCommand);
		
		if(!StringUtils.isNullOrEmpty(userDetailsCommand.getErrorMessage()))
		{
			modelAndView = new ModelAndView(this.getInputFormView());
			modelAndView.addObject("userDetailsCommand",userDetailsCommand);
			return  modelAndView;
			
		}else
		{
			PropertyUtils.copyProperties(userDetailsCommand,userDetailsServiceBean);
			req.getSession().setAttribute(TtcsConstants.USER_DETAILS, userDetailsCommand);
		}
		
		
		return modelAndView;
	}

	
	
	public ModelAndView handleValidForm(HttpServletRequest req,
			HttpServletResponse res, Object inputCommand, BindException be)
			throws Throwable 
	{
		UserDetailsCommand userDetailsCommand = (UserDetailsCommand) inputCommand;
		
		log.info("Function :: "+ userDetailsCommand.getFunction());
		
		if(TtcsConstants.FUNCTION_LOGIN.equals(userDetailsCommand.getFunction()))
		{
			if(StringUtils.isNullOrEmpty(userDetailsCommand.getUserId()) )
			{
				userDetailsCommand.setErrorMessage("User Id should not be blank");
			}else if(StringUtils.isNullOrEmpty(userDetailsCommand.getUserPassword()))
			{
				userDetailsCommand.setErrorMessage("Password should not be blank");
			}
		}
		
		
		
		if(!StringUtils.isNullOrEmpty(userDetailsCommand.getErrorMessage()))
		{
			ModelAndView modelAndView = new ModelAndView(this.getInputFormView());
			modelAndView.addObject("userDetailsCommand",	userDetailsCommand);
			return  modelAndView;
		}
		
		
		return handleInit(req, res, userDetailsCommand, be);
	}
	
	
	private boolean validateUserCredentials(UserDetailsCommand userDetailsCommand, UserDetailsServiceBean userDetailsServiceBean)
	{
		
		boolean validUser = false;
		
		try 
		{
			if(userDetailsCommand.getUserId().equals(userDetailsServiceBean.getUserId()) &&
					userDetailsCommand.getUserPassword().equals(userDetailsServiceBean.getUserPassword()))
			{
				validUser = true;
			}
		} catch (Exception e) {
			validUser = false;
		}
		
		log.info("validUser :: "+ validUser);
		return validUser;
	}

	
}
