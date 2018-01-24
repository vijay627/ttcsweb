package com.ttcs.dao.society;


import java.util.List;

import com.ttcs.dao.entities.UserDetails;




/**
 * The Interface MockTestListDao.
 */
public interface UserDetailsDao {


	
	UserDetails saveUserDetails(UserDetails userDetails);
	String deleteUserDetails(UserDetails userDetails);
	List<UserDetails> readUserDetails(String userId);
	
	
}

