package com.mindtree.wehealu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.wehealu.dao.DoctorDao;
import com.mindtree.wehealu.dao.ZipcodeDao;
import com.mindtree.wehealu.dto.LoginDoctorMaindto;
import com.mindtree.wehealu.dto.LoginDoctordto;
import com.mindtree.wehealu.entity.Doctor;
import com.mindtree.wehealu.entity.Login;
import com.mindtree.wehealu.entity.SubCategory;
import com.mindtree.wehealu.entity.Zipcode;
import com.mindtree.wehealu.service.DoctorService;
import com.mindtree.wehealu.service.LoginService;

@Repository
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorDao doctorDao;

	@Autowired
	LoginService loginService;

	@Autowired
	ZipcodeDao zipCodeDao;

	public DoctorDao getDoctorDao() {
		return doctorDao;
	}

	public void setDoctorDao(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}

	// ------------------------------------------------------------------------------

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public Doctor getDoctorFromDb(int doctor_id) {
		System.out.println("service called");
		return getDoctorDao().getDoctor(doctor_id);
		// return getDoctorDaoImpl().getDoctor(doctor_id);
	}

	public Boolean addDoctorToDb(Doctor doctor) {
		this.doctorDao.addDoctor(doctor);
		return true;
	}

	public List<Doctor> getDoctorByCategory(int category_id) {

		return doctorDao.getDoctorByCategory(category_id);
	}

	// --------------------- Siddesh -------------------------------------

	@Override
	public void firstdoctorsignup(LoginDoctordto logindoctor) {
		// TODO Auto-generated method stub

		Login login = new Login();
		Doctor doctor = new Doctor();
		login.setAccountStatus(logindoctor.getAccountStatus());
		login.setEmail(logindoctor.getDoctorEmail());
		String pass = logindoctor.getDoctorPassword();
		String hashpass = loginService.PasswordEncoderGenerator(pass);
		login.setPassword(hashpass);

		login.setUser_type(logindoctor.getUserType());

		doctor.setDoctorName(logindoctor.getDoctorName());
		doctor.setStatus(logindoctor.getUserStatus());

		doctor.setUserLogin(login);
		doctorDao.addDoctor(doctor);

	}

	@Override
	public Doctor seconddoctorsignup(LoginDoctorMaindto logindoctormain) {
		// TODO Auto-generated method stub

		Doctor doctor = new Doctor();
		SubCategory subcategory = new SubCategory();
		Zipcode zipcode = new Zipcode();

		doctor.setContact(logindoctormain.getDoctorContact());
		doctor.setDoctorName(logindoctormain.getDoctorName());
		doctor.setExperience(logindoctormain.getDoctorExp());
		doctor.setMciId(logindoctormain.getDoctorMciid());
		doctor.setQualifications(logindoctormain.getDoctorQualification());
		doctor.setTimeSlot(logindoctormain.getDoctorTime());
		doctor.setGender(logindoctormain.getDoctorGender());
		doctor.setStatus(logindoctormain.getDoctorStatus());
		doctor.setUserLoginId(logindoctormain.getDoctorLoginId());
		doctor.setWorkDays(logindoctormain.getDoctorWorkdays());
		doctor.setFee(logindoctormain.getDoctorFee());

		zipcode.setZipCode(logindoctormain.getDoctorZip());
		zipcode.setArea(logindoctormain.getDoctorArea());
		zipcode.setCity(logindoctormain.getDoctorCity());
		zipcode.setState(logindoctormain.getDoctorState());

		subcategory.setCategory((logindoctormain.getSubcategory()).getCategory());
		subcategory.setSubCategoryId((logindoctormain.getSubcategory()).getSubCategoryId());
		subcategory.setSubCategoryName(logindoctormain.getSubcategory().getSubCategoryName());

		doctor.setSubCategory(subcategory);
		zipCodeDao.addZipcode(zipcode);
		doctor.setZipCode(zipcode);
		doctorDao.addDoctorSecond(doctor);
		doctor = doctorDao.getDoctor(logindoctormain.getDoctorLoginId());
		return doctor;

	}

	public List<Doctor> getDoctorList(String doctorName, String contact) {
		return doctorDao.getDoctorList(doctorName, contact);
	}

	public void deactivateDoctor(Doctor doctor) {
		doctorDao.deactivateDoctor(doctor);
	}

	public void activateDoctor(Doctor doctor) {
		System.out.println(doctor);
		doctorDao.activateDoctor(doctor);
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		doctorDao.updateDoctor(doctor);
		return true;
	}

}
