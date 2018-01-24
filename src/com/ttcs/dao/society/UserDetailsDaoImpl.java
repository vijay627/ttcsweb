package com.ttcs.dao.society;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.dao.TtcsDao;
import com.ttcs.dao.entities.UserDetails;



@Repository("userDetailsDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class UserDetailsDaoImpl extends TtcsDao implements
UserDetailsDao {


	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public UserDetails saveUserDetails(UserDetails userDetails)
	{
		
		try {
			
			System.out.println("Hitting DAO");
			save(userDetails);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return userDetails;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String deleteUserDetails(UserDetails userDetails)
	{
		
		try {
			
			remove(userDetails);
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
	public List<UserDetails> readUserDetails(String userId)
	{
		
		try {
			
			StringBuilder query = new StringBuilder();
			query.append("select userDetails from ").append(UserDetails.class.getName()).append(" userDetails");
			query.append(" where userDetails.userId = :userId");
			
			Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(query.toString());
			q.setString("userId", userId);
			
			List<UserDetails> list = q.list();
			
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

