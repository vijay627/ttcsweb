package com.ttcs.dao.society;


import java.util.List;

import com.ttcs.dao.entities.HandLoanDetails;




/**
 * The Interface MockTestListDao.
 */
public interface HandLoanDetailsDao {


	
	HandLoanDetails saveHandLoanDetails(HandLoanDetails handLoanDetails);
	String deleteHandLoanDetails(HandLoanDetails handLoanDetails);
	List<HandLoanDetails> readHandLoanDetails(String custId);
	
	
}

