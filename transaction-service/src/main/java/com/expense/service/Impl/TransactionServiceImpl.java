package com.expense.service.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.expense.dao.AccountDetailsDao;
import com.expense.dao.CategoryListDao;
import com.expense.dao.ExpenseCategoryDao;
import com.expense.dao.UserDetailsDao;
import com.expense.entity.AccountDetailsEntity;
import com.expense.entity.CategoryListEntity;
import com.expense.entity.ExpenseCategoryEntity;
import com.expense.entity.UserDetailsEntity;
import com.expense.pdf.PdfDetails;
import com.expense.pdfread.util.PdfTableReadUtil;
import com.expense.request.EditProfileRequest;
import com.expense.request.LoginForm;
import com.expense.request.PopulateExpenseDataRequest;
import com.expense.service.TransactionService;

/**
 * @author Anjalee
 *
 */

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	CategoryListDao categoryListDao;

	@Autowired
	UserDetailsDao userDetailsDao;

	@Autowired
	ExpenseCategoryDao expenseCategoryDao;

	@Autowired
	AccountDetailsDao accountDetailsDao;

	SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	SimpleDateFormat formatterForCategory = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	public List<PdfDetails> readPdfFile(MultipartFile file) throws Exception {

		List<PdfDetails> itemList = PdfTableReadUtil.readPdfFile(file);
		return itemList;
	}

	@Override
	public List<String> getCategories(String phoneNumber) {

		UserDetailsEntity userdetailsInDB = userDetailsDao
				.findByPhoneNumber(phoneNumber);
		CategoryListEntity categoryList = categoryListDao
				.findByUserDetailsId(userdetailsInDB.getId());

		List<String> category = categoryList.getCategory();
		return category;
	}

	@Override
	public LoginForm getUserDetails(String phoneNumber) {
		UserDetailsEntity userdetailsInDB = userDetailsDao
				.findByPhoneNumber(phoneNumber);

		LoginForm loginForm = new LoginForm();
		loginForm.setDateOfBirth(formatter.format(userdetailsInDB
				.getDateOfBirth()));
		loginForm.setFirstName(userdetailsInDB.getFirstName());
		loginForm.setLastName(userdetailsInDB.getLastName());
		loginForm.setPhoneNumber(phoneNumber);

		AccountDetailsEntity accDetailsDb = accountDetailsDao
				.findByUserDetailsId(userdetailsInDB.getId());
		loginForm.setSalary(accDetailsDb.getSalary());
		loginForm.setSalaryMonth(accDetailsDb.getMonth());
		loginForm.setThresholdExpense(accDetailsDb.getThresholdExpense());

		return loginForm;
	}

	@Override
	public void editAccountData(LoginForm loginForm) {
		UserDetailsEntity userdetailsInDB = userDetailsDao
				.findByPhoneNumber(loginForm.getPhoneNumber());

		AccountDetailsEntity accountDetails = accountDetailsDao
				.findByUserDetailsId(userdetailsInDB.getId());
		accountDetails.setMonth(loginForm.getSalaryMonth());
		accountDetails.setSalary(loginForm.getSalary());
		accountDetails.setThresholdExpense(loginForm.getThresholdExpense());
		accountDetails.setYear(Calendar.getInstance().get(Calendar.YEAR));
		accountDetailsDao.save(accountDetails);

	}

	@Override
	public EditProfileRequest getBalanceAmount(String phoneNumber) {

		EditProfileRequest editProfileRequest = new EditProfileRequest();

		Double balanceAmount = 0.0;
		Double sum = 0.0;

		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);

		Integer month = cal.get(Calendar.MONTH);
		Integer year = cal.get(Calendar.YEAR);

		UserDetailsEntity userdetailsInDB = userDetailsDao
				.findByPhoneNumber(phoneNumber);

		AccountDetailsEntity accDetailsDb = accountDetailsDao
				.findByUserDetailsId(userdetailsInDB.getId());

		editProfileRequest.setThresholdExpense(Double.valueOf(accDetailsDb
				.getThresholdExpense()));
		editProfileRequest.setSalary(Double.valueOf(accDetailsDb.getSalary()));

		List<ExpenseCategoryEntity> expenseCategoriesPresent = expenseCategoryDao
				.findByUserId(userdetailsInDB.getId());

		for (ExpenseCategoryEntity expenseCategoryEntity : expenseCategoriesPresent) {

			cal.setTime(expenseCategoryEntity.getDate());
			Integer yearFromDb = cal.get(Calendar.YEAR);
			Integer monthFromDb = cal.get(Calendar.MONTH);

			if (yearFromDb.equals(year) && monthFromDb.equals(month)) {
				sum = sum
						+ addOnlyIfNotNull(expenseCategoryEntity.getBills())
						+ addOnlyIfNotNull(expenseCategoryEntity.getCash())
						+ addOnlyIfNotNull(expenseCategoryEntity.getClothes())
						+ addOnlyIfNotNull(expenseCategoryEntity.getEatingOut())
						+ addOnlyIfNotNull(expenseCategoryEntity
								.getEntertainment())
						+ addOnlyIfNotNull(expenseCategoryEntity.getFuel())
						+ addOnlyIfNotNull(expenseCategoryEntity.getGifts())
						+ addOnlyIfNotNull(expenseCategoryEntity.getGrocery())
						+ addOnlyIfNotNull(expenseCategoryEntity.getHolidays())
						+ addOnlyIfNotNull(expenseCategoryEntity
								.getHouseholdItems())
						+ addOnlyIfNotNull(expenseCategoryEntity.getKids())
						+ addOnlyIfNotNull(expenseCategoryEntity.getShopping())
						+ addOnlyIfNotNull(expenseCategoryEntity.getSports())
						+ addOnlyIfNotNull(expenseCategoryEntity.getTravel());

			}

		}

		balanceAmount = Integer.parseInt(accDetailsDb.getThresholdExpense())
				- sum;

		if (balanceAmount <= Integer.parseInt(accDetailsDb
				.getThresholdExpense())) {
			accDetailsDb.registerObserver(userdetailsInDB);
			editProfileRequest.setThreshold(accDetailsDb.notifyObservers(true));

		}

		editProfileRequest.setBalanceAmount(balanceAmount);
		return editProfileRequest;
	}

	private Double addOnlyIfNotNull(String str) {
		Double add = 0.0;
		if (null != str) {
			add = add + Double.parseDouble(str.trim());
		}
		return add;

	}

	@Override
	public void addUserExpenseDataWithCategory(
			PopulateExpenseDataRequest populateExpenseData,
			List<String> categories) throws ParseException {

		UserDetailsEntity userdetailsInDB = userDetailsDao
				.findByPhoneNumber(populateExpenseData.getPhoneNumber());

		List<PdfDetails> detailsFromPdf = populateExpenseData.getDetails();
		Iterator<PdfDetails> pdfIterator = detailsFromPdf.iterator();
		Iterator<String> categoryIterator = categories.iterator();

		while (pdfIterator.hasNext() && categoryIterator.hasNext()) {
			PdfDetails item = pdfIterator.next();
			item.setDescription(categoryIterator.next());
		}

		addOtherCategory(populateExpenseData, userdetailsInDB);
		Map<Date, List<PdfDetails>> pdfMap = new HashMap<>();
		for (PdfDetails pdfDetails : detailsFromPdf) {

			Date key = formatter.parse(pdfDetails.getDate());

			pdfMap.computeIfAbsent(key, k -> new ArrayList<>()).add(pdfDetails);
		}
		for (Map.Entry<Date, List<PdfDetails>> entry : pdfMap.entrySet()) {
			ExpenseCategoryEntity expenseCategoryEntity = new ExpenseCategoryEntity();
			expenseCategoryEntity.setUserId(userdetailsInDB.getId());
			expenseCategoryEntity.setDate(entry.getKey());

			List<PdfDetails> pdfDetailsList = entry.getValue();

			Map<String, Double> descriptionMap = new HashMap<>();

			pdfDetailsList.forEach(k -> {
				String desccrip = k.getDescription();
				Double amount = Double.parseDouble(k.getAmount());
				descriptionMap.merge(desccrip, amount, Double::sum);
/*
				if ("Clothes".equalsIgnoreCase(desccrip)) {
					expenseCategoryEntity.setClothes(descriptionMap.get(
							desccrip).toString());
					System.out.println(expenseCategoryEntity);
				}*/

				switch (desccrip) {
				case "Clothes":
					expenseCategoryEntity.setClothes(descriptionMap.get(
							desccrip).toString());
					expenseCategoryDao.save(expenseCategoryEntity);
					break;
				case "Eating Out":
					expenseCategoryEntity.setEatingOut(descriptionMap.get(
							desccrip).toString());
					expenseCategoryDao.save(expenseCategoryEntity);
					break;
				case "Entertainment":
					expenseCategoryEntity.setEntertainment(descriptionMap.get(
							desccrip).toString());
					expenseCategoryDao.save(expenseCategoryEntity);
					break;
				case "Fuel":
					expenseCategoryEntity.setFuel(descriptionMap.get(
							desccrip).toString());
					expenseCategoryDao.save(expenseCategoryEntity);					
					break;
				case "Grocery":
					expenseCategoryEntity.setGrocery(descriptionMap.get(
							desccrip).toString());
					expenseCategoryDao.save(expenseCategoryEntity);	
					break;
				case "Household Items":
					expenseCategoryEntity.setHouseholdItems(descriptionMap.get(
							desccrip).toString());
					expenseCategoryDao.save(expenseCategoryEntity);	
					break;
				case "Gifts":
					expenseCategoryEntity.setGifts(descriptionMap.get(
							desccrip).toString());
					expenseCategoryDao.save(expenseCategoryEntity);	
					break;
				case "Holidays":
					expenseCategoryEntity.setHolidays(descriptionMap.get(
							desccrip).toString());
					expenseCategoryDao.save(expenseCategoryEntity);	
					break;
				case "Kids":
					expenseCategoryEntity.setKids(descriptionMap.get(
							desccrip).toString());
					expenseCategoryDao.save(expenseCategoryEntity);	
					break;
				case "Shopping":
					expenseCategoryEntity.setShopping(descriptionMap.get(
							desccrip).toString());
					expenseCategoryDao.save(expenseCategoryEntity);	
					break;
				case "Sports":
					expenseCategoryEntity.setSports(descriptionMap.get(
							desccrip).toString());
					expenseCategoryDao.save(expenseCategoryEntity);	
					break;
				case "Travel":
					expenseCategoryEntity.setTravel(descriptionMap.get(
							desccrip).toString());
					expenseCategoryDao.save(expenseCategoryEntity);	
					break;
				case "Bills":
					expenseCategoryEntity.setBills(descriptionMap.get(
							desccrip).toString());
					expenseCategoryDao.save(expenseCategoryEntity);	
					break;

				}

			});

			expenseCategoryDao.save(expenseCategoryEntity);
		}

	

	}

	private void addOtherCategory(
			PopulateExpenseDataRequest populateExpenseData,
			UserDetailsEntity userdetailsInDB) throws ParseException {
		if (null != populateExpenseData.getOtherCategory()
				&& !populateExpenseData.getOtherCategory().isEmpty()) {
			String string = populateExpenseData.getOtherCategory() + ":"
					+ populateExpenseData.getOtherAmount();
			ExpenseCategoryEntity expenseCategoryEntity = new ExpenseCategoryEntity();
			expenseCategoryEntity.setDate(formatterForCategory
					.parse(populateExpenseData.getOtherDate()));
			expenseCategoryEntity.setCategory(string);
			expenseCategoryDao.save(expenseCategoryEntity);

			CategoryListEntity categoryList = categoryListDao
					.findByUserDetailsId(userdetailsInDB.getId());

			List<String> categoryFromDb = categoryList.getCategory();

			List<String> oldCategoryList = new ArrayList<>(categoryFromDb);
			oldCategoryList.add(populateExpenseData.getOtherCategory());

			categoryList.setCategory(oldCategoryList);
			categoryListDao.save(categoryList);
		}
	}

	private boolean checkIfDatesAreEqual(Date date, String date2)
			throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		Calendar dateFromUI = Calendar.getInstance();
		dateFromUI.setTime(formatter.parse(date2));

		return calendar.equals(dateFromUI);
	}

}
