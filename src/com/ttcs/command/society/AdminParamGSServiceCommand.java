package com.ttcs.command.society;






import java.io.Serializable;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.commons.CommandInterface;
import com.ttcs.commons.pojo.Bean;
import com.ttcs.commons.pojo.society.AdminParamGSServiceBean;
import com.ttcs.dao.entities.AdminParamGS;
import com.ttcs.dao.society.AdminParamGSDao;

// TODO: Auto-generated Javadoc
@SuppressWarnings("unchecked")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminParamGSServiceCommand implements CommandInterface {

	
	private AdminParamGSDao adminParamGSDao;
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
		
		
		AdminParamGSServiceBean bean = (AdminParamGSServiceBean)data;
		
		String function = bean.getFunction();
		
		AdminParamGS adminParamGS = new AdminParamGS();
		
		try {
			
			BeanUtils.copyProperties(bean,adminParamGS);
			
			
			System.out.println("function :: "+function);
			if("A".equals(function) || "U".equals(function))
			{
				adminParamGS = (AdminParamGS)adminParamGSDao.saveAdminParamGS(adminParamGS);
				
			}else if("D".equals(function))
			{
				adminParamGSDao.deleteAdminParamGS(adminParamGS);
				
			}else if("R".equals(function))
			{
				
				List<AdminParamGS> resut= (List<AdminParamGS>)adminParamGSDao.readAdminParamGS();
				
				
				if(resut !=null && resut.size()>0)
				{
					adminParamGS = resut.get(0);
					
					BeanUtils.copyProperties(adminParamGS, bean);
					
					
					
				}
				
			}
	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
		
		
	}
	public AdminParamGSDao getAdminParamGSDao() {
		return adminParamGSDao;
	}
	public void setAdminParamGSDao(AdminParamGSDao adminParamGSDao) {
		this.adminParamGSDao = adminParamGSDao;
	}

	

	
	

	
}
