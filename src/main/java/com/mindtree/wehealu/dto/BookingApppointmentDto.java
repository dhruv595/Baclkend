package com.mindtree.wehealu.dto;

import com.mindtree.wehealu.entity.Appointment;
import com.mindtree.wehealu.entity.PatientDetails;

public class BookingApppointmentDto {
	
	
	private Appointment appointment;
	private PatientDetails patient;
	
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public PatientDetails getPatient() {
		return patient;
	}
	public void setPatient(PatientDetails patient) {
		this.patient = patient;
	}
	
	@Override
	public String toString() {
		return "BookingApppointmentDto [appointment=" + appointment + ", patient=" + patient + "]";
	}
	

}
