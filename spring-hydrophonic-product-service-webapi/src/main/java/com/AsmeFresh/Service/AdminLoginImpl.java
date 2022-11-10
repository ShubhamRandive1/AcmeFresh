package com.AsmeFresh.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AsmeFresh.Exceptions.AdminException;
import com.AsmeFresh.Exceptions.LoginException;
import com.AsmeFresh.Model.Admin;
import com.AsmeFresh.Model.AdminCurrentSession;
import com.AsmeFresh.Model.AdminDto;
import com.AsmeFresh.Repository.AdminRepository;
import com.AsmeFresh.Repository.AdminSessionRepository;
import com.AsmeFresh.Util.GetCurrentLoginAdminSessionDetailsImpl;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginImpl implements AdminLogin{
	
	@Autowired
	private AdminRepository adminDAO;
	
	@Autowired
	private AdminSessionRepository sessionDAO;
	
	@Autowired
	private GetCurrentLoginAdminSessionDetailsImpl getCurrentLoginUser;

	
	

	@Override
	public String logOutFromAccount(String key) throws AdminException {
		// TODO Auto-generated method stub
Optional<AdminCurrentSession> currentUserOptional = sessionDAO.findByUuid(key);
		
		if(!currentUserOptional.isPresent()) {
			throw new AdminException("User is not logged in with this number");
	}
	
	AdminCurrentSession currentUserSession = getCurrentLoginUser.getCurrentUserSession(key);
	sessionDAO.delete(currentUserSession);
	
	return "Logged Out...";
	}


	@Override
	public String logIntoAccount(AdminDto adminDao) throws AdminException, LoginException {
		// TODO Auto-generated method stub
		Admin ad = adminDAO.findByMobile(adminDao.getMobile());
		
		if(ad == null) {
			
			throw new AdminException("Admin not Found");
		}
		
	
	if(ad.getPassword().equals(adminDao.getPassword())) {
		
		String key= RandomString.make(6);
		
		
		
		AdminCurrentSession currentSession = new AdminCurrentSession();
		
		currentSession.setUuid(key);
		
		sessionDAO.save(currentSession);

		return currentSession.toString();
	}
	else
		throw new LoginException("Please Enter a valid password");
	}
	
}


