package com.mindtree.wehealu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.mindtree.wehealu.dto.LoginDto;

import com.mindtree.wehealu.entity.Doctor;
import com.mindtree.wehealu.entity.Login;
import com.mindtree.wehealu.entity.User;
import com.mindtree.wehealu.service.AdminService;
import com.mindtree.wehealu.service.LoginService;
@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	LoginService loginService;
	
	
	
	
	@RequestMapping(value="/getDoctorList",method=RequestMethod.GET)
	public List<Doctor> getDoctorList()
	{
		return adminService.getDoctorList();
		
	}
	
	@RequestMapping(value="/getUserList",method=RequestMethod.GET)
	public List<User> getUserList()
	{
		return adminService.getUserList();
		
	}
	@RequestMapping(value="/verfiyDoctor",method=RequestMethod.POST)
	public Object verfiyDoctor(@RequestBody LoginDto loginDto)
	{
	return adminService.check(loginDto);
		
	}
	
	@RequestMapping(value="/updateAccountStatus",method=RequestMethod.POST)
	
	public Object updateAccountStatus(@RequestBody Login login){
		
		loginService.updateStatus(login);
		return login;
		
	
	}
}
