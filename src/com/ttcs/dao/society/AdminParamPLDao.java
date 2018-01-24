package com.ttcs.dao.society;


import java.util.List;

import com.ttcs.dao.entities.AdminParamPL;




/**
 * The Interface MockTestListDao.
 */
public interface AdminParamPLDao {


	
	AdminParamPL saveAdminParamPL(AdminParamPL adminParamPL);
	String deleteAdminParamPL(AdminParamPL adminParamPL);
	List<AdminParamPL> readAdminParamPL();
	
	
}

