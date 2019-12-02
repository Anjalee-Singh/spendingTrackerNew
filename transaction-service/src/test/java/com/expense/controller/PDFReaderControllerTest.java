package com.expense.controller;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.junit.Before;

import com.expense.request.SubmitExpenseRequest;
import com.expense.service.TransactionService;

public class PDFReaderControllerTest {

	@InjectMocks
	PDFReaderController pDFReaderController;

	@Mock
	TransactionService transactionService;
	
	private MockMvc mockMvc;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(pDFReaderController).build();
	}

	@Test
	public void testReadPdf() {
		/*
		 * 
		 * 
		 * List<PdfDetails> itemList = pDFReaderController.readPdf();
		 * Assert.assertNotNull(itemList);
		 * Assert.assertNotNull(itemList.get(0).getDate());
		 */}

	@Test
	public void testSubmit() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		SubmitExpenseRequest submitExpenseRequest = new SubmitExpenseRequest();
		submitExpenseRequest.setDate("2019.05.11");
		pDFReaderController.submit(request, submitExpenseRequest);
	}
}
