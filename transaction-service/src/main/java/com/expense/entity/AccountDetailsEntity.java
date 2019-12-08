package com.expense.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.message.Message;

import com.expense.design.observer.Observer;
import com.expense.design.observer.Subject;

@Entity
@Table(name = "AccountDetails" ,schema="nci01")
public class AccountDetailsEntity implements Serializable,Subject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1384368707692197314L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "month_of_transaction")
	private String month;
	
	@NotNull
	@Column(name = "year")
	private Integer year;
	
	@NotNull
	@Column(name = "salary")
	private String salary;
	
	@NotNull
	@Column(name = "threshold_expense")
	private String thresholdExpense;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@NotNull
    private UserDetailsEntity userDetails;
	
	private static ArrayList<Observer> observers = new ArrayList<Observer>();
	
		
	public AccountDetailsEntity() {}
	 
    

	public Long getId() {
		return id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getThresholdExpense() {
		return thresholdExpense;
	}

	public void setThresholdExpense(String thresholdExpense) {
		this.thresholdExpense = thresholdExpense;
	}



	public UserDetailsEntity getUserDetails() {
		return userDetails;
	}



	public void setUserDetails(UserDetailsEntity userDetails) {
		this.userDetails = userDetails;
	}



	public Integer getYear() {
		return year;
	}



	public void setYear(Integer year) {
		this.year = year;
	}



	public void setId(Long id) {
		this.id = id;
	}

	
	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}

	
	@Override
	public void registerObserver(Observer observer) {
		 this.observers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		 observers.remove(observer);
	}

	@Override
	public boolean notifyObservers(boolean  balanceAmount) {
		System.out.println("Change in Observer");
		 for (Observer ob : observers) {
			 balanceAmount = true;
            ob.update(balanceAmount);
		
	}
		return balanceAmount;
	
	}


}
