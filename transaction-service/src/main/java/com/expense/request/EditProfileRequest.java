package com.expense.request;

import java.io.Serializable;

public class EditProfileRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1410870990488733310L;
	
	private Double balanceAmount;
	private boolean threshold;
	private Double salary;
	private Double thresholdExpense;
	
	public Double getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public boolean isThreshold() {
		return threshold;
	}
	public void setThreshold(boolean threshold) {
		this.threshold = threshold;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Double getThresholdExpense() {
		return thresholdExpense;
	}
	public void setThresholdExpense(Double thresholdExpense) {
		this.thresholdExpense = thresholdExpense;
	}

}
