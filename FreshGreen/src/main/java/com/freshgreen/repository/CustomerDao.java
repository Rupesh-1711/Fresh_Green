package com.freshgreen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freshgreen.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	Customer findByEmailId(String email);

}
