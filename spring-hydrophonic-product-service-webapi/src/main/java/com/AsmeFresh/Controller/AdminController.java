package com.AsmeFresh.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AsmeFresh.Exceptions.AdminException;
import com.AsmeFresh.Exceptions.CustomerException;
import com.AsmeFresh.Exceptions.ProductException;
import com.AsmeFresh.Model.Admin;
import com.AsmeFresh.Model.Customer;
import com.AsmeFresh.Model.Product;
import com.AsmeFresh.Service.AdminServiceImpl;
import com.AsmeFresh.Service.ProductService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminServiceImpl aService;

	
	
	@PostMapping("/admin")
	public Admin registerAdminHandler(@Valid @RequestBody Admin admin) throws AdminException {

		return aService.registerAdmin(admin);


	}
	

	// To update existing user details by passing its login key
	@PutMapping(value = "/admin")
	public Admin updateAdminHandler(@Valid @RequestBody Admin admin, @RequestParam(required = false) String key) throws AdminException {
		return aService.updateAdmin(admin, key);
	}

	
	
	// To delete existing user details by passing its login key
	@DeleteMapping(value = "/admin")
	public Admin deleteAdminHandler(@RequestParam(required = false) String key) throws AdminException {
		return aService.deleteAdmin(key);
	}

	
	
	// To get details of current user by passing its login key
	@GetMapping(value = "/admin")
	public Admin getAdminDetailsHandler(@RequestParam(required = false) String key) throws AdminException {
		return aService.getAdminDetails(key);
	}
	
	
	
	
	
	
	
	
	
//	---------------------------------------Product Controller In Admin--------------------------------------
	
	
	@Autowired
	private ProductService pService;
	
	
	@PostMapping("/product")
	public Product addProductHandler(@Valid @RequestBody Product product,@RequestParam String key) throws AdminException
	{
		return pService.addProduct(product,key);
	}
	

	
	@PutMapping("/product")
	public Product updateProductHandler(@Valid @RequestBody Product product,@RequestParam String key) throws AdminException
	{
		return pService.updateProduct(product,key);
	}
	
	@DeleteMapping("/product/{name}")
	public Product deleteProductByNameHandler(@PathVariable String name,@RequestParam String key) throws ProductException, AdminException
	{
		return pService.deleteProductByName(name,key);
	}
	
	
	
	
	
	
	
		
//	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	|                            Customers Control By Admin                                    |
//	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomersDetailsHandler(@RequestParam String key) throws AdminException, CustomerException
	{
		return aService.getCustomers(key);
	}
	
	@GetMapping("/customer/{mobile}")
	public Customer getCustomerDetailsHandler(@PathVariable String mobile,@RequestParam String key) throws AdminException, CustomerException
	{
		return aService.getCustomerByMobile(mobile, key);
	}
	
	
	
}