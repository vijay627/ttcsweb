package com.ttcs.dao.society;


import java.util.List;

import com.ttcs.dao.entities.GenSavingsDetails;




/**
 * The Interface MockTestListDao.
 */
public interface GenSavingsDetailsDao {


	
	GenSavingsDetails saveGenSavingsDetails(GenSavingsDetails genSavingsDetails);
	String deleteGenSavingsDetails(GenSavingsDetails genSavingsDetails);
	List<GenSavingsDetails> readGenSavingsDetails(String custId);
	
	
}

