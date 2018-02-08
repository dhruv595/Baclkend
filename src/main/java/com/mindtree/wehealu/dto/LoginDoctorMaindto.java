package com.mindtree.wehealu.dto;

import com.mindtree.wehealu.entity.SubCategory;

public class LoginDoctorMaindto {

	
	private int doctorLoginId;
	private String doctorName;
	private int doctorStatus;
   
	
	private String doctorQualification;
	private int  doctorZip;
	private String doctorGender;
	private String doctorFee;
	private String doctorContact;
	private String doctorExp;
	private String doctorMciid;
	private String doctorTime;
    private String doctorWorkdays;
    private SubCategory subcategory;
    private String doctorArea;
    private String doctorCity;
    private String doctorState;
	public int getDoctorLoginId() {
		return doctorLoginId;
	}
	public void setDoctorLoginId(int doctorLoginId) {
		this.doctorLoginId = doctorLoginId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getDoctorStatus() {
		return doctorStatus;
	}
	public void setDoctorStatus(int doctorStatus) {
		this.doctorStatus = doctorStatus;
	}
	public String getDoctorQualification() {
		return doctorQualification;
	}
	public void setDoctorQualification(String doctorQualification) {
		this.doctorQualification = doctorQualification;
	}
	public int getDoctorZip() {
		return doctorZip;
	}
	public void setDoctorZip(int doctorZip) {
		this.doctorZip = doctorZip;
	}
	public String getDoctorGender() {
		return doctorGender;
	}
	public void setDoctorGender(String doctorGender) {
		this.doctorGender = doctorGender;
	}
	
	public String getDoctorFee() {
		return doctorFee;
	}
	public void setDoctorFee(String doctorFee) {
		this.doctorFee = doctorFee;
	}
	public String getDoctorContact() {
		return doctorContact;
	}
	public void setDoctorContact(String doctorContact) {
		this.doctorContact = doctorContact;
	}
	public String getDoctorExp() {
		return doctorExp;
	}
	public void setDoctorExp(String doctorExp) {
		this.doctorExp = doctorExp;
	}
	public String getDoctorMciid() {
		return doctorMciid;
	}
	public void setDoctorMciid(String doctorMciid) {
		this.doctorMciid = doctorMciid;
	}
	public String getDoctorTime() {
		return doctorTime;
	}
	public void setDoctorTime(String doctorTime) {
		this.doctorTime = doctorTime;
	}
	public String getDoctorWorkdays() {
		return doctorWorkdays;
	}
	public void setDoctorWorkdays(String doctorWorkdays) {
		this.doctorWorkdays = doctorWorkdays;
	}
	public SubCategory getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(SubCategory subcategory) {
		this.subcategory = subcategory;
	}
	public String getDoctorArea() {
		return doctorArea;
	}
	public void setDoctorArea(String doctorArea) {
		this.doctorArea = doctorArea;
	}
	public String getDoctorCity() {
		return doctorCity;
	}
	public void setDoctorCity(String doctorCity) {
		this.doctorCity = doctorCity;
	}
	public String getDoctorState() {
		return doctorState;
	}
	public void setDoctorState(String doctorState) {
		this.doctorState = doctorState;
	}
	@Override
	public String toString() {
		return "LoginDoctorMaindto [doctorLoginId=" + doctorLoginId + ", doctorName=" + doctorName + ", doctorStatus="
				+ doctorStatus + ", doctorQualification=" + doctorQualification + ", doctorZip=" + doctorZip
				+ ", doctorGender=" + doctorGender + ", doctorContact=" + doctorContact + ", doctorExp=" + doctorExp
				+ ", doctorMciid=" + doctorMciid + ", doctorTime=" + doctorTime + ", doctorWorkdays=" + doctorWorkdays
				+ ", subcategory=" + subcategory + ", doctorArea=" + doctorArea + ", doctorCity=" + doctorCity
				+ ", doctorState=" + doctorState + "]";
	}
	
	
	
	
	
	
}
