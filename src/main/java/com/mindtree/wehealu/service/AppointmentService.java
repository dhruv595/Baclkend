package com.mindtree.wehealu.service;

import java.util.List;

import com.mindtree.wehealu.dto.BookingApppointmentDto;
import com.mindtree.wehealu.entity.Appointment;


public interface AppointmentService {
	public Appointment getAppointment(int appointmentId);
	public Boolean addAppointment(BookingApppointmentDto patientAppointment);
	public List<Appointment> getAppointmentList(int userLoginId);
	public List<Appointment> getUpcomingAppointmentList(int userLoginId);
	public boolean cancelAppointment(Appointment appointment);
	public List<Appointment> getDoctorUpcomingAppointmentList(int userLoginId);
}
