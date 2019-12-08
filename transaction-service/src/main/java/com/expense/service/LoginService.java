package com.expense.service;

import com.expense.request.LoginForm;

public interface LoginService {

	
	String userIsPresent(LoginForm loginRequest);
	LoginForm saveNewUser(LoginForm loginForm);
	LoginForm saveAccoutDetils(LoginForm loginForm);
}
