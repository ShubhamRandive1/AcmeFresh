package com.AsmeFresh.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AsmeFresh.Model.AdminCurrentSession;

@Repository
public interface AdminSessionRepository extends JpaRepository<AdminCurrentSession, Integer>{

	public Optional<AdminCurrentSession>  findByAdminId(Integer adminId);
	
	public Optional<AdminCurrentSession>  findByUuid(String uuid);
	
}
