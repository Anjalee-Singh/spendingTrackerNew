package com.expense.request;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


public class CalendarDetails {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String fromDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String tillDate;

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getTillDate() {
		return tillDate;
	}

	public void setTillDate(String tillDate) {
		this.tillDate = tillDate;
	}


	

}