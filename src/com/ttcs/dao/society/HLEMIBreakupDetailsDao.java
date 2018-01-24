package com.ttcs.dao.society;


import java.util.List;

import com.ttcs.dao.entities.HLEMIBreakupDetails;




/**
 * The Interface MockTestListDao.
 */
public interface HLEMIBreakupDetailsDao {


	
	HLEMIBreakupDetails saveHLEMIBreakupDetails(HLEMIBreakupDetails hlEMIBreakupDetails);
	String deleteHLEMIBreakupDetails(HLEMIBreakupDetails hlEMIBreakupDetails);
	List<HLEMIBreakupDetails> readHLEMIBreakupDetails(String custId);
	
	
}

