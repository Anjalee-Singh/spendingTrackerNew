package com.expense.design.factory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.expense.pdfread.util.SortDataUtil;
import org.springframework.beans.factory.annotation.Autowired;

import com.expense.dao.ExpenseCategoryDao;
import com.expense.dao.UserDetailsDao;
import com.expense.dao.CategoryListDao;

import com.expense.entity.ExpenseCategoryEntity;

import com.expense.request.CalendarDetails;


public interface Graph {

	public Map<String, String> addPieData(CalendarDetails calendarDetails) throws ParseException;

	public Map<String, String> addBarData(CalendarDetails calendarDetails) throws ParseException;
}
