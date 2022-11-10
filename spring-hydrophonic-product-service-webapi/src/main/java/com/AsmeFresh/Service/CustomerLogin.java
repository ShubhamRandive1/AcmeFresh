package com.AsmeFresh.Service;

import com.AsmeFresh.Exceptions.LoginException;
import com.AsmeFresh.Model.UserCurrentSession;
import com.AsmeFresh.Repository.CustomerRepository;

public interface CustomerLogin {
	
	public UserCurrentSession logIntoAccount(CustomerRepository customerDTO) throws LoginException;
		
	public String logOutFromAccount(String key) throws LoginException;

}
