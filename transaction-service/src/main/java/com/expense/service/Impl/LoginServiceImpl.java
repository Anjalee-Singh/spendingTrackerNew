package com.expense.service.Impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.expense.dao.AccountDetailsDao;
import com.expense.dao.CategoryListDao;
import com.expense.dao.UserDetailsDao;
import com.expense.entity.AccountDetailsEntity;
import com.expense.entity.CategoryListEntity;
import com.expense.entity.UserDetailsEntity;
import com.expense.request.LoginForm;
import com.expense.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserDetailsDao userDetailsDao;
	
	@Autowired
	AccountDetailsDao accountDetailsDao;
	
	@Autowired
	CategoryListDao categoryListDao;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public String userIsPresent(LoginForm loginRequest) {

		UserDetailsEntity userdetailsInDB =userDetailsDao.findByPhoneNumber(loginRequest.getPhoneNumber());
		
		if (null != userdetailsInDB) {
			return userdetailsInDB.getFirstName();
		}else
		
		return null;
	}

	@Override
	public LoginForm saveNewUser(LoginForm loginForm) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dateStr = null;
		try {
			dateStr = formatter.parse(loginForm.getDateOfBirth());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
		
		UserDetailsEntity userDetails = new UserDetailsEntity();
		  userDetails.setFirstName(loginForm.getFirstName());
		  userDetails.setLastName(loginForm.getLastName());
		  userDetails.setDateOfBirth(dateDB);
		  userDetails.setPdfPassword(bcryptEncoder.encode(loginForm.getPassword()));
		  userDetails.setPhoneNumber(loginForm.getPhoneNumber());
		  userDetails.setCreatedOn(new Timestamp(new Date().getTime()));
		userDetailsDao.save(userDetails);
		
		LoginForm loginFormforUi = new LoginForm();
		loginFormforUi.setPhoneNumber(userDetails.getPhoneNumber());
		return loginFormforUi;
		
	}

	@Override
	public LoginForm saveAccoutDetils(LoginForm loginForm) {
		
		UserDetailsEntity userDetails = userDetailsDao.findByPhoneNumber(loginForm.getPhoneNumber());

		AccountDetailsEntity accountDetails = new AccountDetailsEntity();
		accountDetails.setUserDetails(userDetails);
		accountDetails.setMonth(loginForm.getSalaryMonth());
		accountDetails.setSalary(loginForm.getSalary());
		accountDetails.setThresholdExpense(loginForm.getThresholdExpense());
		accountDetails.setYear(Calendar.getInstance().get(Calendar.YEAR));
		accountDetailsDao.save(accountDetails);
		
		CategoryListEntity categoryList = new CategoryListEntity();
		categoryList.setUserDetails(userDetails);
		List<String> category = new ArrayList<String>();
		category.add("Clothes");
		category.add("Eating Out");
		category.add("Entertainment");
		category.add("Fuel");
		category.add("Grocery");
		category.add("Household Items");
		category.add("Gifts");
		category.add("Holidays");
		category.add("Kids");
		category.add("Shopping");
		category.add("Sports");
		category.add("Travel");
		category.add("Bills");
		categoryList.setCategory(category);
		categoryListDao.save(categoryList);
		
		LoginForm loginFormforUi = new LoginForm();
		loginFormforUi.setPhoneNumber(loginForm.getPhoneNumber());
		return loginFormforUi;
	}

}
