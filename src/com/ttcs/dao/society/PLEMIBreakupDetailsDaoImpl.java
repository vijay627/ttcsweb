package com.ttcs.dao.society;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.dao.TtcsDao;
import com.ttcs.dao.entities.PLEMIBreakupDetails;



@Repository("plEMIBreakupDetailsDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class PLEMIBreakupDetailsDaoImpl extends TtcsDao implements
PLEMIBreakupDetailsDao {


	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public PLEMIBreakupDetails savePLEMIBreakupDetails(PLEMIBreakupDetails plEMIBreakupDetails)
	{
		
		try {
			
			System.out.println("Hitting DAO");
			save(plEMIBreakupDetails);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return plEMIBreakupDetails;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String deletePLEMIBreakupDetails(PLEMIBreakupDetails plEMIBreakupDetails)
	{
		
		try {
			
			remove(plEMIBreakupDetails);
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
	public List<PLEMIBreakupDetails> readPLEMIBreakupDetails(String custId)
	{
		
		try {
			
			StringBuilder query = new StringBuilder();
			query.append("select plEMIBreakupDetails from ").append(PLEMIBreakupDetails.class.getName()).append(" plEMIBreakupDetails");
			query.append(" where plEMIBreakupDetails.custId = :custId");
			
			Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(query.toString());
			q.setString("custId", custId);
			
			List<PLEMIBreakupDetails> list = q.list();
			
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

