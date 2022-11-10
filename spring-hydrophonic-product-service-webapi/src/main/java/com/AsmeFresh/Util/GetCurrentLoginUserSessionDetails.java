package com.AsmeFresh.Util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AsmeFresh.Model.Customer;
import com.AsmeFresh.Model.UserCurrentSession;
import com.AsmeFresh.Repository.CustomerLoginSessionRepository;
import com.AsmeFresh.Repository.CustomerRepository;

@Component
public class GetCurrentLoginUserSessionDetails {
	
	@Autowired
	private CustomerLoginSessionRepository sessionDAO;

	@Autowired
	private CustomerRepository customerDAO;
	
	public UserCurrentSession getCurrentUserSession(String key) {
		Optional<UserCurrentSession> optional = sessionDAO.findByUuid(key);
		
		return optional.get();
	}
	
	public Integer getCurrentUserSessionId(String key) {
		Optional<UserCurrentSession> optional = sessionDAO.findByUuid(key);
		
		return optional.get().getId();
	}
	
	public Customer getCurrentCustomer(String key) {
		Optional<UserCurrentSession> optional = sessionDAO.findByUuid(key);
		
		Integer customerId = optional.get().getCustomerId();
		
		return  customerDAO.getById(customerId);
	}
	

}
