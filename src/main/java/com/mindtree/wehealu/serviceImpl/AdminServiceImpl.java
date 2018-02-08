package com.mindtree.wehealu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.wehealu.dao.DoctorDao;
import com.mindtree.wehealu.dao.UserDao;
import com.mindtree.wehealu.dto.LoginDto;
import com.mindtree.wehealu.entity.Doctor;
import com.mindtree.wehealu.entity.User;
import com.mindtree.wehealu.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
    
	
	@Autowired
	DoctorDao doctorDao;
	
	@Autowired
	UserDao userDao;
	
	
	
	@Override
	public List<Doctor> getDoctorList() {
		 return doctorDao.getDoctorList();
		
	}



	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}
	public Object check(LoginDto loginDto)
	{
		return doctorDao.updateDoctor(loginDto);
	}

}
