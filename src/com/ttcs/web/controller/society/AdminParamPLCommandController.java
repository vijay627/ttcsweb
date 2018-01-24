package com.ttcs.web.controller.society;


import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.ttcs.commons.exception.TtcsException;
import com.ttcs.commons.pojo.society.AdminParamPLServiceBean;
import com.ttcs.web.command.society.AdminParamPLCommand;
import com.ttcs.web.controller.AbstractTtcsCommandController;



// TODO: Auto-generated Javadoc
/**
 * The Class PrintManagementController.
 */
@SuppressWarnings("unchecked")
public class AdminParamPLCommandController extends AbstractTtcsCommandController {
 	
	 

	public ModelAndView handleInit(HttpServletRequest request,
			HttpServletResponse response, Object inputCommand, BindException be)
			throws Throwable {
		AdminParamPLCommand adminParamPLCommand = (AdminParamPLCommand) inputCommand;
		
		
		
		return  doNormal(adminParamPLCommand, request, be, response);
		
		
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
			AdminParamPLCommand adminParamPLDetailsCommand,
			HttpServletRequest req, BindException be, HttpServletResponse response) throws TtcsException,  InvocationTargetException, Throwable  {
		ModelAndView modelAndView = null;
		
		System.out.println("View Name "+this.getInputFormView());
		modelAndView = new ModelAndView(this.getInputFormView());
		
		String strBtnPressed = (String)req.getParameter("btnPressed");
		
		try {
			if(StringUtils.isNotEmpty(strBtnPressed) )
			{
					AdminParamPLServiceBean adminParamPLServiceBean = new AdminParamPLServiceBean();
				
				
					PropertyUtils.copyProperties(adminParamPLServiceBean, adminParamPLDetailsCommand);
					adminParamPLServiceBean.setFunction("A");
					
					adminParamPLServiceBean = (AdminParamPLServiceBean) getCommandExecutor().execute(adminParamPLServiceBean);
					
					PropertyUtils.copyProperties(adminParamPLDetailsCommand, adminParamPLServiceBean);
					
					String successMsg = "Admin personal loan details have been successfully updated";
					String nextPage  = "existingCustomer.spr";
					
					req.setAttribute("successMsg", successMsg);
					req.setAttribute("nextPage", nextPage);
				
			}else
			{
				AdminParamPLServiceBean adminParamPLServiceBean = new AdminParamPLServiceBean();
				
				
				PropertyUtils.copyProperties(adminParamPLServiceBean, adminParamPLDetailsCommand);
				adminParamPLServiceBean.setFunction("R");
				
				adminParamPLServiceBean = (AdminParamPLServiceBean) getCommandExecutor().execute(adminParamPLServiceBean);
				
				PropertyUtils.copyProperties(adminParamPLDetailsCommand, adminParamPLServiceBean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		modelAndView.addObject("adminParamPLCommand",	adminParamPLDetailsCommand);	
		
		
		return modelAndView;
	}

	
	
	public ModelAndView handleValidForm(HttpServletRequest req,
			HttpServletResponse res, Object inputCommand, BindException be)
			throws Throwable {
		return handleInit(req, res, inputCommand, be);
	}
	

	
}
