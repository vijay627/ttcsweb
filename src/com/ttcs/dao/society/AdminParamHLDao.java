package com.ttcs.dao.society;


import java.util.List;

import com.ttcs.dao.entities.AdminParamHL;




/**
 * The Interface MockTestListDao.
 */
public interface AdminParamHLDao {


	
	AdminParamHL saveAdminParamHL(AdminParamHL adminParamHL);
	String deleteAdminParamHL(AdminParamHL adminParamHL);
	List<AdminParamHL> readAdminParamHL();
	
	
}

