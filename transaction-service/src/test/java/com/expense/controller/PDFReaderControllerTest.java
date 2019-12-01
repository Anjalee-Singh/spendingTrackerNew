package com.expense.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.expense.request.SubmitExpenseRequest;
import com.expense.service.TransactionService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class PDFReaderControllerTest {

	@InjectMocks
	PDFReaderController pDFReaderController;

	@Mock
	TransactionService transactionService;

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
