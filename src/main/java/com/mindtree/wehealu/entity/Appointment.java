package com.mindtree.wehealu.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.mindtree.wehealu.entity.Doctor;
import com.mindtree.wehealu.entity.User;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int appointmentId;
	@Column(nullable=false,length=10)
	private String appointmentDate;
	@ManyToOne
	@JoinColumn(name="doctorId",nullable=false)
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(nullable=false,name="userLoginId")
	private User user;
	
	@Column(nullable=false,length=1)
	private int appointmentStatus;
	@Column(nullable=false,length=15)
	private String appointmentSlot;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="patientId",nullable=true)
	private PatientDetails patientDetails; 
	
	public PatientDetails getPatientDetails() {
		return patientDetails;
	}
	public void setPatientDetails(PatientDetails patientDetails) {
		this.patientDetails = patientDetails;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(int appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	public String getAppointmentSlot() {
		return appointmentSlot;
	}
	public void setAppointmentSlot(String appointmentSlot) {
		this.appointmentSlot = appointmentSlot;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate + ", doctor="
				+ doctor + ", user=" + user + ", appointmentStatus=" + appointmentStatus + ", appointmentSlot="
				+ appointmentSlot + ", patientDetails=" + patientDetails + "]";
	}
	
	
	
	

	
	

}
