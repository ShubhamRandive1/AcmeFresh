package com.AsmeFresh.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AsmeFresh.Exceptions.LoginException;
import com.AsmeFresh.Exceptions.ProductException;
import com.AsmeFresh.Model.Customer;
import com.AsmeFresh.Model.OrderItems;
import com.AsmeFresh.Model.Orders;
import com.AsmeFresh.Model.Product;
import com.AsmeFresh.Repository.CustomerRepository;
import com.AsmeFresh.Repository.ProductRepository;
import com.AsmeFresh.Util.GetCurrentLoginUserSessionDetailsImpl;

@Service
public class CustomerServiceImpl implements CustomerService{
         
	@Autowired
	private CustomerRepository cusDao;
	
//	@Autowired
//	private CartDao cartDao;
//	
	@Autowired
	private ProductRepository prodDao;
	
	
	
	@Autowired
	private GetCurrentLoginUserSessionDetailsImpl getCurrentLoginUser;

	
	@Override
	public Customer registerCustomer(Customer customer) throws LoginException {
		
	 Customer opt =	 cusDao.findByMobile(customer.getMobile());
	 
	 if(opt == null) {
		 return cusDao.save(customer);
	 }else {
		 throw new LoginException("User is already register");
	 }
	 
	 
	}


	@Override
	public Customer updateCustomer(Customer customer, String key) throws LoginException {
       Customer customer2 = getCurrentLoginUser.getCurrentCustomer(key);
		
		if(customer2 == null) {
			throw new LoginException("No user found.. try login first");
		}
		
		return cusDao.save(customer);
	}


	
	
	@Override
	public Customer deleteCustomer(String key) throws LoginException {
		Customer customer = getCurrentLoginUser.getCurrentCustomer(key);		
		cusDao.delete(customer);
		return customer;
	}


	@Override
	public Customer getCustomerDetails(String key) throws LoginException {
		Customer customer = getCurrentLoginUser.getCurrentCustomer(key);	
		System.out.println(customer);
		return customer;
	}










		
	
}