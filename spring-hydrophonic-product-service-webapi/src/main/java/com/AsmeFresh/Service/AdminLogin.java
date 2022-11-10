package com.AsmeFresh.Service;

import com.AsmeFresh.Exceptions.AdminException;
import com.AsmeFresh.Exceptions.LoginException;
import com.AsmeFresh.Model.AdminCurrentSessionDTO;
import com.AsmeFresh.Model.AdminDto;

public interface AdminLogin {
	
	public String logIntoAccount(AdminDto adminDTO) throws AdminException, LoginException;
		
	public String logOutFromAccount(String key) throws AdminException;

}
