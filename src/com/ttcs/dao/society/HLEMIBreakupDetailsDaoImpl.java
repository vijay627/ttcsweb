package com.ttcs.dao.society;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.dao.TtcsDao;
import com.ttcs.dao.entities.HLEMIBreakupDetails;



@Repository("hlEMIBreakupDetailsDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class HLEMIBreakupDetailsDaoImpl extends TtcsDao implements
HLEMIBreakupDetailsDao {


	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public HLEMIBreakupDetails saveHLEMIBreakupDetails(HLEMIBreakupDetails hlEMIBreakupDetails)
	{
		
		try {
			
			System.out.println("Hitting DAO");
			save(hlEMIBreakupDetails);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return hlEMIBreakupDetails;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String deleteHLEMIBreakupDetails(HLEMIBreakupDetails hlEMIBreakupDetails)
	{
		
		try {
			
			remove(hlEMIBreakupDetails);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public List<HLEMIBreakupDetails> readHLEMIBreakupDetails(String custId)
	{
		
		try {
			
			StringBuilder query = new StringBuilder();
			query.append("select hlEMIBreakupDetails from ").append(HLEMIBreakupDetails.class.getName()).append(" hlEMIBreakupDetails");
			query.append(" where hlEMIBreakupDetails.custId = :custId");
			
			Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(query.toString());
			q.setString("custId", custId);
			
			List<HLEMIBreakupDetails> list = q.list();
			
			return list;
			
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}

