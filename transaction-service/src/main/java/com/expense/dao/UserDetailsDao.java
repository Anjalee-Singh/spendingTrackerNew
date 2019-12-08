package com.expense.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.entity.UserDetailsEntity;

@Repository
public interface UserDetailsDao extends JpaRepository<UserDetailsEntity, Long>{
	
	public UserDetailsEntity findByFirstName(String firstName);
	
	
	public UserDetailsEntity findByPhoneNumber(String phoneNumber);
	
	

}
