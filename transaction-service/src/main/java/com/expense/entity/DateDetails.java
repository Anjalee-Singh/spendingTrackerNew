package com.expense.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "DateDetails" ,schema="nci01")
public class DateDetails implements Serializable{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1384368707692197314L;
	
	@Id
	@Column(name = "date_details_id")
	
	private Long id;
	
	@NotNull
	@Column(name = "From_Date")
	public static String fromDate;
	
	@NotNull
	@Column(name = "Till_Date")
	public static String tillDate;
	
	/*@NotNull
	@Column(name = "total_expense")
	private String totalExpense;*/
	
	/*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserDetails userDetails;*/
	
	public DateDetails() {}
	 
    

	public String getFromDate() {
		return fromDate;
	}



	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}



	public String getTillDate() {
		return tillDate;
	}



	public void setTillDate(String tillDate) {
		this.tillDate = tillDate;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	/*public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTotalExpense() {
		return totalExpense;
	}*/

	/*public void setTotalExpense(String totalExpense) {
		this.totalExpense = totalExpense;
	}
*/


/*	public UserDetails getUserDetails() {
		return userDetails;
	}



	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
*/


	@Override
	public String toString() {
		return "DateDetails [From date=" + fromDate + ", Till Date=" + tillDate + "]";
	}

	
	

}
