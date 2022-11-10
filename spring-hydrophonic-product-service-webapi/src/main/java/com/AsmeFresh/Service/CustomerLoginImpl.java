package com.AsmeFresh.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AsmeFresh.Exceptions.LoginException;
import com.AsmeFresh.Model.Customer;
import com.AsmeFresh.Model.UserCurrentSession;
import com.AsmeFresh.Repository.CustomerLoginSessionRepository;
import com.AsmeFresh.Repository.CustomerRepository;
import com.AsmeFresh.Util.GetCurrentLoginUserSessionDetailsImpl;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerLoginImpl implements CustomerLogin {

	
	@Autowired
	private CustomerRepository customerDAO;
	
	@Autowired
	private CustomerLoginSessionRepository sessionDAO;
	
	@Autowired
	private GetCurrentLoginUserSessionDetailsImpl getCurrentLoginUser;
	
	
	
	@Override
	public UserCurrentSession logIntoAccount(CustomerRepository customerDTO) throws LoginException {
		
		Customer opt = customerDAO.findByMobile(((Customer) customerDTO).getMobile());
		
		if(opt == null) {
			throw new LoginException("Please Enter Valid Mobile Number");
		}
		
		
		Integer customerId =opt.getCustomerId();
		
		Optional<UserCurrentSession> currentUserOptional = sessionDAO.findByCustomerId(customerId);

		
		if(currentUserOptional.isPresent()) {
			throw new LoginException("User already logged in with this number");
		}
		
		if(opt.getPassword().equals(((Customer) customerDTO).getPassword())) {
			
			String key = RandomString.make(8);
			
			UserCurrentSession currentUserSession = new UserCurrentSession();
			sessionDAO.save(currentUserSession);

			return currentUserSession;
		}
		else {
			throw new LoginException("Please Enter Valid Password");
		}
	}
	
	
	
	@Override
	public String logOutFromAccount(String key) throws LoginException {
		
		Optional<UserCurrentSession> currentUserOptional = sessionDAO.findByUuid(key);
		
		if(!currentUserOptional.isPresent()) {
			throw new LoginException("User is not logged in with this number");
		}
		
		UserCurrentSession currentUserSession = getCurrentLoginUser.getCurrentUserSession(key);
		sessionDAO.delete(currentUserSession);
		
		return "Logged Out...";
	}
	
	
}
