package com.mindtree.wehealu.service;

import java.util.List;

import com.mindtree.wehealu.dto.LoginDto;
import com.mindtree.wehealu.entity.Doctor;
import com.mindtree.wehealu.entity.User;

public interface AdminService {

	 public List<Doctor> getDoctorList();

	public List<User> getUserList();
	public Object check(LoginDto loginDto);
	

}
