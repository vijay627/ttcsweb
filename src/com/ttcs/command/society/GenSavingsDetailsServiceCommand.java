package com.ttcs.command.society;






import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.commons.CommandInterface;
import com.ttcs.commons.pojo.Bean;
import com.ttcs.commons.pojo.society.GenSavingsDetailsServiceBean;
import com.ttcs.dao.entities.GenSavingsDetails;
import com.ttcs.dao.society.GenSavingsDetailsDao;

// TODO: Auto-generated Javadoc
@SuppressWarnings("unchecked")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GenSavingsDetailsServiceCommand implements CommandInterface {

	private GenSavingsDetailsDao genSavingsDetailsDao;
	
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
		
		GenSavingsDetailsServiceBean bean = (GenSavingsDetailsServiceBean)data;
		
		String function = bean.getFunction();
		
		GenSavingsDetails genSavingsDetails = new GenSavingsDetails();
		
		try {
			
			BeanUtils.copyProperties(bean,genSavingsDetails, new String[]{"openingDate"});
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			if(StringUtils.isNotEmpty(bean.getOpeningDate()))
			{
				genSavingsDetails.setOpeningDate(formatter.parse(bean.getOpeningDate()));
			}
			
			
			
			
			
			if("A".equals(function) || "U".equals(function))
			{
				genSavingsDetails = (GenSavingsDetails)genSavingsDetailsDao.saveGenSavingsDetails(genSavingsDetails);
				
			}else if("D".equals(function))
			{
				genSavingsDetailsDao.deleteGenSavingsDetails(genSavingsDetails);
				
			}else if("R".equals(function))
			{
				
				List<GenSavingsDetails> resut= (List<GenSavingsDetails>)genSavingsDetailsDao.readGenSavingsDetails(bean.getCustId());
				
				
				if(resut !=null && resut.size()>0)
				{
					genSavingsDetails = resut.get(0);
					
					BeanUtils.copyProperties(genSavingsDetails, bean,new String[]{"openingDate"});
					
					if(genSavingsDetails.getOpeningDate() !=null)
					{
						bean.setOpeningDate(String.valueOf(formatter.format(genSavingsDetails.getOpeningDate())));
					}
					
					
					
					
				}
				
			}
	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	public GenSavingsDetailsDao getGenSavingsDetailsDao() {
		return genSavingsDetailsDao;
	}

	public void setGenSavingsDetailsDao(GenSavingsDetailsDao genSavingsDetailsDao) {
		this.genSavingsDetailsDao = genSavingsDetailsDao;
	}

	

	
	

	
}
