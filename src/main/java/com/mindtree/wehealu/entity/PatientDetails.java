package com.mindtree.wehealu.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mindtree.wehealu.entity.User;

@Entity
public class PatientDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int patientId;
	
	@Column(nullable=false, length=50)
	private String patientName;
	
	@Column(nullable=false, length=3)
	private int age;
	
	@Column(nullable=false, length=1)
	private String gender;       //  1 - male     0 -female    2 - trans / others
	
	@Column(nullable=true,length=200)
	private String patientSymptoms;
	
	@Column(nullable=false,length=20)
	private String userPatientRelation;
	
	@ManyToOne
	@JoinColumn(name="userLoginId",nullable=true)
	private User user;	
	
	@Column(nullable=true)
	private String patientHistory;
	
	public String getPatientHistory() {
		return patientHistory;
	}
	public void setPatientHistory(String patientHistory) {
		this.patientHistory = patientHistory;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPatientSymptoms() {
		return patientSymptoms;
	}
	public void setPatientSymptoms(String patientSymptoms) {
		this.patientSymptoms = patientSymptoms;
	}
	public String getUserPatientRelation() {
		return userPatientRelation;
	}
	public void setUserPatientRelation(String userPatientRelation) {
		this.userPatientRelation = userPatientRelation;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "PatientDetails [patientId=" + patientId + ", patientName=" + patientName + ", age=" + age + ", gender="
				+ gender + ", patientSymptoms=" + patientSymptoms + ", userPatientRelation=" + userPatientRelation
				+ ", user=" + user + ", patientHistory=" + patientHistory + "]";
	}
	
	
	
	
	
	
	
	
	
}

