package com.mindtree.wehealu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mindtree.wehealu.dao.AppointmentDao;
import com.mindtree.wehealu.dto.BookingApppointmentDto;
import com.mindtree.wehealu.entity.Appointment;
import com.mindtree.wehealu.entity.PatientDetails;
import com.mindtree.wehealu.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentDao appointmentDao;
	
	public AppointmentDao getAppointmentDao() {
		return appointmentDao;
	}

	public void setAppointmentDao(AppointmentDao appointmentDao) {
		this.appointmentDao = appointmentDao;
	}

	//------------------------------------------------------------------------------
	public Appointment getAppointment(int appointmentId) {
		System.out.println("service called");
		return getAppointmentDao().getAppointment(appointmentId);
	}


	public Boolean addAppointment(BookingApppointmentDto patientAppointment ) {
		Appointment appointment=new Appointment();
		PatientDetails patient=new PatientDetails();
		patient=patientAppointment.getPatient();
		System.out.println(patient);
		appointment=patientAppointment.getAppointment();
		//this.appointmentDao.addPatient(patient);
		this.appointmentDao.addAppointment(appointment);
		return true;
	}
	
	@Override
	public List<Appointment> getAppointmentList(int userLoginId) {
		return appointmentDao.getAppointmentList( userLoginId);
		
	}

	@Override
	public List<Appointment> getUpcomingAppointmentList(int userLoginId) {
		return appointmentDao.getUpcomingAppointmentList( userLoginId);
		
	}
	
	@Override
	public boolean cancelAppointment(Appointment appointment)
	{
		appointmentDao.cancelAppointment(appointment);
		return true;
	}
	public List<Appointment> getDoctorUpcomingAppointmentList(int userLoginId)
	{
		return appointmentDao.getDoctorUpcomingAppointmentList( userLoginId);
	}
}
