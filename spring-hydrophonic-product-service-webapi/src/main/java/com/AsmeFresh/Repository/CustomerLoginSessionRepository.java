package com.AsmeFresh.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AsmeFresh.Model.UserCurrentSession;

@Repository
public interface CustomerLoginSessionRepository extends JpaRepository<UserCurrentSession, Integer>{

	public Optional<UserCurrentSession>  findByCustomerId(Integer customberId);
		
	public Optional<UserCurrentSession>  findByUuid(String uuid);
	
}
