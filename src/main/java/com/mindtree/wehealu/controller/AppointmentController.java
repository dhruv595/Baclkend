package com.mindtree.wehealu.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.wehealu.dto.BookingApppointmentDto;
import com.mindtree.wehealu.dto.TimeSlot;
import com.mindtree.wehealu.entity.Appointment;
import com.mindtree.wehealu.entity.User;
import com.mindtree.wehealu.service.AppointmentService;




@CrossOrigin
@RestController
public class AppointmentController {

	
		
		@Autowired
		AppointmentService appointmentService;

		
		public AppointmentService getAppointmentService() {
			return appointmentService;
		}

		public void setAppointmentSevice(AppointmentService appointmentService) {
			this.appointmentService = appointmentService;
		}

		@RequestMapping(value="/appointment",method=RequestMethod.GET)
		public Object getAppointment(){
			return "hello";
		}
		
		@RequestMapping(value="/appointment", method=RequestMethod.POST, consumes="application/json")		
		public Object postDoctor(@RequestBody BookingApppointmentDto appointment){
			
			this.appointmentService.addAppointment(appointment);
			
			return appointment;
		}
		
		@RequestMapping(value="/appointmentList" ,method=RequestMethod.POST)
		public List<Appointment> getAppointmentList(@RequestBody User user)
		{
			
			return appointmentService.getAppointmentList(user.getUserLoginId());
		}

		@RequestMapping(value="/upcomingAppointment" ,method=RequestMethod.POST)
		public List<Appointment> getUpcomingAppointmentList(@RequestBody User user)
		{
			
			return appointmentService.getUpcomingAppointmentList(user.getUserLoginId());
		}	
		@RequestMapping(value="/cancelAppointment" ,method=RequestMethod.POST)
		public void cancelAppointment(@RequestBody Appointment appointment)
		{
			
			appointmentService.cancelAppointment(appointment);
		}
		

		@RequestMapping(value="/upcomingDoctorAppointment" ,method=RequestMethod.POST)
		public List<Appointment> getDoctorUpcomingAppointmentList(@RequestBody User user)
		{
			
			return appointmentService.getDoctorUpcomingAppointmentList(user.getUserLoginId());
		}	

		
		@RequestMapping(value="/timeslot",method=RequestMethod.POST)
		public List<String> timeSlot(@RequestBody TimeSlot time)
		{
			String time1=time.getTime();
			String[] slot= time1.split("-");
			System.out.println(slot[0]);
			String[] slot1=slot[0].split(":");
			String[] slot2=slot[1].split(":");
			System.out.println(slot1[0]);
			System.out.println(slot2[0]);
			int start=Integer.parseInt(slot1[0]);
			int end=Integer.parseInt(slot2[0].trim());
			List<String> intervals = new ArrayList<>();
			java.sql.Time startTime = new java.sql.Time(start, 0, 0);
			java.sql.Time endTime = new java.sql.Time(end, 0, 0);

			

			Calendar cal = Calendar.getInstance();
			Calendar cals=Calendar.getInstance();
			cal.setTime(startTime);
		
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			
			while (cal.getTime().before(endTime)) {
			    cals.setTime(cal.getTime());
				cal.add(Calendar.MINUTE, 15);
			    intervals.add(sdf.format(new java.sql.Time(cals.getTimeInMillis()))+"-"+sdf.format(new java.sql.Time(cal.getTimeInMillis())));
			}

			return intervals;
		
		
		
		}
		
	}
