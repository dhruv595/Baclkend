package com.mindtree.wehealu.dao;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.wehealu.entity.Appointment;
import com.mindtree.wehealu.entity.PatientDetails;


public interface AppointmentDao {
	
	
	public Appointment getAppointment(int appointmentId);
	public ArrayList<Appointment> getAppointmentList(int userLoginId);
	public List<Appointment> getUpcomingAppointmentList(int userLoginId);
	public boolean cancelAppointment(Appointment appointment);
	public boolean addPatient (PatientDetails patient);
	public boolean addAppointment(Appointment appointment);
	public List<Appointment> getDoctorUpcomingAppointmentList(int userLoginId);
}
