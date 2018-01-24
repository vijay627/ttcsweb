package com.ttcs.dao.society;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.dao.TtcsDao;
import com.ttcs.dao.entities.AdminParamPL;



@Repository("adminParamPLDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class AdminParamPLDaoImpl extends TtcsDao implements
AdminParamPLDao {


	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public AdminParamPL saveAdminParamPL(AdminParamPL adminParamPL)
	{
		
		try {
			
			System.out.println("Hitting DAO");
			save(adminParamPL);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return adminParamPL;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String deleteAdminParamPL(AdminParamPL adminParamPL)
	{
		
		try {
			
			remove(adminParamPL);
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
	public List<AdminParamPL> readAdminParamPL()
	{
		
		try {
			
			StringBuilder query = new StringBuilder();
			query.append("select adminParamPL from ").append(AdminParamPL.class.getName()).append(" adminParamPL");
			
			
			Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(query.toString());
			
			
			List<AdminParamPL> list = q.list();
			
			return list;
			
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}

