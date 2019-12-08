package com.expense.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.logging.log4j.message.Message;

import com.expense.design.observer.Observer;

@Entity
@Table(name = "UserDetails" ,schema="nci01")
public class UserDetailsEntity implements Serializable,Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8894946724045394421L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
    //@Size(max = 65)
	@Column(name = "firstName")
	private String firstName;
	
	@NotNull
    //@Size(max = 65)
	@Column(name = "lastName")
	private String lastName;
	
	@NotNull
    //@Size(max = 68)
	@Column(name = "dateOfBirth")
	private Date dateOfBirth;
	
	@NotNull
    //@Size(max = 6)
	@Column(name = "pdfPassword")
	private String pdfPassword;
	
	@NotNull
    //@Size(max = 16)
	@Column(name = "phoneNumber",unique = true)
	private String phoneNumber;
	
	@NotNull
    //@Size(max = 25)
	@Column(name = "createdOn")
	private Timestamp createdOn;
	
	
	@Column(name = "updatedOn")
	private Timestamp updatedOn;
    
	/*@OneToOne(mappedBy="userDetails",cascade = CascadeType.ALL,
              fetch = FetchType.LAZY, optional = false)
    private AccountDetails accountDetails;*/
	  
	public Long getId() {
		return id;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPdfPassword() {
		return pdfPassword;
	}

	public void setPdfPassword(String pdfPassword) {
		this.pdfPassword = pdfPassword;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Timestamp updatedOn) {
		this.updatedOn = updatedOn;
	}



	@Override
	public void update(boolean balanceAmount) {
		 System.out.println("Reaching Threshold Value:: " + balanceAmount);
		
	}
	
	
}
