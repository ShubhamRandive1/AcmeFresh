package com.AsmeFresh.Service;

import java.util.List;

import com.AsmeFresh.Exceptions.AdminException;
import com.AsmeFresh.Exceptions.CustomerException;
import com.AsmeFresh.Model.Admin;
import com.AsmeFresh.Model.Customer;

public interface AdminService {
	
	 	public Admin registerAdmin(Admin admin) throws AdminException;
		
	    public Admin updateAdmin(Admin admin, String key) throws AdminException;
		
		public Admin deleteAdmin(String key) throws AdminException;
		
		public Admin getAdminDetails(String key) throws AdminException;
		
		public List<Customer> getCustomers(String key) throws AdminException, CustomerException;
		
		public Customer getCustomerByMobile(String mobile, String key) throws AdminException, CustomerException;
		

}
