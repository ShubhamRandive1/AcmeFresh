package com.AsmeFresh.Util;

import com.AsmeFresh.Exceptions.AdminException;
import com.AsmeFresh.Model.Admin;
import com.AsmeFresh.Model.AdminCurrentSession;

public interface GetCurrentLoginAdminSessionDetailsInerface {

	
	public AdminCurrentSession getCurrentUserSession(String key) throws AdminException;
	
	public Integer getCurrentUserSessionAdminId(String key) throws AdminException;
	
	public Admin getCurrentAdmin(String key) throws AdminException;
}
