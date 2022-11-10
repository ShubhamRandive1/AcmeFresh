package com.AsmeFresh.Util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AsmeFresh.Exceptions.LoginException;
import com.AsmeFresh.Model.Customer;
import com.AsmeFresh.Model.UserCurrentSession;
import com.AsmeFresh.Repository.CustomerLoginSessionRepository;
import com.AsmeFresh.Repository.CustomerRepository;

@Component
public class GetCurrentLoginUserSessionDetailsImpl implements GetCurrentLoginUserSessionDetailsInerface {

	
	
	@Autowired
	private CustomerLoginSessionRepository sessionDAO;

	@Autowired
	private CustomerRepository customerDAO;
	
	
	public UserCurrentSession getCurrentUserSession(String key) throws LoginException {
		Optional<UserCurrentSession> optional = sessionDAO.findByUuid(key);
		
		if(!optional.isPresent()) {
			throw new  LoginException("Unauthorized");
		}
		
		return optional.get();
	}
	
	public Integer getCurrentUserSessionId(String key) throws LoginException{
		Optional<UserCurrentSession> optional = sessionDAO.findByUuid(key);
		
		if(!optional.isPresent()) {
			throw new LoginException("Unauthorized");
		}
		
		return optional.get().getId();
	}
	
	public Customer getCurrentCustomer(String key) throws LoginException {
		Optional<UserCurrentSession> optional = sessionDAO.findByUuid(key);
		
		if(!optional.isPresent()) {
			throw new LoginException("Customer not logged in, login first...");
		}
		
		Integer customerId = optional.get().getCustomerId();
		
		return  customerDAO.findById(customerId).get();
	}
	
	
	
}