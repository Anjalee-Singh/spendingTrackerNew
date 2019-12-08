package com.expense.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expense.entity.DateDetails;

@Repository
public interface DateDetailsDao extends JpaRepository<DateDetails, Long>{

	//boolean checkdatesArePresent;
	
	/*public DateDetails findByFromDate(String FromDate);
	public DateDetails findByTillDate(String TillDate);*/
	


}
