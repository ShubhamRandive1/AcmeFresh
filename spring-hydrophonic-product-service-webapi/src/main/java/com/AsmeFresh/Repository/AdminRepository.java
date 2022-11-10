package com.AsmeFresh.Repository;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AsmeFresh.Exceptions.AdminException;
import com.AsmeFresh.Model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	public Admin findByMobile(String mobile)throws AdminException;

	
	
}
