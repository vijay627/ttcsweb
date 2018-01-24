package com.ttcs.dao.society;


import java.util.List;

import com.ttcs.dao.entities.PersonalLoanDetails;




/**
 * The Interface MockTestListDao.
 */
public interface PersonalLoanDetailsDao {


	
	PersonalLoanDetails savePersonalLoanDetails(PersonalLoanDetails personalLoanDetails);
	String deletePersonalLoanDetails(PersonalLoanDetails personalLoanDetails);
	List<PersonalLoanDetails> readPersonalLoanDetails(String custId);
	
	
}

