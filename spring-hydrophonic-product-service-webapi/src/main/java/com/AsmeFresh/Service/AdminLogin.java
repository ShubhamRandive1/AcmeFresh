package com.AsmeFresh.Service;

import com.AsmeFresh.Exceptions.AdminException;
import com.AsmeFresh.Model.AdminCurrentSessionDTO;
import com.AsmeFresh.Repository.AdminRepository;

public interface AdminLogin {
	
	public AdminCurrentSessionDTO logIntoAccount(AdminRepository adminDTO) throws AdminException;
		
	public String logOutFromAccount(String key) throws AdminException;

}
