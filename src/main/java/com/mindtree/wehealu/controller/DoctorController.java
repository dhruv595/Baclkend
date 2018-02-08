package com.mindtree.wehealu.controller;

import java.util.List;

import javax.ws.rs.QueryParam;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.wehealu.dto.DoctorSearchDto;
import com.mindtree.wehealu.dto.LoginDoctorMaindto;
import com.mindtree.wehealu.dto.LoginDoctordto;
import com.mindtree.wehealu.entity.Appointment;
import com.mindtree.wehealu.entity.Doctor;
import com.mindtree.wehealu.entity.Zipcode;
import com.mindtree.wehealu.service.DoctorService;
import com.mindtree.wehealu.service.ZipcodeService;

@CrossOrigin
@RestController
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	@Autowired
	ZipcodeService zipcodeService;

	public ZipcodeService getZipcodeService() {
		return zipcodeService;
	}

	public void setZipcodeService(ZipcodeService zipcodeService) {
		this.zipcodeService = zipcodeService;
	}

	public DoctorService getDoctorService() {
		return doctorService;
	}

	public void setDoctorSevice(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	//--------------------------------------------------------------------------------------------
	
	//doctor list on basis on category ID. 
	@RequestMapping(value="/doctor",method=RequestMethod.GET)
	public Object getDoctorByCategory(@QueryParam("category_id") int categoryId){
		
		return doctorService.getDoctorByCategory(categoryId);
	}
	
	@RequestMapping(value="/doctor", method=RequestMethod.POST)
	public boolean postDoctor(@RequestBody Doctor doctor){
		doctorService.updateDoctor(doctor);
		return true;
	}
	
	//------------------- Siddesh -----------------------------------------------------------------
	
	@RequestMapping(value="/signupdoctorfirst", method=RequestMethod.POST)
	public Object postDoctor(@RequestBody LoginDoctordto logindoctor){	
		doctorService.firstdoctorsignup(logindoctor);
		return logindoctor;
	}
	
	

	@RequestMapping(value="/signupdoctorsecond", method=RequestMethod.POST)
	public Object postDoctorsecond(@RequestBody LoginDoctorMaindto logindoctormain){
        
		 return doctorService.seconddoctorsignup(logindoctormain);
		
	}
	
	
	//---------------------- Zipcode class Address requirements ------------------------------
	
	@RequestMapping(value="/zipcodes",method=RequestMethod.GET)
	public Object getAddressList(){
		return zipcodeService.getAddressList();
	}
	
	@RequestMapping(value="/doctorList",method=RequestMethod.POST)
	public  List<Doctor> getDoctorList( @RequestBody DoctorSearchDto doctorSearchDto){
		
		return doctorService.getDoctorList(doctorSearchDto.getDoctorName(),doctorSearchDto.getContact());
	}
	
	@RequestMapping(value="/deactivateDoctor",method=RequestMethod.POST)
	public  void deactivateDoctor( @RequestBody Doctor doctor){
		
		doctorService.deactivateDoctor(doctor);
	}
	
	@RequestMapping(value="/activateDoctor",method=RequestMethod.POST)
	public  void activateDoctor( @RequestBody Doctor doctor){
		System.out.println(doctor);
		doctorService.activateDoctor(doctor);
	}
}
