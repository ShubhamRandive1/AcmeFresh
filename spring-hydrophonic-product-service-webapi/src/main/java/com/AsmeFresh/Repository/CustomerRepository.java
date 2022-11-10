package com.AsmeFresh.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AsmeFresh.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	public Customer findByMobile(String mobile);

	public Customer findByEmail(String email);

}
