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
import com.ttcs.commons.pojo.society.TranGenSavingsServiceBean;
import com.ttcs.dao.entities.TranGenSavings;
import com.ttcs.dao.society.TranGenSavingsDao;

// TODO: Auto-generated Javadoc
@SuppressWarnings("unchecked")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TranGenSavingsServiceCommand implements CommandInterface {

	private TranGenSavingsDao tranGenSavingsDao;
	
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
		
		TranGenSavingsServiceBean bean = (TranGenSavingsServiceBean)data;
		
		String function = bean.getFunction();
		
		TranGenSavings tranGenSavings = new TranGenSavings();
		
		try {
			
			BeanUtils.copyProperties(bean,tranGenSavings, new String[]{"tranDate"});
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			if(StringUtils.isNotEmpty(bean.getTranDate()))
			{
				tranGenSavings.setTranDate(formatter.parse(bean.getTranDate()));
			}
			
			
			
			
			
			if("A".equals(function) || "U".equals(function))
			{
				tranGenSavings = (TranGenSavings)tranGenSavingsDao.saveTranGenSavings(tranGenSavings);
				
			}else if("D".equals(function))
			{
				tranGenSavingsDao.deleteTranGenSavings(tranGenSavings);
				
			}else if("R".equals(function))
			{
				
				List<TranGenSavings> resut= (List<TranGenSavings>)tranGenSavingsDao.readTranGenSavings(bean.getCustId());
				
				
				if(resut !=null && resut.size()>0)
				{
					tranGenSavings = resut.get(0);
					
					BeanUtils.copyProperties(tranGenSavings, bean,new String[]{"tranDate"});
					
					if(tranGenSavings.getTranDate() !=null)
					{
						bean.setTranDate(String.valueOf(formatter.format(tranGenSavings.getTranDate())));
					}
					
					
					
					
					
				}
				
			}
	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	public TranGenSavingsDao getTranGenSavingsDao() {
		return tranGenSavingsDao;
	}

	public void setTranGenSavingsDao(TranGenSavingsDao tranGenSavingsDao) {
		this.tranGenSavingsDao = tranGenSavingsDao;
	}

	

	
	

	
}
