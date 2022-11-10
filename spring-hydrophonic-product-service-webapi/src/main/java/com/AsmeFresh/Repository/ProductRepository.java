package com.AsmeFresh.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.AsmeFresh.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
public Product findByProductName(String productName);
	
	@Query("DELETE FROM Product prod WHERE prod.productName=?1")
	public String deleteProductByName(String productName);

}
