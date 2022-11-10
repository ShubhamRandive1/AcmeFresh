package com.AsmeFresh.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AsmeFresh.Exceptions.AdminException;
import com.AsmeFresh.Exceptions.CustomerException;
import com.AsmeFresh.Model.Admin;
import com.AsmeFresh.Model.Customer;
import com.AsmeFresh.Repository.AdminRepository;
import com.AsmeFresh.Repository.CustomerRepository;
import com.AsmeFresh.Util.GetCurrentLoginAdminSessionDetailsImpl;

@Service
public class AdminServiceImpl  implements AdminService{
	
	@Autowired
	private AdminRepository adminDAO;
	
	@Autowired
	private CustomerRepository customerDAO;
	
	@Autowired
	private GetCurrentLoginAdminSessionDetailsImpl getCurrentLoginUser;

	@Override
	public Admin registerAdmin(Admin admin) throws AdminException {
		Admin oldAdmin = adminDAO.findByMobile(admin.getMobile());
		
		if(oldAdmin==null)
		{
			return adminDAO.save(admin);
		}
		 throw new AdminException("Admin already exist");
		
	}

	@Override
	public Admin updateAdmin(Admin admin, String key) throws AdminException {
		Admin customer2 = getCurrentLoginUser.getCurrentAdmin(key);	
		
		if(customer2.getMobile().equals(admin.getMobile()))
		{
			adminDAO.save(admin);
			return admin;
		}
		else{
			throw new AdminException("No user found.. try login first");
		}
	}

	@Override
	public Admin deleteAdmin(String key) throws AdminException {
		Admin admin = getCurrentLoginUser.getCurrentAdmin(key);		
		adminDAO.delete(admin);
		return admin;
	}

	@Override
	public Admin getAdminDetails(String key) throws AdminException {
		Admin admin = getCurrentLoginUser.getCurrentAdmin(key);	
		System.out.println(admin);
		return admin;
	}
	
	
//      +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	|                             Customers                                               |
//	+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	
	
	@Override
	public List<Customer> getCustomers(String key) throws AdminException, CustomerException {
		Admin admin = getCurrentLoginUser.getCurrentAdmin(key);	
		if(admin!=null)
		{
			List<Customer> customers = customerDAO.findAll();
			
			if(!customers.isEmpty())
			{
				return customers;
			}
			throw new CustomerException("No customer exists.");
			
		}
		else {
			throw new AdminException("The admin is not logged in");
		}
	}

	@Override
	public Customer getCustomerByMobile(String mobile, String key) throws AdminException, CustomerException {
		Admin admin = getCurrentLoginUser.getCurrentAdmin(key);	
		if(admin!=null)
		{
			Customer customer = customerDAO.findByMobile(mobile);
			
			if(customer!=null)
			{
				return customer;
			}
			throw new CustomerException("No customer exists with mobile number: " + mobile);
			
		}
		else {
			throw new AdminException("The admin is not logged in");
		}
	}



	

}
