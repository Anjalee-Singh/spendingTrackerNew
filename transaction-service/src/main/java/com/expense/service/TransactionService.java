package com.expense.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.expense.request.CategoryListRequest;
import com.expense.request.SubmitExpenseRequest;

import cm.nci.pdf.PdfDetails;

public interface TransactionService {

	List<PdfDetails> readPdfFile(MultipartFile file) throws Exception;

	void submitDetails(SubmitExpenseRequest request);

	List<String> getCategories(String firstName);

	void addNewCategory(CategoryListRequest categoryListRequest);

}
