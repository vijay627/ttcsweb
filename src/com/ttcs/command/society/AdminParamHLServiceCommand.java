package com.ttcs.command.society;






import java.io.Serializable;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.commons.CommandInterface;
import com.ttcs.commons.pojo.Bean;
import com.ttcs.commons.pojo.society.AdminParamHLServiceBean;
import com.ttcs.dao.entities.AdminParamHL;
import com.ttcs.dao.society.AdminParamHLDao;

// TODO: Auto-generated Javadoc
@SuppressWarnings("unchecked")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AdminParamHLServiceCommand implements CommandInterface {

	
	private AdminParamHLDao adminParamHLDao;
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
		
		
		AdminParamHLServiceBean bean = (AdminParamHLServiceBean)data;
		
		String function = bean.getFunction();
		
		AdminParamHL adminParamHL = new AdminParamHL();
		
		try {
			
			BeanUtils.copyProperties(bean,adminParamHL);
			
			
			System.out.println("function :: "+function);
			if("A".equals(function) || "U".equals(function))
			{
				adminParamHL = (AdminParamHL)adminParamHLDao.saveAdminParamHL(adminParamHL);
				
			}else if("D".equals(function))
			{
				adminParamHLDao.deleteAdminParamHL(adminParamHL);
				
			}else if("R".equals(function))
			{
				
				List<AdminParamHL> resut= (List<AdminParamHL>)adminParamHLDao.readAdminParamHL();
				
				
				if(resut !=null && resut.size()>0)
				{
					adminParamHL = resut.get(0);
					
					BeanUtils.copyProperties(adminParamHL, bean);
					
					
					
				}
				
			}
	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
		
		
	}
	public AdminParamHLDao getAdminParamHLDao() {
		return adminParamHLDao;
	}
	public void setAdminParamHLDao(AdminParamHLDao adminParamHLDao) {
		this.adminParamHLDao = adminParamHLDao;
	}

	

	
	

	
}
