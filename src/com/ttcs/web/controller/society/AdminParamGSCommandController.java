package com.ttcs.web.controller.society;


import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.ttcs.commons.exception.TtcsException;
import com.ttcs.commons.pojo.society.AdminParamGSServiceBean;
import com.ttcs.web.command.society.AdminParamGSCommand;
import com.ttcs.web.controller.AbstractTtcsCommandController;



// TODO: Auto-generated Javadoc
/**
 * The Class PrintManagementController.
 */
@SuppressWarnings("unchecked")
public class AdminParamGSCommandController extends AbstractTtcsCommandController {
 	
	 

	public ModelAndView handleInit(HttpServletRequest request,
			HttpServletResponse response, Object inputCommand, BindException be)
			throws Throwable {
		AdminParamGSCommand adminParamGSCommand = (AdminParamGSCommand) inputCommand;
		
		
		
		return  doNormal(adminParamGSCommand, request, be, response);
		
		
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
			AdminParamGSCommand adminParamGSDetailsCommand,
			HttpServletRequest req, BindException be, HttpServletResponse response) throws TtcsException,  InvocationTargetException, Throwable  {
		ModelAndView modelAndView = null;
		
		System.out.println("View Name "+this.getInputFormView());
		modelAndView = new ModelAndView(this.getInputFormView());
		
		String strBtnPressed = (String)req.getParameter("btnPressed");
		
		try {
			if(StringUtils.isNotEmpty(strBtnPressed) )
			{
					AdminParamGSServiceBean adminParamGSServiceBean = new AdminParamGSServiceBean();
				
				
					PropertyUtils.copyProperties(adminParamGSServiceBean, adminParamGSDetailsCommand);
					adminParamGSServiceBean.setFunction("A");
					
					adminParamGSServiceBean = (AdminParamGSServiceBean) getCommandExecutor().execute(adminParamGSServiceBean);
					
					PropertyUtils.copyProperties(adminParamGSDetailsCommand, adminParamGSServiceBean);
					
					String successMsg = "Admin personal loan details have been successfully updated";
					String nextPage  = "existingCustomer.spr";
					
					req.setAttribute("successMsg", successMsg);
					req.setAttribute("nextPage", nextPage);
				
			}else
			{
				AdminParamGSServiceBean adminParamGSServiceBean = new AdminParamGSServiceBean();
				
				
				PropertyUtils.copyProperties(adminParamGSServiceBean, adminParamGSDetailsCommand);
				adminParamGSServiceBean.setFunction("R");
				
				adminParamGSServiceBean = (AdminParamGSServiceBean) getCommandExecutor().execute(adminParamGSServiceBean);
				
				PropertyUtils.copyProperties(adminParamGSDetailsCommand, adminParamGSServiceBean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		modelAndView.addObject("adminParamGSCommand",	adminParamGSDetailsCommand);	
		
		
		return modelAndView;
	}

	
	
	public ModelAndView handleValidForm(HttpServletRequest req,
			HttpServletResponse res, Object inputCommand, BindException be)
			throws Throwable {
		return handleInit(req, res, inputCommand, be);
	}
	

	
}
