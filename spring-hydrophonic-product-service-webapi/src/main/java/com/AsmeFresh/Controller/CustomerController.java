package com.AsmeFresh.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AsmeFresh.Exceptions.LoginException;
import com.AsmeFresh.Model.Customer;
import com.AsmeFresh.Service.CustomerService;
import com.AsmeFresh.Service.ProductService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
	@Autowired
	private CustomerService cusService;
	
	
	@Autowired
	private ProductService prodService;

	
	
	@PostMapping("/")
	public Customer registerCustomerHandler(@Valid @RequestBody Customer customer) throws LoginException {
		
		
	return 	cusService.registerCustomer(customer);
		
	}	
	
	
	
	// To update existing user details by passing its login key
		@PutMapping("/")
		public Customer updateCustomerHandler(@Valid @RequestBody Customer customer, @RequestParam(required = false) String key) throws LoginException {
			return cusService.updateCustomer(customer, key);
		}
		
		
		
	
	
		// To delete existing user details by passing its login key
		@DeleteMapping(value = "/")
		public Customer deleteCustomerHandler(@RequestParam(required = false) String key) throws LoginException {
			return cusService.deleteCustomer(key);
		}
		
		
		// To get details of current user by passing its login key
		@GetMapping(value = "/")
		public Customer getCustomerDetailsHandler(@RequestParam(required = false) String key) throws LoginException {
			return cusService.getCustomerDetails(key);
		}
	
	
}