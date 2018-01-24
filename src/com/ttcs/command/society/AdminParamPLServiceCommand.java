package com.ttcs.command.society;






import java.io.Serializable;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.commons.CommandInterface;
import com.ttcs.commons.pojo.Bean;
import com.ttcs.commons.pojo.society.AdminParamPLServiceBean;
import com.ttcs.dao.entities.AdminParamPL;
import com.ttcs.dao.society.AdminParamPLDao;

// TODO: Auto-generated Javadoc
@SuppressWarnings("unchecked")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminParamPLServiceCommand implements CommandInterface {

	
	private AdminParamPLDao adminParamPLDao;
	/**
	 * (non-Javadoc).
	 * 
	 * @param data the data
	 * 
	 * @return the serializable
	 * 
	 * @throws Throwable the throwable
	 * 
	 * @see bgc.gen.commons.CommandInterface#execute(bgc.gen.commons.fdt.Bean)
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Serializable execute(Bean data) throws Throwable {
		
		
		AdminParamPLServiceBean bean = (AdminParamPLServiceBean)data;
		
		String function = bean.getFunction();
		
		AdminParamPL adminParamPL = new AdminParamPL();
		
		try {
			
			BeanUtils.copyProperties(bean,adminParamPL);
			
			
			System.out.println("function :: "+function);
			if("A".equals(function) || "U".equals(function))
			{
				adminParamPL = (AdminParamPL)adminParamPLDao.saveAdminParamPL(adminParamPL);
				
			}else if("D".equals(function))
			{
				adminParamPLDao.deleteAdminParamPL(adminParamPL);
				
			}else if("R".equals(function))
			{
				
				List<AdminParamPL> resut= (List<AdminParamPL>)adminParamPLDao.readAdminParamPL();
				
				
				if(resut !=null && resut.size()>0)
				{
					adminParamPL = resut.get(0);
					
					BeanUtils.copyProperties(adminParamPL, bean);
					
					
					
				}
				
			}
	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
		
		
	}
	public AdminParamPLDao getAdminParamPLDao() {
		return adminParamPLDao;
	}
	public void setAdminParamPLDao(AdminParamPLDao adminParamPLDao) {
		this.adminParamPLDao = adminParamPLDao;
	}

	

	
	

	
}
