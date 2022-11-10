package com.AsmeFresh.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AsmeFresh.Exceptions.AdminException;
import com.AsmeFresh.Exceptions.LoginException;
import com.AsmeFresh.Model.AdminCurrentSessionDTO;
import com.AsmeFresh.Model.AdminDto;
import com.AsmeFresh.Repository.AdminRepository;
import com.AsmeFresh.Service.AdminLoginImpl;

@RestController
@RequestMapping("/admin")
public class AdminLoginController {

	
	@Autowired
	private AdminLoginImpl adminLogIn;

	// for user Login
	@PostMapping("/login")
	public String logInAdminHandler(@RequestBody AdminDto adminDTO) throws AdminException, LoginException {
		
		return adminLogIn.logIntoAccount(adminDTO);
	}
	
	// for user Logout
	@PatchMapping("/logout")
	public String logOutAdminHandler(@RequestParam(required = false) String key) throws AdminException {
		return adminLogIn.logOutFromAccount(key);
	}

	
	
	
}