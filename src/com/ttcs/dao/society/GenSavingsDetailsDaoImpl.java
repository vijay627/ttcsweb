package com.ttcs.dao.society;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.dao.TtcsDao;
import com.ttcs.dao.entities.GenSavingsDetails;



@Repository("genSavingsDetailsDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class GenSavingsDetailsDaoImpl extends TtcsDao implements
GenSavingsDetailsDao {


	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public GenSavingsDetails saveGenSavingsDetails(GenSavingsDetails genSavingsDetails)
	{
		
		try {
			
			System.out.println("Hitting DAO");
			save(genSavingsDetails);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return genSavingsDetails;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String deleteGenSavingsDetails(GenSavingsDetails genSavingsDetails)
	{
		
		try {
			
			remove(genSavingsDetails);
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
	public List<GenSavingsDetails> readGenSavingsDetails(String custId)
	{
		
		try {
			
			StringBuilder query = new StringBuilder();
			query.append("select genSavingsDetails from ").append(GenSavingsDetails.class.getName()).append(" genSavingsDetails");
			query.append(" where genSavingsDetails.custId = :custId");
			
			Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(query.toString());
			q.setString("custId", custId);
			
			List<GenSavingsDetails> list = q.list();
			
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

