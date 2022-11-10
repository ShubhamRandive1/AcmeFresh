package com.AsmeFresh.Service;

import java.util.List;

import com.AsmeFresh.Exceptions.AdminException;
import com.AsmeFresh.Exceptions.ProductException;
import com.AsmeFresh.Model.Product;

public interface ProductService {
	
	public Product addProduct(Product product,String key) throws AdminException;

	public Product updateProduct(Product product,String key) throws AdminException;

	public Product deleteProductByName(String name,String key) throws ProductException, AdminException;
	
	public Product getProductDetailsByName(String productName) throws ProductException;
		
	public List<Product> getAllProductDetails() throws ProductException;

}

