package com.expense.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.entity.CategoryListEntity;
import com.expense.entity.UserDetailsEntity;

@Repository
public interface CategoryListDao extends JpaRepository<CategoryListEntity, Long>{
	
	public CategoryListEntity findByUserDetailsId(Long id);

}
