package com.ttcs.dao.society;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.dao.TtcsDao;
import com.ttcs.dao.entities.TranGenSavings;



@Repository("tranGenSavingsDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class TranGenSavingsDaoImpl extends TtcsDao implements
TranGenSavingsDao {


	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public TranGenSavings saveTranGenSavings(TranGenSavings tranGenSavings)
	{
		
		try {
			
			System.out.println("Hitting DAO");
			save(tranGenSavings);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return tranGenSavings;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String deleteTranGenSavings(TranGenSavings tranGenSavings)
	{
		
		try {
			
			remove(tranGenSavings);
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
	public List<TranGenSavings> readTranGenSavings(String custId)
	{
		
		try {
			
			StringBuilder query = new StringBuilder();
			query.append("select tranGenSavings from ").append(TranGenSavings.class.getName()).append(" tranGenSavings");
			query.append(" where tranGenSavings.custId = :custId");
			
			Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(query.toString());
			q.setString("custId", custId);
			
			List<TranGenSavings> list = q.list();
			
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

