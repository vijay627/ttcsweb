package com.ttcs.command.society;






import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.commons.CommandInterface;
import com.ttcs.commons.pojo.Bean;
import com.ttcs.commons.pojo.society.StmtGenSavingsServiceBean;
import com.ttcs.commons.pojo.society.TranGenSavingsServiceBean;
import com.ttcs.dao.entities.TranGenSavings;
import com.ttcs.dao.society.TranGenSavingsDao;

// TODO: Auto-generated Javadoc
@SuppressWarnings("unchecked")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StmtGenSavingsServiceCommand implements CommandInterface {

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
		
		StmtGenSavingsServiceBean bean = (StmtGenSavingsServiceBean)data;
		
	
		try {
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				
			List<TranGenSavings> resut= (List<TranGenSavings>)tranGenSavingsDao.readTranGenSavings(bean.getCustId());
			
			List<TranGenSavingsServiceBean> serviceBeanList = new ArrayList<TranGenSavingsServiceBean>();
			
			if(resut !=null && resut.size()>0)
			{
				
				for (TranGenSavings tranGenSavings:resut) {
					
					TranGenSavingsServiceBean tranBean = new TranGenSavingsServiceBean();
					
					
					BeanUtils.copyProperties(tranGenSavings, tranBean,new String[]{"tranDate"});
					
					if(tranGenSavings.getTranDate() !=null)
					{
						tranBean.setTranDate(String.valueOf(formatter.format(tranGenSavings.getTranDate())));
					}
					
					serviceBeanList.add(tranBean);
				}
				
				bean.setTranGenSavingsServiceBeanList(serviceBeanList);
				
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
