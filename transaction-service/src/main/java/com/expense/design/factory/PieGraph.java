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
import org.springframework.stereotype.Component;

import com.expense.dao.ExpenseCategoryDao;
import com.expense.dao.UserDetailsDao;
import com.expense.dao.CategoryListDao;
import com.expense.dao.DateDetailsDao;
import com.expense.entity.ExpenseCategoryEntity;
import com.expense.request.CalendarDetails;

@Component
public class PieGraph implements Graph {

	@Autowired
	DateDetailsDao dateDetailsDao;


	@Autowired
	UserDetailsDao categoryListDao;

	@Autowired
	ExpenseCategoryDao expenseCategoryDao;
	
	@Override
	public Map<String, String> addPieData(CalendarDetails calendarDetails) throws ParseException {
		Map<String, String> PieMap = new HashMap<String, String>();
		{
			List<ExpenseCategoryEntity> expenseCategoryInDB = expenseCategoryDao.findAll();
			// TODO Auto-generated method stub
			String piefdate=calendarDetails.getFromDate();
			String pietdate=calendarDetails.getTillDate();//xyz.getD() 
		    Date datefrom=new SimpleDateFormat("yyyy-MM-dd").parse(piefdate);
		    Date datetill=new SimpleDateFormat("yyyy-MM-dd").parse(pietdate); 
			
		    List<ExpenseCategoryEntity> categoriesBetweenDates = new ArrayList<>();
			for (ExpenseCategoryEntity expenseCategoryEntity : expenseCategoryInDB) {
				if (expenseCategoryEntity.getDate().compareTo(datefrom) >= 0
						&& expenseCategoryEntity.getDate().compareTo(datetill) <= 0) {
					addValueInMap(PieMap, "clothes", expenseCategoryEntity.getClothes());
					addValueInMap(PieMap, "eatingOut", expenseCategoryEntity.getEatingOut());
					addValueInMap(PieMap, "entertainment", expenseCategoryEntity.getEntertainment());
					addValueInMap(PieMap, "fuel", expenseCategoryEntity.getFuel());
					addValueInMap(PieMap, "grocery", expenseCategoryEntity.getGrocery());
					addValueInMap(PieMap, "householdItems", expenseCategoryEntity.getHouseholdItems());
					addValueInMap(PieMap, "gifts", expenseCategoryEntity.getGifts());
					addValueInMap(PieMap, "holidays", expenseCategoryEntity.getHolidays());
					addValueInMap(PieMap, "kids", expenseCategoryEntity.getKids());
					addValueInMap(PieMap, "shopping", expenseCategoryEntity.getShopping());
					addValueInMap(PieMap, "sports", expenseCategoryEntity.getSports());
					addValueInMap(PieMap, "travel", expenseCategoryEntity.getTravel());
					addValueInMap(PieMap, "bills", expenseCategoryEntity.getBills());
					addValueInMap(PieMap, "cash", expenseCategoryEntity.getCash());
				}
				// List<String> category = categoryList.getCategory();
			}
			System.out.println("Generating the pie graph from "+datefrom+" to "+datetill);
			for (String name : PieMap.keySet()) {
				String key = name.toString();
				String value = PieMap.get(name).toString();
				System.out.println(key + " " + value);
			}
			return PieMap;
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
	}

	@Override
	public Map<String, String> addBarData(CalendarDetails calendarDetails) throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}