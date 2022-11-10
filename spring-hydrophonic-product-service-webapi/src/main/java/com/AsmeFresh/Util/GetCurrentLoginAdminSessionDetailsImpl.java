package com.AsmeFresh.Util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AsmeFresh.Exceptions.AdminException;
import com.AsmeFresh.Model.Admin;
import com.AsmeFresh.Model.AdminCurrentSession;
import com.AsmeFresh.Repository.AdminRepository;
import com.AsmeFresh.Repository.AdminSessionRepository;

@Component
public class GetCurrentLoginAdminSessionDetailsImpl implements GetCurrentLoginAdminSessionDetailsInerface{

	
	@Autowired
	private AdminSessionRepository sessionDAO;

	@Autowired
	private AdminRepository adminDAO;
	
	
	public AdminCurrentSession getCurrentUserSession(String key) throws AdminException {
		Optional<AdminCurrentSession> optional = sessionDAO.findByUuid(key);
		
		if(!optional.isPresent()) {
			
			throw new AdminException("The user is not authorised as Admin");
		}
		
		return optional.get();
	}
	
	public Integer getCurrentUserSessionAdminId(String key) throws AdminException{
		Optional<AdminCurrentSession> optional = sessionDAO.findByUuid(key);
		
		if(!optional.isPresent()) {
			throw new AdminException("The user is not authorised as Admin");
		}
		
		return optional.get().getAdminId();
	}
	
	public Admin getCurrentAdmin(String key) throws AdminException {
		Optional<AdminCurrentSession> optional = sessionDAO.findByUuid(key);
		
		if(!optional.isPresent()) {
			throw new AdminException("The user is not authorised as Admin");
		}
		
		Integer adminId = optional.get().getAdminId();
		
		return  adminDAO.findById(adminId).get();
	}

}