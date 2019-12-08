package com.expense.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.expense.pdf.PdfDetails;
import com.expense.request.EditProfileRequest;
import com.expense.request.LoginForm;
import com.expense.request.PopulateExpenseDataRequest;

public interface TransactionService {

	List<PdfDetails> readPdfFile(MultipartFile file) throws Exception;

	List<String> getCategories(String firstName);

	void addUserExpenseDataWithCategory(
			PopulateExpenseDataRequest populateExpenseData,List<String> categories) throws ParseException ;
	
	
    LoginForm getUserDetails(String phoneNumber);

    EditProfileRequest getBalanceAmount(String phoneNumber);
    
    void editAccountData(LoginForm loginForm);
}
