package com.mindtree.wehealu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class User {

	@Id
	@GeneratedValue(generator = "newGenerator")
	@GenericGenerator(name="newGenerator", strategy="foreign", parameters = { @Parameter(value="userLogin" , name="property") })
	private int userLoginId;
	@Column(nullable=false,length=25)
	private String userName;
	@Column(nullable=false,length=10)
	private String userContact;
	@Column(nullable=false,length=14)
	private String userAadhar;
//    @ManyToOne
//    @JoinColumn(name="zipCode",nullable=true)
//	private Zipcode zipCode;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userLoginId")
	private Login userLogin;


	public int getUserLoginId() {
		return userLoginId;
	}


	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserContact() {
		return userContact;
	}


	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}


	public String getUserAadhar() {
		return userAadhar;
	}


	public void setUserAadhar(String userAadhar) {
		this.userAadhar = userAadhar;
	}


	public Login getUserLogin() {
		return userLogin;
	}


	public void setUserLogin(Login userLogin) {
		this.userLogin = userLogin;
	}


	@Override
	public String toString() {
		return "User [userLoginId=" + userLoginId + ", userName=" + userName + ", userContact=" + userContact
				+ ", userAadhar=" + userAadhar + ", userLogin=" + userLogin + "]";
	}


	
	
	
	
	
	
}
