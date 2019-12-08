package com.expense.service;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.expense.request.CalendarDetails;

public interface GraphService {

	Map getCategoryMap(CalendarDetails calendarDetails) throws ParseException;

	//boolean dateIsPresent(CalendarDetails graphservice);

	//List<String> getCategory();

	//List<String> getCategory(List categorystuff);

	//int count();

	//List<String> getCategories(String fromDate, String tillDate);

	//List<String> getCategories(Date date);

	
	//boolean monthIsPresent();
	/*void saveNewUser(LoginForm loginForm);*/
}
