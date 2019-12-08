package com.expense.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expense.request.CalendarDetails;
import com.expense.service.GraphService;
import com.expense.service.TransactionService;

@RestController
public class GraphRestController {

	@Autowired
	GraphService graphService;
	@Autowired
	TransactionService transactionService;


	@RequestMapping(value = "/displayGraphCalendar", method = RequestMethod.GET, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Map<String, String> displayGraph(
			// @ModelAttribute(name = "populateExpenseData") PopulateExpenseDataRequest
			// populateExpenseData,
			@ModelAttribute(value = "calendarDetails") CalendarDetails calendarDetails,

			Model model) throws ParseException {

		Map<String, String> categoryMapController = new HashMap<String, String>();
		Map<String, String> categoryMapList = graphService.getCategoryMap(calendarDetails);


		for (String name : categoryMapList.keySet()) {
			String key = name.toString();
			String value = categoryMapList.get(name).toString();
			System.out.println(key + " " + value);
		}

		return categoryMapList;
	}

}
