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
import com.ttcs.commons.pojo.society.HLEMIBreakupServiceBean;
import com.ttcs.commons.pojo.society.HandLoanDetailsServiceBean;
import com.ttcs.dao.entities.HLEMIBreakupDetails;
import com.ttcs.dao.entities.HandLoanDetails;
import com.ttcs.dao.society.HLEMIBreakupDetailsDao;
import com.ttcs.dao.society.HandLoanDetailsDao;

// TODO: Auto-generated Javadoc
@SuppressWarnings("unchecked")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class HandLoanDetailsServiceCommand implements CommandInterface {

	private HandLoanDetailsDao handLoanDetailsDao;
	
	private HLEMIBreakupDetailsDao hlEMIBreakupDetailsDao;
	
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
		
		HandLoanDetailsServiceBean bean = (HandLoanDetailsServiceBean)data;
		
		String function = bean.getFunction();
		
		HandLoanDetails handLoanDetails = new HandLoanDetails();
		
		try {
			
			BeanUtils.copyProperties(bean,handLoanDetails, new String[]{"disbursedDate","collectionStartDate"});
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			if(StringUtils.isNotEmpty(bean.getDisbursedDate()))
			{
				handLoanDetails.setDisbursedDate(formatter.parse(bean.getDisbursedDate()));
			}
			
			if(StringUtils.isNotEmpty(bean.getCollectionStartDate()))
			{
				handLoanDetails.setCollectionStartDate(formatter.parse(bean.getCollectionStartDate()));
			}
			
			
			
			
			System.out.println("function :: "+function);
			if("A".equals(function) || "U".equals(function))
			{
				handLoanDetails = (HandLoanDetails)handLoanDetailsDao.saveHandLoanDetails(handLoanDetails);
				
			}else if("D".equals(function))
			{
				handLoanDetailsDao.deleteHandLoanDetails(handLoanDetails);
				
			}else if("R".equals(function))
			{
				
				List<HandLoanDetails> resut= (List<HandLoanDetails>)handLoanDetailsDao.readHandLoanDetails(bean.getCustId());
				
				
				if(resut !=null && resut.size()>0)
				{
					handLoanDetails = resut.get(0);
					
					BeanUtils.copyProperties(handLoanDetails, bean,new String[]{"disbursedDate","collectionStartDate"});
					
					if(handLoanDetails.getDisbursedDate() !=null)
					{
						bean.setDisbursedDate(String.valueOf(formatter.format(handLoanDetails.getDisbursedDate())));
					}
					
					if(handLoanDetails.getCollectionStartDate() !=null)
					{
						bean.setCollectionStartDate(String.valueOf(formatter.format(handLoanDetails.getCollectionStartDate())));
					}
					
					
					
				}
				
			}else if("ER".equals(function))
			{
				
				List<HandLoanDetails> resut= (List<HandLoanDetails>)handLoanDetailsDao.readHandLoanDetails(bean.getCustId());
				
				
				if(resut !=null && resut.size()>0)
				{
					handLoanDetails = resut.get(0);
					
					BeanUtils.copyProperties(handLoanDetails, bean,new String[]{"disbursedDate","collectionStartDate"});
					
					if(handLoanDetails.getDisbursedDate() !=null)
					{
						bean.setDisbursedDate(String.valueOf(formatter.format(handLoanDetails.getDisbursedDate())));
					}
					
					if(handLoanDetails.getCollectionStartDate() !=null)
					{
						bean.setCollectionStartDate(String.valueOf(formatter.format(handLoanDetails.getCollectionStartDate())));
					}
				}
				
				
				List<HLEMIBreakupDetails> resutEMI= (List<HLEMIBreakupDetails>)hlEMIBreakupDetailsDao.readHLEMIBreakupDetails(bean.getCustId());
				
				System.out.println("resutEMI :: "+resutEMI.size());
				if(resutEMI !=null && resutEMI.size()>0)
				{
					List<HLEMIBreakupServiceBean> hlEMIBreakupServiceBeanList = new ArrayList<HLEMIBreakupServiceBean>();
					for(HLEMIBreakupDetails hlEMIBreakupDetails:resutEMI)
					{
						HLEMIBreakupServiceBean hlEMIBreakupServiceBean = new HLEMIBreakupServiceBean();
						BeanUtils.copyProperties(hlEMIBreakupDetails,hlEMIBreakupServiceBean, new String[]{"installmentDate","paidDate"});
						
						
						if(hlEMIBreakupDetails.getInstallmentDate() !=null)
						{
							hlEMIBreakupServiceBean.setInstallmentDate(formatter.format(hlEMIBreakupDetails.getInstallmentDate()));
						}
						
						if(hlEMIBreakupDetails.getPaidDate() !=null)
						{
							hlEMIBreakupServiceBean.setPaidDate(formatter.format(hlEMIBreakupDetails.getPaidDate()));
						}
						
						hlEMIBreakupServiceBeanList.add(hlEMIBreakupServiceBean);
						
						bean.setHLEMIBreakupServiceBeanList(hlEMIBreakupServiceBeanList);
						
						
					}
				}
				
				
				
			}
			
			
			List<HLEMIBreakupServiceBean> hlEMIBreakupServiceBeanList = bean.getHLEMIBreakupServiceBeanList();
			
			if(hlEMIBreakupServiceBeanList !=null && hlEMIBreakupServiceBeanList.size()>0)
			{
				for(HLEMIBreakupServiceBean hlEMIBreakupServiceBean:hlEMIBreakupServiceBeanList)
				{
					HLEMIBreakupDetails hlEMIBreakupDetails = new HLEMIBreakupDetails();
					BeanUtils.copyProperties(hlEMIBreakupServiceBean,hlEMIBreakupDetails, new String[]{"installmentDate","paidDate"});
					
					
					if(StringUtils.isNotEmpty(hlEMIBreakupServiceBean.getInstallmentDate()))
					{
						hlEMIBreakupDetails.setInstallmentDate(formatter.parse(hlEMIBreakupServiceBean.getInstallmentDate()));
					}
					
					if(StringUtils.isNotEmpty(hlEMIBreakupServiceBean.getPaidDate()))
					{
						hlEMIBreakupDetails.setPaidDate(formatter.parse(hlEMIBreakupServiceBean.getPaidDate()));
					}
					
					if("A".equals(function) || "U".equals(function))
					{
						hlEMIBreakupDetails = (HLEMIBreakupDetails)hlEMIBreakupDetailsDao.saveHLEMIBreakupDetails(hlEMIBreakupDetails);
						
					}else if("D".equals(function))
					{
						hlEMIBreakupDetailsDao.deleteHLEMIBreakupDetails(hlEMIBreakupDetails);
						
					}
				}
		}
			
			
	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	public HandLoanDetailsDao getHandLoanDetailsDao() {
		return handLoanDetailsDao;
	}

	public void setHandLoanDetailsDao(HandLoanDetailsDao handLoanDetailsDao) {
		this.handLoanDetailsDao = handLoanDetailsDao;
	}

	public HLEMIBreakupDetailsDao getHlEMIBreakupDetailsDao() {
		return hlEMIBreakupDetailsDao;
	}

	public void setHlEMIBreakupDetailsDao(
			HLEMIBreakupDetailsDao hlEMIBreakupDetailsDao) {
		this.hlEMIBreakupDetailsDao = hlEMIBreakupDetailsDao;
	}

	

	
	

	
}
