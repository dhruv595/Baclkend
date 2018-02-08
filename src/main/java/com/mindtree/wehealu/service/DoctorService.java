package com.mindtree.wehealu.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.mindtree.wehealu.dto.LoginDoctorMaindto;
import com.mindtree.wehealu.dto.LoginDoctordto;
import com.mindtree.wehealu.entity.Doctor;

public interface DoctorService {
	
	public Doctor getDoctorFromDb(int doctor_id);
	public Boolean addDoctorToDb(Doctor doctor);
	public List<Doctor> getDoctorByCategory(int category_id); 
	public Doctor seconddoctorsignup(LoginDoctorMaindto logindoctormain);
    public void firstdoctorsignup(LoginDoctordto logindoctor);
    public List<Doctor> getDoctorList(String doctorName,String contact); 
    public  void deactivateDoctor( Doctor doctor);
    public void activateDoctor(Doctor doctor);
    public boolean updateDoctor(Doctor doctor);
    
}

