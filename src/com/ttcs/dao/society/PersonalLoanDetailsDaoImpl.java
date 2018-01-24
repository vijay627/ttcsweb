package com.ttcs.dao.society;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.dao.TtcsDao;
import com.ttcs.dao.entities.PersonalLoanDetails;



@Repository("personalLoanDetailsDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class PersonalLoanDetailsDaoImpl extends TtcsDao implements
PersonalLoanDetailsDao {


	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public PersonalLoanDetails savePersonalLoanDetails(PersonalLoanDetails personalLoanDetails)
	{
		
		try {
			
			System.out.println("Hitting DAO");
			save(personalLoanDetails);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return personalLoanDetails;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String deletePersonalLoanDetails(PersonalLoanDetails personalLoanDetails)
	{
		
		try {
			
			remove(personalLoanDetails);
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
	public List<PersonalLoanDetails> readPersonalLoanDetails(String custId)
	{
		
		try {
			
			StringBuilder query = new StringBuilder();
			query.append("select personalLoanDetails from ").append(PersonalLoanDetails.class.getName()).append(" personalLoanDetails");
			query.append(" where personalLoanDetails.custId = :custId");
			
			Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(query.toString());
			q.setString("custId", custId);
			
			List<PersonalLoanDetails> list = q.list();
			
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

