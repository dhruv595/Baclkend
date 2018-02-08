package com.mindtree.wehealu.entity;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mindtree.wehealu.entity.SubCategory;
import com.mindtree.wehealu.entity.Zipcode;

@Entity
@Table(name="doctor")
public class Doctor {

	@Id
	@GeneratedValue(generator="newGenerator")
	@GenericGenerator(name="newGenerator", strategy="foreign", parameters = { @Parameter(value="userLogin" , name="property") })
	private int userLoginId;
	@Column(nullable=false,length=25)
	private String doctorName;
	@Column(nullable=true,length=10)
	private String contact;
	@Column(nullable=true,length=20,unique=true)
	private String mciId;
	@Column(nullable=true,length=20)
	private String experience;
	@Column(nullable=true, length=13)
	private String timeSlot;
	@Column(nullable=true, length=7)
	private String workDays;
	@Column(nullable=true,length=1)
	private String gender;
	@Column(nullable=true,length=3)
	private String fee;
	@Column(nullable=true,length=20)
	private String qualifications;
	@ManyToOne
	@JoinColumn(name="subCategoryId",nullable=true)
	private SubCategory subCategory;
	@ManyToOne
	@JoinColumn(name="zipCode",nullable=true)
	private Zipcode zipCode;
	@Column(nullable=false,length=1)
	private int status;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userLoginId")
	private Login userLogin;

	public int getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getMciId() {
		return mciId;
	}

	public void setMciId(String mciId) {
		this.mciId = mciId;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getWorkDays() {
		return workDays;
	}

	public void setWorkDays(String workDays) {
		this.workDays = workDays;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQualifications() {
		return qualifications;
	}

	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Zipcode getZipCode() {
		return zipCode;
	}

	public void setZipCode(Zipcode zipCode) {
		this.zipCode = zipCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Login getUserLogin() {
		return userLogin;
	}
	

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public void setUserLogin(Login userLogin) {
		this.userLogin = userLogin;
	}

	@Override
	public String toString() {
		return "Doctor [userLoginId=" + userLoginId + ", doctorName=" + doctorName + ", contact=" + contact + ", mciId="
				+ mciId + ", experience=" + experience + ", timeSlot=" + timeSlot + ", workDays=" + workDays
				+ ", gender=" + gender + ", qualifications=" + qualifications + ", subCategory=" + subCategory
				+ ", zipCode=" + zipCode + ", status=" + status + ", userLogin=" + userLogin + "]";
	}


	
	
	
	
	
}
