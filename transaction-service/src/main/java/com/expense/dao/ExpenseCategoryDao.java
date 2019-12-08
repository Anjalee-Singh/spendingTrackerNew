package com.expense.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.entity.ExpenseCategoryEntity;
import com.expense.entity.UserDetailsEntity;

@Repository
public interface ExpenseCategoryDao extends JpaRepository<ExpenseCategoryEntity, Long>{
	
	public List<ExpenseCategoryEntity> findByUserId(Long userId);

}
