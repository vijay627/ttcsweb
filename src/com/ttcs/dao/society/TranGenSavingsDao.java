package com.ttcs.dao.society;


import java.util.List;

import com.ttcs.dao.entities.TranGenSavings;




/**
 * The Interface MockTestListDao.
 */
public interface TranGenSavingsDao {


	
	TranGenSavings saveTranGenSavings(TranGenSavings tranGenSavings);
	String deleteTranGenSavings(TranGenSavings tranGenSavings);
	List<TranGenSavings> readTranGenSavings(String custId);
	
	
}

