package com.AsmeFresh.Util;

import com.AsmeFresh.Exceptions.LoginException;
import com.AsmeFresh.Model.Customer;
import com.AsmeFresh.Model.UserCurrentSession;

public interface GetCurrentLoginUserSessionDetailsInerface {

	
	 	public UserCurrentSession getCurrentUserSession(String key) throws LoginException;
		
		public Integer getCurrentUserSessionId(String key) throws LoginException;
		
		public Customer getCurrentCustomer(String key) throws LoginException;
}
