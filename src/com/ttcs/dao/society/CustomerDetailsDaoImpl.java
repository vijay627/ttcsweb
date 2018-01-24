package com.ttcs.dao.society;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.dao.TtcsDao;
import com.ttcs.dao.entities.CustomerDetails;



@Repository("customerDetailsDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class CustomerDetailsDaoImpl extends TtcsDao implements
CustomerDetailsDao {


	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public CustomerDetails saveCustomerDetails(CustomerDetails customerDetails)
	{
		
		try {
			
			System.out.println("Hitting DAO");
			save(customerDetails);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return customerDetails;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public String deleteCustomerDetails(CustomerDetails customerDetails)
	{
		
		try {
			
			remove(customerDetails);
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
	public List<CustomerDetails> readCustomerDetails(long custId)
	{
		
		try {
			
			StringBuilder query = new StringBuilder();
			query.append("select customerDetails from ").append(CustomerDetails.class.getName()).append(" customerDetails");
			query.append(" where customerDetails.custId = :custId");
			
			Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(query.toString());
			q.setLong("custId", custId);
			
			List<CustomerDetails> list = q.list();
			
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

