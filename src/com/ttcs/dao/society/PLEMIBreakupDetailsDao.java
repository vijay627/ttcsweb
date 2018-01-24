package com.ttcs.dao.society;


import java.util.List;

import com.ttcs.dao.entities.PLEMIBreakupDetails;




/**
 * The Interface MockTestListDao.
 */
public interface PLEMIBreakupDetailsDao {


	
	PLEMIBreakupDetails savePLEMIBreakupDetails(PLEMIBreakupDetails plEMIBreakupDetails);
	String deletePLEMIBreakupDetails(PLEMIBreakupDetails plEMIBreakupDetails);
	List<PLEMIBreakupDetails> readPLEMIBreakupDetails(String custId);
	
	
}

