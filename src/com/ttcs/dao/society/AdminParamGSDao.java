package com.ttcs.dao.society;


import java.util.List;

import com.ttcs.dao.entities.AdminParamGS;




/**
 * The Interface MockTestListDao.
 */
public interface AdminParamGSDao {


	
	AdminParamGS saveAdminParamGS(AdminParamGS adminParamGS);
	String deleteAdminParamGS(AdminParamGS adminParamGS);
	List<AdminParamGS> readAdminParamGS();
	
	
}

