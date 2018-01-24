package com.ttcs.command.society;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.commons.CommandInterface;
import com.ttcs.commons.pojo.Bean;
import com.ttcs.commons.pojo.society.UserDetailsServiceBean;
import com.ttcs.constants.TtcsConstants;
import com.ttcs.dao.entities.UserDetails;
import com.ttcs.dao.society.UserDetailsDao;



@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserDetailsServiceCommand implements CommandInterface {

	private static final Logger log = Logger.getLogger(UserDetailsServiceCommand.class);
	
	private UserDetailsDao userDetailsDao;
	
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Serializable execute(Bean data) throws Throwable {
		
		
		
		UserDetailsServiceBean bean = (UserDetailsServiceBean)data;
		
		String function = bean.getFunction();
		
		UserDetails userDetails = new UserDetails();
		
		try {
			
			BeanUtils.copyProperties(bean,userDetails);
			
			
			log.info("function :: "+function);
			
			if(TtcsConstants.FUNCTION_ADD.equals(function) || TtcsConstants.FUNCTION_UPDATE.equals(function))
			{
				userDetails = (UserDetails)userDetailsDao.saveUserDetails(userDetails);
				
			}else if(TtcsConstants.FUNCTION_DELETE.equals(function))
			{
				userDetailsDao.deleteUserDetails(userDetails);
				
			}else if(TtcsConstants.FUNCTION_INQUIRY.equals(function) || TtcsConstants.FUNCTION_LOGIN.equals(function))
			{
				
				List<UserDetails> result= (List<UserDetails>)userDetailsDao.readUserDetails(bean.getUserId());
				
				if(result !=null && result.size()>0)
				{
					userDetails = result.get(0);
					
					BeanUtils.copyProperties(userDetails, bean);
					
				}else
				{
					bean = new UserDetailsServiceBean();
				}
				
			}
	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}


	public UserDetailsDao getUserDetailsDao() {
		return userDetailsDao;
	}


	public void setUserDetailsDao(UserDetailsDao userDetailsDao) {
		this.userDetailsDao = userDetailsDao;
	}

	

	
	

	
}
