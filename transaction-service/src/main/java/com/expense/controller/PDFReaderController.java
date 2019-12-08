package com.expense.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.expense.pdf.PdfDetails;
import com.expense.request.EditProfileRequest;
import com.expense.request.LoginForm;
import com.expense.request.PopulateExpenseDataRequest;
import com.expense.service.LoginService;
import com.expense.service.TransactionService;

@Controller
public class PDFReaderController {

	@Autowired
	TransactionService transactionService;

	@Autowired
	LoginService loginService;
	
	
	//call after file upload is done
	@PostMapping("/details")
	public String readPdf(Model model,
			@RequestParam(value = "file", required = true) MultipartFile file,
			@ModelAttribute(name = "loginForm") LoginForm loginForm)
			throws Exception {
		List<PdfDetails> displayDetailsRequest = new ArrayList<PdfDetails>();
		List<String> categoryList = transactionService.getCategories(loginForm
				.getPhoneNumber());

		displayDetailsRequest = transactionService.readPdfFile(file);

		PopulateExpenseDataRequest populateExpenseData = new PopulateExpenseDataRequest();
		populateExpenseData.setDetails(displayDetailsRequest);

		model.addAttribute("populateExpenseData", populateExpenseData);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("phoneNumber", loginForm.getPhoneNumber());

		return "details";
	}
	
	//After authentication call
	@PostMapping("/checkUser")
	public String confirm(LoginForm loginForm, Model model) {

		model.addAttribute("firstName", loginForm.getUsername());
		model.addAttribute("phoneNumber", loginForm.getPhoneNumber());
		return "fileUpload";

	}
	
	//new user sign up call
	@GetMapping(value = "/newUser")
	public String newUser() {
      return "signup";
    }

	
	//save new user after sign up
	@PostMapping(value = "/addAccount")
	public String addAccount(
			@ModelAttribute(name = "loginForm") LoginForm loginForm, Model model) {

		loginForm = loginService.saveNewUser(loginForm);
		model.addAttribute("phoneNumber", loginForm.getPhoneNumber());

		return "accountDetails";

	}
	
	//save account details after user details save
	@PostMapping(value = "/addExpenseDetails")
	public String addExpenseDetails(
			@ModelAttribute(name = "loginForm") LoginForm loginForm, Model model) {

		loginForm = loginService.saveAccoutDetils(loginForm);
		model.addAttribute("phoneNumber", loginForm.getPhoneNumber());
		model.addAttribute("firstName", loginForm.getFirstName());

		return "fileUpload";

	}

	//call after expense submission
	@PostMapping(value = "/submitUserExpenseDetails")
	public String submitUserDetails(
			@ModelAttribute(name = "populateExpenseData") PopulateExpenseDataRequest populateExpenseData,
			@RequestParam(name = "category") List<String> categories,
			Model model) throws ParseException {

		transactionService.addUserExpenseDataWithCategory(populateExpenseData,
				categories);
		
		EditProfileRequest editProfileRequest = transactionService.getBalanceAmount(populateExpenseData.getPhoneNumber());
		
		model.addAttribute("editProfileRequest", editProfileRequest);

		return "balanceViewPage";

	}
	
	//first login call
	@GetMapping("/login")
	public String login() {
		return "login";
	}


	@PostMapping("/confirm")
	public String confirm(
			@ModelAttribute(name = "phoneNumber") String phoneNumber,
			Model model) {

		model.addAttribute("phoneNumber", phoneNumber);

		return "submit";
	}
	
	//After Confirmation of Edit Call
	@PostMapping("/confirmEdit")
	public String confirmEdit(@ModelAttribute(name = "loginForm") LoginForm loginForm, Model model) {
		
	transactionService.editAccountData(loginForm);

	model.addAttribute("phoneNumber", loginForm.getPhoneNumber());
	return "submit";

	}
	
	//Call After Edit Button
	@PostMapping("/editProfile")
	public String editProfile(
			@ModelAttribute(name = "loginForm") LoginForm loginForm,
			Model model) {
		
		LoginForm loginFormFromDb = transactionService.getUserDetails(loginForm.getPhoneNumber());
		model.addAttribute("phoneNumber", loginFormFromDb.getPhoneNumber());
		model.addAttribute("firstName", loginFormFromDb.getFirstName());
		model.addAttribute("lastName", loginFormFromDb.getLastName());
		model.addAttribute("dateOfBirth", loginFormFromDb.getDateOfBirth());
		model.addAttribute("salaryMonth", loginFormFromDb.getSalaryMonth());
		model.addAttribute("salary", loginFormFromDb.getSalary());
		model.addAttribute("thresholdExpense", loginFormFromDb.getThresholdExpense());

		return "editProfilePage";
	}
	
	//logout call
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
}
