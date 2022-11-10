package com.AsmeFresh.Service;

import com.AsmeFresh.Exceptions.LoginException;
import com.AsmeFresh.Model.Customer;

public interface CustomerService {
	
	
	public Customer registerCustomer(Customer customer) throws LoginException;
	
    public Customer updateCustomer(Customer customer, String key) throws LoginException;
	
	public Customer deleteCustomer(String key) throws LoginException;
	
	public Customer getCustomerDetails(String key) throws LoginException;

}
