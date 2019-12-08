package com.expense.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "expenseCategory" ,schema="nci01")
public class ExpenseCategoryEntity implements Serializable{

	
	private static final long serialVersionUID = 1177567915274607012L;
	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "clothes")
	private String clothes;
	
	@Column(name = "eatingOut")
	private String eatingOut;
	@Column(name = "entertainment")
	private String entertainment;
	@Column(name = "fuel")
	private String fuel;
	@Column(name = "grocery")
	private String grocery;
	@Column(name = "householdItems")
	private String householdItems;
	@Column(name = "gifts")
	private String gifts;
	@Column(name = "holidays")
	private String holidays;
	@Column(name = "kids")
	private String kids;
	@Column(name = "shopping")
	private String shopping;
	@Column(name = "sports")
	private String sports;
	@Column(name = "travel")
	private String travel;
	@Column(name = "bills")
	private String bills;
	@Column(name = "cash")
	private String cash;
	
	@Column(name = "category")
	//@Convert(converter = StringListConverter.class)
	private String category;
	@Column(name = "date_of_transaction")
	private Date date;
	
	@Column(name = "userId")
	private Long userId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClothes() {
		return clothes;
	}
	public void setClothes(String clothes) {
		this.clothes = clothes;
	}
	public String getEatingOut() {
		return eatingOut;
	}
	public void setEatingOut(String eatingOut) {
		this.eatingOut = eatingOut;
	}
	public String getEntertainment() {
		return entertainment;
	}
	public void setEntertainment(String entertainment) {
		this.entertainment = entertainment;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getGrocery() {
		return grocery;
	}
	public void setGrocery(String grocery) {
		this.grocery = grocery;
	}
	public String getHouseholdItems() {
		return householdItems;
	}
	public void setHouseholdItems(String householdItems) {
		this.householdItems = householdItems;
	}
	public String getGifts() {
		return gifts;
	}
	public void setGifts(String gifts) {
		this.gifts = gifts;
	}
	public String getHolidays() {
		return holidays;
	}
	public void setHolidays(String holidays) {
		this.holidays = holidays;
	}
	public String getKids() {
		return kids;
	}
	public void setKids(String kids) {
		this.kids = kids;
	}
	public String getShopping() {
		return shopping;
	}
	public void setShopping(String shopping) {
		this.shopping = shopping;
	}
	public String getSports() {
		return sports;
	}
	public void setSports(String sports) {
		this.sports = sports;
	}
	public String getTravel() {
		return travel;
	}
	public void setTravel(String travel) {
		this.travel = travel;
	}
	public String getBills() {
		return bills;
	}
	public void setBills(String bills) {
		this.bills = bills;
	}
	public String getCash() {
		return cash;
	}
	public void setCash(String cash) {
		this.cash = cash;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "ExpenseCategoryEntity [id=" + id + ", clothes=" + clothes
				+ ", eatingOut=" + eatingOut + ", entertainment="
				+ entertainment + ", fuel=" + fuel + ", grocery=" + grocery
				+ ", householdItems=" + householdItems + ", gifts=" + gifts
				+ ", holidays=" + holidays + ", kids=" + kids + ", shopping="
				+ shopping + ", sports=" + sports + ", travel=" + travel
				+ ", bills=" + bills + ", cash=" + cash + ", category="
				+ category + ", date=" + date + ", userId=" + userId + "]";
	}

	
	
	
}