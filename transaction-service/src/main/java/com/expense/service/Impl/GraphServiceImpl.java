package com.expense.service.Impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.dao.DateDetailsDao;
import com.expense.dao.ExpenseCategoryDao;
import com.expense.dao.UserDetailsDao;
import com.expense.design.factory.PieGraph;
import com.expense.design.factory.Graph;
import com.expense.design.factory.GraphFactory;
import com.expense.entity.CategoryListEntity;
import com.expense.entity.ExpenseCategoryEntity;
import com.expense.entity.DateDetails;
import com.expense.entity.UserDetailsEntity;
import com.expense.request.CalendarDetails;
import com.expense.service.GraphService;

@Service
public class GraphServiceImpl implements GraphService {

	@Autowired
	DateDetailsDao dateDetailsDao;
	UserDetailsDao userDetailsDao;

	@Autowired
	UserDetailsDao categoryListDao;

	@Autowired
	ExpenseCategoryDao expenseCategoryDao;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	GraphFactory graphFactory;
	
	
	public Map<String, String> getCategoryMap(CalendarDetails calendarDetails) throws ParseException {
	
		Graph gph = graphFactory.getGraph("PieGraph");
		Graph gph1 = graphFactory.getGraph("BarGraph");
		gph1.addBarData(calendarDetails);
		return gph.addPieData(calendarDetails);		
	};

	public void addValueInMap(Map<String, String> map, String key, String cost) {
		if (cost == null) return;

		Double doubleCost = Double.parseDouble(cost);
		if (map.containsKey(key)) {
			map.put(key, String.valueOf(Double.parseDouble(map.get(key).trim()) + doubleCost));
		} else {
			map.put(key, cost);
		}
	}

	public DateDetails findbyDates(DateDetails dateDetails) // entity
	{

		return dateDetails;
	}

	/*
	 * @Override public int count() { return jdbcTemplate
	 * .queryForObject("select count(*) from nci01.expense_category c \r\n" +
	 * "where c.date_of_transaction \r\n" +
	 * "between '2019-12-21' and '2019-12-29';", Integer.class); }
	 */

	/*
	 * @Override public List<String> getCategories(String fromDate, String tillDate)
	 * { // TODO Auto-generated method stub return null; }
	 */

	/*
	 * @Override public List<String> getCategory(List categorystuff) { TODO
	 * Auto-generated method stub return null; }
	 */

	/*
	 * @Override public int count() { TODO Auto-generated method stub return 0; }
	 */

	// @Override

	/*
	 * @Override public int count() { // TODO Auto-generated method stub return 0; }
	 */

}