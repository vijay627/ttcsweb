package com.ttcs.command.society;






import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.commons.CommandInterface;
import com.ttcs.commons.pojo.Bean;
import com.ttcs.commons.pojo.society.CustomerDetailsServiceBean;
import com.ttcs.constants.TtcsConstants;
import com.ttcs.dao.entities.CustomerDetails;
import com.ttcs.dao.society.CustomerDetailsDao;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerDetailsServiceCommand implements CommandInterface {

	private static final Logger log = Logger.getLogger(CustomerDetailsServiceCommand.class);
	
	private CustomerDetailsDao customerDetailsDao;
	
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Serializable execute(Bean data) throws Throwable {
		
		

		CustomerDetailsServiceBean bean = (CustomerDetailsServiceBean)data;
		
		String function = bean.getFunction();
		
		CustomerDetails customerDetails = new CustomerDetails();
		
		try {
			
			
			BeanUtils.copyProperties(bean,customerDetails);
			
			
			
			log.info("function :: "+function);
			
			if(TtcsConstants.FUNCTION_ADD.equals(function) || TtcsConstants.FUNCTION_UPDATE.equals(function))
			{
				customerDetails = (CustomerDetails)customerDetailsDao.saveCustomerDetails(customerDetails);
				
			}else if(TtcsConstants.FUNCTION_DELETE.equals(function))
			{
				customerDetailsDao.deleteCustomerDetails(customerDetails);
				
			}else if(TtcsConstants.FUNCTION_INQUIRY.equals(function) )
			{
				
				List<CustomerDetails> result= (List<CustomerDetails>)customerDetailsDao.readCustomerDetails(bean.getCustId());
				
				if(result !=null && result.size()>0)
				{
					customerDetails = result.get(0);
					
					BeanUtils.copyProperties(customerDetails, bean);
					
				}else
				{
					bean = new CustomerDetailsServiceBean();
				}
				
			}
	
			
		}catch (Exception e) {
			e.printStackTrace();
			bean.setErrorMessage("Internal Server Error Occurred "+e.getMessage());
		}
		return bean;
		
		
	}
	public CustomerDetailsDao getCustomerDetailsDao() {
		return customerDetailsDao;
	}
	public void setCustomerDetailsDao(CustomerDetailsDao customerDetailsDao) {
		this.customerDetailsDao = customerDetailsDao;
	}

	

	
	

	
}
