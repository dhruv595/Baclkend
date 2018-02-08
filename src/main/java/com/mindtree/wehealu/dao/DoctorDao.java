package com.mindtree.wehealu.dao;

import java.util.List;


import com.mindtree.wehealu.dto.LoginDto;

import com.mindtree.wehealu.entity.Doctor;

public interface DoctorDao {

	public Doctor getDoctor(int doctor_id);

	public boolean addDoctor(Doctor doctor);

	public boolean addDoctorSecond(Doctor doctor);

	public List<Doctor> getDoctorByCategory(int category_id);

	//public boolean addDoctor(Doctor doctor);
	public List<Doctor> getDoctorList();

	public boolean updateDoctor(Doctor doctor);

	// public boolean addDoctor(Doctor doctor);
	public List<Doctor> getDoctorList(String doctorName, String contact);

	public void deactivateDoctor(Doctor doctor);

	public void activateDoctor(Doctor doctor);
	public int updateDoctor(LoginDto loginDto);


}
