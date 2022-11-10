package com.AsmeFresh.Util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.AsmeFresh.Model.Admin;
import com.AsmeFresh.Model.AdminCurrentSession;
import com.AsmeFresh.Repository.AdminRepository;
import com.AsmeFresh.Repository.AdminSessionRepository;

@Component
public class GetCurrentLoginAdminSessionDetails {

	
	@Autowired
	private AdminSessionRepository sessionDAO;

	@Autowired
	private AdminRepository adminDAO;
	
	public AdminCurrentSession getCurrentUserSession(String key) {
		Optional<AdminCurrentSession> optional = sessionDAO.findByUuid(key);
		
		return optional.get();
	}
	
	public Integer getCurrentUserSessionId(String key) {
		Optional<AdminCurrentSession> optional = sessionDAO.findByUuid(key);
		
		return optional.get().getId();
	}
	
	public Admin getCurrentCustomer(String key) {
		Optional<AdminCurrentSession> optional = sessionDAO.findByUuid(key);
		
		Integer adminId = optional.get().getId();
		
		return  adminDAO.getById(adminId);
	}
	
	
}
