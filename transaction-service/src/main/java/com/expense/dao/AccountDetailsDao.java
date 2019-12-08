package com.expense.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.entity.AccountDetailsEntity;


@Repository
public interface AccountDetailsDao extends JpaRepository<AccountDetailsEntity, Long>{
	
	public AccountDetailsEntity findByUserDetailsId(Long id);

}
