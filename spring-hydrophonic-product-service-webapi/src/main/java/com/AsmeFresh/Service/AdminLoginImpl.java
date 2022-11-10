package com.AsmeFresh.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AsmeFresh.Exceptions.AdminException;
import com.AsmeFresh.Model.Admin;
import com.AsmeFresh.Model.AdminCurrentSession;
import com.AsmeFresh.Model.AdminCurrentSessionDTO;
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
	public AdminCurrentSessionDTO logIntoAccount(AdminRepository adminDTO) throws AdminException {
		// TODO Auto-generated method stub
Admin opt = adminDAO.findByMobile(((Admin) adminDTO).getMobile());
		
		if(opt == null) {
			throw new AdminException("Please Enter Valid Mobile Number");
		}
		
		
		Integer adminId = opt.getAdminId();
		
		Optional<AdminCurrentSession> currentUserOptional = sessionDAO.findByAdminId(adminId);
		
		
		
//		Customer newCustomer = opt.get();
//		Integer customerId = newCustomer.getCustomerId();
//		Optional<CurrentUserSession> currentUserOptional = sessionDAO.findByCustomerId(customerId);
		
		if(currentUserOptional.isPresent()) {
			throw new AdminException("User already logged in with this number");
		}
		
		if(opt.getPassword().equals(((Admin) adminDTO).getPassword())) {
			
			String key = RandomString.make(6);
			
			AdminCurrentSession currentUserSession = new AdminCurrentSession();
			sessionDAO.save(currentUserSession);
			
			
			return new AdminCurrentSessionDTO(adminId,key,LocalDateTime.now());
		}
		else {
			throw new AdminException("Please Enter Valid Password");
		}
	}

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

}
