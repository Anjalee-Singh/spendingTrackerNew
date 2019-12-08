package com.expense.design.factory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.expense.pdfread.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.expense.dao.ExpenseCategoryDao;
import com.expense.dao.UserDetailsDao;
import com.expense.dao.CategoryListDao;
import com.expense.dao.DateDetailsDao;
import com.expense.entity.ExpenseCategoryEntity;
import com.expense.request.CalendarDetails;

@Component
public class BarGraph implements Graph {


	@Autowired
	DateDetailsDao dateDetailsDao;
	
	@Autowired
	UserDetailsDao categoryListDao;

	@Autowired
	ExpenseCategoryDao expenseCategoryDao;
	
	@Override
	public Map<String, String> addBarData(CalendarDetails calendarDetails) throws ParseException {
		HashMap<String, String> BarMap = new HashMap<String, String>();
		{
			List<ExpenseCategoryEntity> expenseCategoryInDB = expenseCategoryDao.findAll();
			// TODO Auto-generated method stub
			String barfdate=calendarDetails.getFromDate();
			String bartdate=calendarDetails.getTillDate();//xyz.getD() 
		    Date datefrom=new SimpleDateFormat("yyyy-MM-dd").parse(barfdate);
		    Date datetill=new SimpleDateFormat("yyyy-MM-dd").parse(bartdate); 
			float max=0;
		    List<ExpenseCategoryEntity> categoriesBetweenDates = new ArrayList<>();
			for (ExpenseCategoryEntity expenseCategoryEntity : expenseCategoryInDB) {
				if (expenseCategoryEntity.getDate().compareTo(datefrom) >= 0
						&& expenseCategoryEntity.getDate().compareTo(datetill) <= 0) {
				
					addValueInMap(BarMap, "clothes", expenseCategoryEntity.getClothes());
					addValueInMap(BarMap, "eatingOut", expenseCategoryEntity.getEatingOut());
					addValueInMap(BarMap, "entertainment", expenseCategoryEntity.getEntertainment());
					addValueInMap(BarMap, "fuel", expenseCategoryEntity.getFuel());
					addValueInMap(BarMap, "grocery", expenseCategoryEntity.getGrocery());
					addValueInMap(BarMap, "householdItems", expenseCategoryEntity.getHouseholdItems());
					addValueInMap(BarMap, "gifts", expenseCategoryEntity.getGifts());
					addValueInMap(BarMap, "holidays", expenseCategoryEntity.getHolidays());
					addValueInMap(BarMap, "kids", expenseCategoryEntity.getKids());
					addValueInMap(BarMap, "shopping", expenseCategoryEntity.getShopping());
					addValueInMap(BarMap, "sports", expenseCategoryEntity.getSports());
					addValueInMap(BarMap, "travel", expenseCategoryEntity.getTravel());
					addValueInMap(BarMap, "bills", expenseCategoryEntity.getBills());
					addValueInMap(BarMap, "cash", expenseCategoryEntity.getCash());
				}
				
				/*for (String name : BarMap.keySet()) {
					String key = name.toString();
					String value = BarMap.get(name).toString();
					System.out.println(key + " " + value);
				}// List<String> category = categoryList.getCategory();
*/			}
			
			System.out.println("Generating the bar graph from "+datefrom+" to "+datetill);
			SortDataUtil sc = new SortDataUtil();
			sc.sortByValues(BarMap);
			return BarMap;
		}
	};
	
	private void addValueInMap(Map<String, String> map, String key, String cost) {
		if (cost == null) return;

		Double doubleCost = Double.parseDouble(cost);
		if (map.containsKey(key)) {
			map.put(key, String.valueOf(Double.parseDouble(map.get(key).trim()) + doubleCost));
		} else {
			map.put(key, cost);
		}
		//List<String> list = (List<String>) map.values();
		//list.sort((Double Double.parseDouble(o1),Double Double.parseDouble(o1)));
	}

	@Override
	public Map<String, String> addPieData(CalendarDetails calendarDetails) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}
	
}