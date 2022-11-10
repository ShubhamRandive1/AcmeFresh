package com.AsmeFresh.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.AsmeFresh.Exceptions.ProductException;
import com.AsmeFresh.Model.Product;
import com.AsmeFresh.Service.ProductService;

@RestController
public class ProductController {
	
	
	@Autowired
	private ProductService prodService;
	

	@GetMapping("/product/{productName}")
	public ResponseEntity<Product> getProductByNameHandler(@PathVariable("productName") String productName) throws ProductException{
		
		Product product = prodService.getProductDetailsByName(productName);
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProductDetailsHandler() throws ProductException{
		
		List<Product> productList = prodService.getAllProductDetails();
		
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}
}