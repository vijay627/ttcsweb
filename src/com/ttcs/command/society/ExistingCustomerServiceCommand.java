package com.ttcs.command.society;






import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ttcs.commons.CommandInterface;
import com.ttcs.commons.pojo.Bean;

// TODO: Auto-generated Javadoc
@SuppressWarnings("unchecked")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ExistingCustomerServiceCommand implements CommandInterface {

	
	
	/**
	 * (non-Javadoc).
	 * 
	 * @param data the data
	 * 
	 * @return the serializable
	 * 
	 * @throws Throwable the throwable
	 * 
	 * @see bgc.gen.commons.CommandInterface#execute(bgc.gen.commons.fdt.Bean)
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Serializable execute(Bean data) throws Throwable {
		
		
		return null;
	}

	

	
	

	
}
