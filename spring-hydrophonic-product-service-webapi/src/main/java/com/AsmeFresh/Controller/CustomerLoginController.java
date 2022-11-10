package com.AsmeFresh.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AsmeFresh.Exceptions.LoginException;
import com.AsmeFresh.Model.CustomerDTO;
import com.AsmeFresh.Model.UserCurrentSession;
import com.AsmeFresh.Repository.CustomerRepository;
import com.AsmeFresh.Service.CustomerLoginImpl;

@RestController
@RequestMapping("/customer")
public class CustomerLoginController {

	
	@Autowired
	private CustomerLoginImpl customerLogIn;

	// for user Login
	@PostMapping(value = "/login")
	public UserCurrentSession logInCustomerHandler(@Valid @RequestBody CustomerRepository customerDTO) throws LoginException {
		
		return customerLogIn.logIntoAccount(customerDTO);
	}
	
	// for user Logout
	@PatchMapping(value = "/logout")
	public String logOutCustomerHandler(@RequestParam(required = false) String key) throws LoginException {
		return customerLogIn.logOutFromAccount(key);
	}
	
}