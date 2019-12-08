package com.expense.controller;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import com.expense.request.EditProfileRequest;
import com.expense.request.LoginForm;
import com.expense.request.PopulateExpenseDataRequest;
import com.expense.service.Impl.LoginServiceImpl;
import com.expense.service.Impl.TransactionServiceImpl;
import com.mysql.fabric.xmlrpc.base.Array;




@RunWith(MockitoJUnitRunner.class)
public class PDFReaderControllerTest {

	@InjectMocks
	PDFReaderController pDFReaderController;

	@Mock
	TransactionServiceImpl transactionService;
	
	@Mock
	LoginServiceImpl loginService;
	
	private MockMvc mockMvc;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(pDFReaderController).build();
		//loginService = mock(LoginServiceImpl.class);
	}

	@Test
	public void checkUserTest() throws Exception {
		LoginForm loginForm =  new LoginForm();
		this.mockMvc.perform(MockMvcRequestBuilders.post("/checkUser")
                .requestAttr("loginForm", loginForm).contentType("application/json")
				.accept("application/json").header("Authorization", "headerValue"));
	}

	
	
	@Test
	public void addAccountTest() throws Exception {
		LoginForm loginForm =  new LoginForm();
		Mockito.when(loginService.saveNewUser(Mockito.any(LoginForm.class))).thenReturn(loginForm);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/addAccount").contentType("application/json").requestAttr("loginForm", loginForm)
				.accept("application/json").header("Authorization", "headerValue"));
	}

	@Test
	public void addExpenseDetailsTest() throws Exception {
		LoginForm loginForm =  new LoginForm();
		Mockito.when(loginService.saveAccoutDetils(Mockito.any(LoginForm.class))).thenReturn(loginForm);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/addExpenseDetails").contentType("application/json").requestAttr("loginForm", loginForm)
				.accept("application/json").header("Authorization", "headerValue"));
	}

	@Test
	public void submitUserExpenseDetailsTest() throws Exception {
		EditProfileRequest editProfileRequest =  new EditProfileRequest();
		PopulateExpenseDataRequest populateExpenseData = new PopulateExpenseDataRequest();
		List<String> category = new ArrayList<>();
		category.add("abc");
		//Mockito.when(transactionService.getBalanceAmount(Mockito.any(String.class))).thenReturn(editProfileRequest);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/submitUserExpenseDetails").contentType("application/json")
				.flashAttr("populateExpenseData", populateExpenseData).flashAttr("category", category).accept("application/json").header("Authorization", "headerValue"));
	}
	
	@Test
	public void detailsTest() throws Exception {
		 MockMultipartFile file = new MockMultipartFile("data", "filename.txt", "text/plain", "some xml".getBytes());
		List<String> category = new ArrayList<>();
		category.add("abc");
		this.mockMvc.perform(MockMvcRequestBuilders.multipart("/details")
				.file(file).flashAttr("category", category).accept("application/json").header("Authorization", "headerValue"));
	}

	
	@Test
	public void editProfileTest() throws Exception {
		LoginForm loginForm =  new LoginForm();
		loginForm.setDateOfBirth("12-03-1990");
		loginForm.setFirstName("firstName");
		loginForm.setLastName("lastName");
		loginForm.setPhoneNumber("0899735515");
		loginForm.setSalary("100");
		loginForm.setSalaryMonth("June");
		loginForm.setThresholdExpense("50");
		Mockito.when(transactionService.getUserDetails(Mockito.any(String.class))).thenReturn(loginForm);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/editProfile").contentType("application/json").flashAttr("loginForm", loginForm).accept("application/json").header("Authorization", "headerValue"));
	}
	
	
	
	@Test
	public void newUserTest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/newUser").header("Authorization", "headerValue"));
	}
	

	@Test
	public void confirmEditTest() throws Exception {
		LoginForm loginForm =  new LoginForm();
		loginForm.setDateOfBirth("12-03-1990");
		loginForm.setFirstName("firstName");
		loginForm.setLastName("lastName");
		loginForm.setPhoneNumber("0899735515");
		loginForm.setSalary("100");
		loginForm.setSalaryMonth("June");
		loginForm.setThresholdExpense("50");
		this.mockMvc.perform(MockMvcRequestBuilders.post("/confirmEdit").flashAttr("loginForm", loginForm).contentType("application/json").accept("application/json").header("Authorization", "headerValue"));
	}
	
	@Test
	public void confirmTest() throws Exception {
		String phoneNumber = "0897655444";
		this.mockMvc.perform(MockMvcRequestBuilders.post("/confirm").flashAttr("phoneNumber", phoneNumber).contentType("application/json").accept("application/json").header("Authorization", "headerValue"));
	}
	
}