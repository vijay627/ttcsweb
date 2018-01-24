package com.ttcs.dao.society;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.dao.TtcsDao;
import com.ttcs.dao.entities.AdminParamHL;



@Repository("adminParamHLDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class AdminParamHLDaoImpl extends TtcsDao implements
AdminParamHLDao {


	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public AdminParamHL saveAdminParamHL(AdminParamHL adminParamHL)
	{
		
		try {
			
			System.out.println("Hitting DAO");
			save(adminParamHL);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return adminParamHL;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String deleteAdminParamHL(AdminParamHL adminParamHL)
	{
		
		try {
			
			remove(adminParamHL);
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
	public List<AdminParamHL> readAdminParamHL()
	{
		
		try {
			
			StringBuilder query = new StringBuilder();
			query.append("select adminParamHL from ").append(AdminParamHL.class.getName()).append(" adminParamHL");
			
			
			Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(query.toString());
			
			
			List<AdminParamHL> list = q.list();
			
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

