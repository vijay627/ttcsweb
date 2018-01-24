package com.ttcs.dao.society;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.dao.TtcsDao;
import com.ttcs.dao.entities.HandLoanDetails;



@Repository("handLoanDetailsDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class HandLoanDetailsDaoImpl extends TtcsDao implements
HandLoanDetailsDao {


	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public HandLoanDetails saveHandLoanDetails(HandLoanDetails handLoanDetails)
	{
		
		try {
			
			System.out.println("Hitting DAO");
			save(handLoanDetails);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return handLoanDetails;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String deleteHandLoanDetails(HandLoanDetails handLoanDetails)
	{
		
		try {
			
			remove(handLoanDetails);
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
	public List<HandLoanDetails> readHandLoanDetails(String custId)
	{
		
		try {
			
			StringBuilder query = new StringBuilder();
			query.append("select handLoanDetails from ").append(HandLoanDetails.class.getName()).append(" handLoanDetails");
			query.append(" where handLoanDetails.custId = :custId");
			
			Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(query.toString());
			q.setString("custId", custId);
			
			List<HandLoanDetails> list = q.list();
			
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

