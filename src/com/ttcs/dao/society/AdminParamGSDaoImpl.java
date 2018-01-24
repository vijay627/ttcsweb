package com.ttcs.dao.society;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.dao.TtcsDao;
import com.ttcs.dao.entities.AdminParamGS;



@Repository("adminParamGSDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class AdminParamGSDaoImpl extends TtcsDao implements
AdminParamGSDao {


	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public AdminParamGS saveAdminParamGS(AdminParamGS adminParamGS)
	{
		
		try {
			
			System.out.println("Hitting DAO");
			save(adminParamGS);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return adminParamGS;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String deleteAdminParamGS(AdminParamGS adminParamGS)
	{
		
		try {
			
			remove(adminParamGS);
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
	public List<AdminParamGS> readAdminParamGS()
	{
		
		try {
			
			StringBuilder query = new StringBuilder();
			query.append("select adminParamGS from ").append(AdminParamGS.class.getName()).append(" adminParamGS");
			
			
			Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(query.toString());
			
			
			List<AdminParamGS> list = q.list();
			
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

