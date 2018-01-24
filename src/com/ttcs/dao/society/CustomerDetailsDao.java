package com.ttcs.dao.society;


import java.util.List;

import com.ttcs.dao.entities.CustomerDetails;




/**
 * The Interface MockTestListDao.
 */
public interface CustomerDetailsDao {


	
	CustomerDetails saveCustomerDetails(CustomerDetails customerDetails);
	String deleteCustomerDetails(CustomerDetails customerDetails);
	List<CustomerDetails> readCustomerDetails(long custId);
	
	
}

