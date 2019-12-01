package com.expense.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	UserDao findByUsername(String username);

}