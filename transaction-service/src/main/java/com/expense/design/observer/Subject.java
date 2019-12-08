package com.expense.design.observer;


public interface Subject {
	public void registerObserver(Observer observer);
	  public void removeObserver(Observer observer);
	boolean notifyObservers(boolean balanceAmount);
}
