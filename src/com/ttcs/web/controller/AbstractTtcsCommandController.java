package com.ttcs.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.ttcs.commons.CommandExecutorInterface;
import com.ttcs.commons.exception.TtcsFunctionalException;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractTtcsCommandController.
 * 
 * @author id814929
 */
public abstract class AbstractTtcsCommandController extends AbstractCommandController {

	/** The input form view. */
	private String inputFormView=null;
	
	/** The system error view. */
	private String systemErrorView=new String("GenericSystemErrorView");
	
	/** The success view. */
	private String successView=null;
	
	/** these parameters are used to retrieve the retrieveKey parameter name and to match it to the retrieveValue if request.getParameter(this.retrieveKey).equals(this.retrieveValue) is true, the default handle will invoke handleInit to provide to the client the input form page */
	private String retrieveKey=new String("do");
	
	/** The retrieve value. */
	private String retrieveValue=new String("start");
	
	/** The functional exception label. */
	private String functionalExceptionLabel=new String("genException");
	
	/** The system exception label. */
	private String systemExceptionLabel=new String("exception");
	
	
	/** The command executor. */
	private CommandExecutorInterface commandExecutor;

	
	/** The Constant log. */
	private static final Logger log = Logger.getLogger(AbstractTtcsCommandController.class);
	
	/**
	 * This controller defines how the normal and exception flow are managed. It processes both the input form request and the form post-processing basing on the do=start http parameter
	 */
	public AbstractTtcsCommandController() {
	}

	/**
	 * The Constructor.
	 * 
	 * @param commandClass the command class
	 */
	public AbstractTtcsCommandController(Class commandClass) {
		super(commandClass);
	}

	/**
	 * The Constructor.
	 * 
	 * @param commandClass the command class
	 * @param commandName the command name
	 */
	public AbstractTtcsCommandController(Class commandClass, String commandName) {
		super(commandClass, commandName);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractCommandController#handle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
	protected final ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object inputCommand, BindException be) throws Exception {
		AbstractTtcsCommandController.log.debug("start");
		AbstractTtcsCommandController.log.info("controller handle routine invoked");
		AbstractTtcsCommandController.log.debug("querystring=" + req.getQueryString());
		
		
		ModelAndView modelAndView;

		try {
			AbstractTtcsCommandController.log.debug("verifying bindresult");
			AbstractTtcsCommandController.log.debug("bindresult errorCount == " + be.getErrorCount());
			AbstractTtcsCommandController.log.debug("bindresult message == " + be.getMessage());
			
			
			
			final String retrievedKey = this.getRetrieveKey();
			final String retrievedValue = this.getRetrieveValue();
			
			//System.out.println("retrievedKey "+retrievedKey);
			//System.out.println("be.getErrorCount() "+be.getErrorCount());
			
			if (retrievedValue.equals(req.getParameter(retrievedKey))) {
				AbstractTtcsCommandController.log.info("performing start flow");
				modelAndView = this.handleInit(req, res, inputCommand, be);
			}
			else if (be.getErrorCount()==0) {
				AbstractTtcsCommandController.log.info("performing normal flow");
				AbstractTtcsCommandController.log.debug("input bean successfully bound and validated");
				modelAndView = this.handleValidForm(req, res, inputCommand, be);
				
			} else {
				AbstractTtcsCommandController.log.info("performing exception flow");
				AbstractTtcsCommandController.log.debug("bindresult = " + be);
				AbstractTtcsCommandController.log.debug("bindresult exception detected. Forwarding to " + this.getInputFormView() + " NORMAL_FLOW page");
				modelAndView = this.handleError(req, res, inputCommand, be);
			}
		} catch (Throwable e) {
			AbstractTtcsCommandController.log.error("an exception was caught. Performing doError routine", e);
			modelAndView=this.handleError(req, res, inputCommand, e instanceof Exception? e : new Exception(e));
		}
		
		AbstractTtcsCommandController.log.debug("end");
		return modelAndView;

	}

	
    /**
     * Handles the errors thrown.
     * 
     * @param req the req
     * @param res the res
     * @param bean the bean
     * @param exception the exception
     * 
     * @return the model and view
     */
	public final ModelAndView handleError(HttpServletRequest req, HttpServletResponse res, Object bean, Throwable exception) {
		AbstractTtcsCommandController.log.debug("handleError() start");
		ModelAndView modelAndView=null;
		
		AbstractTtcsCommandController.log.debug("Checking the exception type");
		if(exception instanceof BindException) {
			BindException be=(BindException)exception ;
			//System.out.println("Error :: "+be.getMessage());
			AbstractTtcsCommandController.log.error(be.getMessage(), be);
			AbstractTtcsCommandController.log.debug("BindException detected. Forwarding to " + this.getInputFormView() + " NORMAL_FLOW page");
			modelAndView = new ModelAndView(this.getInputFormView(), be.getModel());
			AbstractTtcsCommandController.log.debug("new object added to model map: " + modelAndView.getModelMap());
		}
		else if(exception instanceof TtcsFunctionalException) {
			AbstractTtcsCommandController.log.debug("TtcsFunctionalException detected. Forwarding to " + this.getInputFormView() + " NORMAL_FLOW page");
			modelAndView = new ModelAndView(this.getInputFormView());
			
			AbstractTtcsCommandController.log.debug("Adding " + this.getFunctionalExceptionLabel() + " to " + this.getInputFormView() + " NORMAL_FLOW page");
			modelAndView.getModelMap().addAttribute(this.getFunctionalExceptionLabel(), exception);
			
			if(bean!=null) {
				AbstractTtcsCommandController.log.debug("Adding " + this.getCommandName() + " to " + this.getInputFormView() + " NORMAL_FLOW page");
				modelAndView.getModelMap().addAttribute(this.getCommandName(), bean);
			}
			
			AbstractTtcsCommandController.log.debug("new object added to model map: " + modelAndView.getModelMap());
		}
		
		AbstractTtcsCommandController.log.debug("end");		
		return modelAndView;

	}

	
	
	/**
	 * Handles the input form submit and performs server side operations.
	 * 
	 * @param req the req
	 * @param res the res
	 * @param inputCommand the input command
	 * @param be the be
	 * 
	 * @return the model and view
	 * 
	 * @throws Throwable the throwable
	 */
	public abstract ModelAndView handleValidForm(HttpServletRequest req, HttpServletResponse res, Object inputCommand, BindException be) throws Throwable;

	/**
	 * Returns the input form to the client.
	 * 
	 * @param req the req
	 * @param res the res
	 * @param inputCommand the input command
	 * @param be the be
	 * 
	 * @return the model and view
	 * 
	 * @throws Throwable the throwable
	 */
	public abstract ModelAndView handleInit(HttpServletRequest req, HttpServletResponse res, Object inputCommand, BindException be) throws Throwable;
	
	/**
	 * Gets the input form view.
	 * 
	 * @return the inputFormView
	 */
	public String getInputFormView() {
		return inputFormView;
	}

	/**
	 * Sets the input form view.
	 * 
	 * @param inputFormView the inputFormView to set
	 */
	@Required
	public void setInputFormView(String inputFormView) {
		this.inputFormView = inputFormView;
	}

	/**
	 * Gets the system error view.
	 * 
	 * @return the systemErrorView
	 */
	public String getSystemErrorView() {
		return systemErrorView;
	}

	/**
	 * Sets the system error view.
	 * 
	 * @param systemErrorView the systemErrorView to set
	 */
	public void setSystemErrorView(String systemErrorView) {
		this.systemErrorView = systemErrorView;
	}

	/**
	 * Gets the success view.
	 * 
	 * @return the successView
	 */
	public String getSuccessView() {
		return successView;
	}

	/**
	 * Sets the success view.
	 * 
	 * @param successView the successView to set
	 */
	@Required
	public void setSuccessView(String successView) {
		this.successView = successView;
	}

	/**
	 * Gets the retrieve key.
	 * 
	 * @return the retrieveKey
	 */
	public String getRetrieveKey() {
		return retrieveKey;
	}

	/**
	 * Sets the retrieve key.
	 * 
	 * @param retrieveKey the retrieveKey to set
	 */
	public void setRetrieveKey(String retrieveKey) {
		this.retrieveKey = retrieveKey;
	}

	/**
	 * Gets the retrieve value.
	 * 
	 * @return the retrieveValue
	 */
	public String getRetrieveValue() {
		return retrieveValue;
	}

	/**
	 * Sets the retrieve value.
	 * 
	 * @param retrieveValue the retrieveValue to set
	 */
	public void setRetrieveValue(String retrieveValue) {
		this.retrieveValue = retrieveValue;
	}

	/**
	 * Gets the functional exception label.
	 * 
	 * @return the functionalExceptionLabel
	 */
	public String getFunctionalExceptionLabel() {
		return functionalExceptionLabel;
	}

	/**
	 * Sets the functional exception label.
	 * 
	 * @param functionalExceptionLabel the functionalExceptionLabel to set
	 */
	public void setFunctionalExceptionLabel(String functionalExceptionLabel) {
		this.functionalExceptionLabel = functionalExceptionLabel;
	}

	/**
	 * Gets the system exception label.
	 * 
	 * @return the systemExceptionLabel
	 */
	public String getSystemExceptionLabel() {
		return systemExceptionLabel;
	}

	/**
	 * Sets the system exception label.
	 * 
	 * @param systemExceptionLabel the systemExceptionLabel to set
	 */
	public void setSystemExceptionLabel(String systemExceptionLabel) {
		this.systemExceptionLabel = systemExceptionLabel;
	}

	/**
	 * Gets the command executor.
	 * 
	 * @return the commandExecutor
	 */
	public CommandExecutorInterface getCommandExecutor() {
		return commandExecutor;
	}

	/**
	 * Sets the command executor.
	 * 
	 * @param commandExecutor the commandExecutor to set
	 */
	public void setCommandExecutor(CommandExecutorInterface commandExecutor) {
		this.commandExecutor = commandExecutor;
	}

	
	
}
