package com.mindtree.wehealu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userLoginId;
	@Column(nullable=false,length=50, unique=true)
	private String email;
	@Column(nullable=false,length=160)
	private String password;
	@Column(nullable=false,length=1)
	private int userType;
	@Column(nullable=false,length=1)
	int accountStatus ;   // 0 - access revoked/ account deactivated    1 - account active
	
	public int getUserLoginId() {
		return userLoginId;
	}
	public void setUserLogin_id(int userLoginId) {
		this.userLoginId = userLoginId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserType() {
		return userType;
	}
	public void setUser_type(int userType) {
		this.userType = userType;
	}
	public int getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}
	@Override
	public String toString() {
		return "Login [userLoginId=" + userLoginId + ", email=" + email + ", password=" + password + ", userType="
				+ userType + ", accountStatus=" + accountStatus + "]";
	}
	
	
}
