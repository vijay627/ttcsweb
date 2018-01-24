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
import com.ttcs.commons.pojo.society.PLEMIBreakupServiceBean;
import com.ttcs.commons.pojo.society.PersonalLoanDetailsServiceBean;
import com.ttcs.dao.entities.PLEMIBreakupDetails;
import com.ttcs.dao.entities.PersonalLoanDetails;
import com.ttcs.dao.society.PLEMIBreakupDetailsDao;
import com.ttcs.dao.society.PersonalLoanDetailsDao;

// TODO: Auto-generated Javadoc
@SuppressWarnings("unchecked")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PersonalLoanDetailsServiceCommand implements CommandInterface {

	private PersonalLoanDetailsDao personalLoanDetailsDao;
	
	private PLEMIBreakupDetailsDao plEMIBreakupDetailsDao;
	
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
		
		PersonalLoanDetailsServiceBean bean = (PersonalLoanDetailsServiceBean)data;
		
		String function = bean.getFunction();
		
		PersonalLoanDetails personalLoanDetails = new PersonalLoanDetails();
		
		try {
			
			BeanUtils.copyProperties(bean,personalLoanDetails, new String[]{"disbursedDate","collectionStartDate"});
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			if(StringUtils.isNotEmpty(bean.getDisbursedDate()))
			{
				personalLoanDetails.setDisbursedDate(formatter.parse(bean.getDisbursedDate()));
			}
			
			if(StringUtils.isNotEmpty(bean.getCollectionStartDate()))
			{
				personalLoanDetails.setCollectionStartDate(formatter.parse(bean.getCollectionStartDate()));
			}
			
			
			
			
			System.out.println("function :: "+function);
			if("A".equals(function) || "U".equals(function))
			{
				personalLoanDetails = (PersonalLoanDetails)personalLoanDetailsDao.savePersonalLoanDetails(personalLoanDetails);
				
			}else if("D".equals(function))
			{
				personalLoanDetailsDao.deletePersonalLoanDetails(personalLoanDetails);
				
			}else if("R".equals(function))
			{
				
				List<PersonalLoanDetails> resut= (List<PersonalLoanDetails>)personalLoanDetailsDao.readPersonalLoanDetails(bean.getCustId());
				
				
				if(resut !=null && resut.size()>0)
				{
					personalLoanDetails = resut.get(0);
					
					BeanUtils.copyProperties(personalLoanDetails, bean,new String[]{"disbursedDate","collectionStartDate"});
					
					if(personalLoanDetails.getDisbursedDate() !=null)
					{
						bean.setDisbursedDate(String.valueOf(formatter.format(personalLoanDetails.getDisbursedDate())));
					}
					
					if(personalLoanDetails.getCollectionStartDate() !=null)
					{
						bean.setCollectionStartDate(String.valueOf(formatter.format(personalLoanDetails.getCollectionStartDate())));
					}
					
					
					
				}
				
			}else if("ER".equals(function))
			{
				
				List<PersonalLoanDetails> resut= (List<PersonalLoanDetails>)personalLoanDetailsDao.readPersonalLoanDetails(bean.getCustId());
				
				
				if(resut !=null && resut.size()>0)
				{
					personalLoanDetails = resut.get(0);
					
					BeanUtils.copyProperties(personalLoanDetails, bean,new String[]{"disbursedDate","collectionStartDate"});
					
					if(personalLoanDetails.getDisbursedDate() !=null)
					{
						bean.setDisbursedDate(String.valueOf(formatter.format(personalLoanDetails.getDisbursedDate())));
					}
					
					if(personalLoanDetails.getCollectionStartDate() !=null)
					{
						bean.setCollectionStartDate(String.valueOf(formatter.format(personalLoanDetails.getCollectionStartDate())));
					}
				}
				
				
				List<PLEMIBreakupDetails> resutEMI= (List<PLEMIBreakupDetails>)plEMIBreakupDetailsDao.readPLEMIBreakupDetails(bean.getCustId());
				
				System.out.println("resutEMI :: "+resutEMI.size());
				if(resutEMI !=null && resutEMI.size()>0)
				{
					List<PLEMIBreakupServiceBean> plEMIBreakupServiceBeanList = new ArrayList<PLEMIBreakupServiceBean>();
					for(PLEMIBreakupDetails plEMIBreakupDetails:resutEMI)
					{
						PLEMIBreakupServiceBean plEMIBreakupServiceBean = new PLEMIBreakupServiceBean();
						BeanUtils.copyProperties(plEMIBreakupDetails,plEMIBreakupServiceBean, new String[]{"installmentDate","paidDate"});
						
						
						if(plEMIBreakupDetails.getInstallmentDate() !=null)
						{
							plEMIBreakupServiceBean.setInstallmentDate(formatter.format(plEMIBreakupDetails.getInstallmentDate()));
						}
						
						if(plEMIBreakupDetails.getPaidDate() !=null)
						{
							plEMIBreakupServiceBean.setPaidDate(formatter.format(plEMIBreakupDetails.getPaidDate()));
						}
						
						plEMIBreakupServiceBeanList.add(plEMIBreakupServiceBean);
						
						bean.setPLEMIBreakupServiceBeanList(plEMIBreakupServiceBeanList);
						
						
					}
				}
				
				
				
			}
			
			
			List<PLEMIBreakupServiceBean> plEMIBreakupServiceBeanList = bean.getPLEMIBreakupServiceBeanList();
			
			if(plEMIBreakupServiceBeanList !=null && plEMIBreakupServiceBeanList.size()>0)
			{
				for(PLEMIBreakupServiceBean plEMIBreakupServiceBean:plEMIBreakupServiceBeanList)
				{
					PLEMIBreakupDetails plEMIBreakupDetails = new PLEMIBreakupDetails();
					BeanUtils.copyProperties(plEMIBreakupServiceBean,plEMIBreakupDetails, new String[]{"installmentDate","paidDate"});
					
					
					if(StringUtils.isNotEmpty(plEMIBreakupServiceBean.getInstallmentDate()))
					{
						plEMIBreakupDetails.setInstallmentDate(formatter.parse(plEMIBreakupServiceBean.getInstallmentDate()));
					}
					
					if(StringUtils.isNotEmpty(plEMIBreakupServiceBean.getPaidDate()))
					{
						plEMIBreakupDetails.setPaidDate(formatter.parse(plEMIBreakupServiceBean.getPaidDate()));
					}
					
					if("A".equals(function) || "U".equals(function))
					{
						plEMIBreakupDetails = (PLEMIBreakupDetails)plEMIBreakupDetailsDao.savePLEMIBreakupDetails(plEMIBreakupDetails);
						
					}else if("D".equals(function))
					{
						plEMIBreakupDetailsDao.deletePLEMIBreakupDetails(plEMIBreakupDetails);
						
					}
				}
		}
			
			
	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	public PersonalLoanDetailsDao getPersonalLoanDetailsDao() {
		return personalLoanDetailsDao;
	}

	public void setPersonalLoanDetailsDao(PersonalLoanDetailsDao personalLoanDetailsDao) {
		this.personalLoanDetailsDao = personalLoanDetailsDao;
	}

	public PLEMIBreakupDetailsDao getPlEMIBreakupDetailsDao() {
		return plEMIBreakupDetailsDao;
	}

	public void setPlEMIBreakupDetailsDao(
			PLEMIBreakupDetailsDao plEMIBreakupDetailsDao) {
		this.plEMIBreakupDetailsDao = plEMIBreakupDetailsDao;
	}

	

	
	

	
}
