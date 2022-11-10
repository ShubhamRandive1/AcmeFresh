package com.AsmeFresh.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AsmeFresh.Model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
