package com.ttcs.web.controller.society;


import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import com.ttcs.commons.exception.TtcsException;
import com.ttcs.commons.pojo.society.AdminParamHLServiceBean;
import com.ttcs.web.command.society.AdminParamHLCommand;
import com.ttcs.web.controller.AbstractTtcsCommandController;



// TODO: Auto-generated Javadoc
/**
 * The Class PrintManagementController.
 */
@SuppressWarnings("unchecked")
public class AdminParamHLCommandController extends AbstractTtcsCommandController {
 	
	 

	public ModelAndView handleInit(HttpServletRequest request,
			HttpServletResponse response, Object inputCommand, BindException be)
			throws Throwable {
		AdminParamHLCommand adminParamHLCommand = (AdminParamHLCommand) inputCommand;
		
		
		
		return  doNormal(adminParamHLCommand, request, be, response);
		
		
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
			AdminParamHLCommand adminParamHLDetailsCommand,
			HttpServletRequest req, BindException be, HttpServletResponse response) throws TtcsException,  InvocationTargetException, Throwable  {
		ModelAndView modelAndView = null;
		
		
		modelAndView = new ModelAndView(this.getInputFormView());
		
		String strBtnPressed = (String)req.getParameter("btnPressed");
		
		try {
			if(StringUtils.isNotEmpty(strBtnPressed) )
			{
					AdminParamHLServiceBean adminParamHLServiceBean = new AdminParamHLServiceBean();
				
				
					PropertyUtils.copyProperties(adminParamHLServiceBean, adminParamHLDetailsCommand);
					adminParamHLServiceBean.setFunction("A");
					
					adminParamHLServiceBean = (AdminParamHLServiceBean) getCommandExecutor().execute(adminParamHLServiceBean);
					
					PropertyUtils.copyProperties(adminParamHLDetailsCommand, adminParamHLServiceBean);
					
					String successMsg = "Admin personal loan details have been successfully updated";
					String nextPage  = "existingCustomer.spr";
					
					req.setAttribute("successMsg", successMsg);
					req.setAttribute("nextPage", nextPage);
				
			}else
			{
				AdminParamHLServiceBean adminParamHLServiceBean = new AdminParamHLServiceBean();
				
				
				PropertyUtils.copyProperties(adminParamHLServiceBean, adminParamHLDetailsCommand);
				adminParamHLServiceBean.setFunction("R");
				
				adminParamHLServiceBean = (AdminParamHLServiceBean) getCommandExecutor().execute(adminParamHLServiceBean);
				
				PropertyUtils.copyProperties(adminParamHLDetailsCommand, adminParamHLServiceBean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		modelAndView.addObject("adminParamHLCommand",	adminParamHLDetailsCommand);	
		
		
		return modelAndView;
	}

	
	
	public ModelAndView handleValidForm(HttpServletRequest req,
			HttpServletResponse res, Object inputCommand, BindException be)
			throws Throwable {
		return handleInit(req, res, inputCommand, be);
	}
	

	
}
