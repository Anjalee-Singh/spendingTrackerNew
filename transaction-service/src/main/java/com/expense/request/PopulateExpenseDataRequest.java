package com.expense.request;

import java.util.List;

import com.expense.pdf.PdfDetails;

public class PopulateExpenseDataRequest {
	
	private List<PdfDetails> details;

	private String otherAmount;
	
	private String otherCategory;
	
	private String otherDate;
	
	private String phoneNumber;
	
	 public void addDetail(PdfDetails detail) {
	        this.details.add(detail);
	    }

	public List<PdfDetails> getDetails() {
		return details;
	}

	public void setDetails(List<PdfDetails> details) {
		this.details = details;
	}

	public String getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(String otherAmount) {
		this.otherAmount = otherAmount;
	}

	public String getOtherCategory() {
		return otherCategory;
	}

	public void setOtherCategory(String otherCategory) {
		this.otherCategory = otherCategory;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOtherDate() {
		return otherDate;
	}

	public void setOtherDate(String otherDate) {
		this.otherDate = otherDate;
	}
	
	

	
}
