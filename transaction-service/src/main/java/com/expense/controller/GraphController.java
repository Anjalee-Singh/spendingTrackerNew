package com.expense.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.expense.request.CalendarDetails;
//import com.expense.service.GraphService;
import com.expense.request.PopulateExpenseDataRequest;
import com.expense.service.GraphService;
import com.expense.service.TransactionService;



@Controller
public class GraphController {

	@Autowired
	GraphService graphService;
	@Autowired
	TransactionService transactionService;

	
	@RequestMapping(value = "/submitUserDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String submitUserDetails(
			@ModelAttribute(value = "calendarDetails") CalendarDetails calendarDetails,
	        Model model) throws ParseException {

		
		model.addAttribute("calendarDetails", calendarDetails);

		return "displayCalendar";

	}

	@RequestMapping(value = "/displayGraph", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String displayGraph(
			// @ModelAttribute(name = "populateExpenseData") PopulateExpenseDataRequest
			// populateExpenseData,
			@ModelAttribute(value = "calendarDetails") CalendarDetails calendarDetails,

			Model model) throws ParseException {

		Map<String, String> categoryMapController = new HashMap<String, String>();
		Map<String, String> categoryMapList = graphService.getCategoryMap(calendarDetails);

		model.addAttribute("fetchCategoryMap", categoryMapList);

		/*for (String name : categoryMapList.keySet()) {
			String key = name.toString();
			String value = categoryMapList.get(name).toString();
			System.out.println(key + " " + value);
		}*/

		return "displayGraph";

	}
	
	

}
