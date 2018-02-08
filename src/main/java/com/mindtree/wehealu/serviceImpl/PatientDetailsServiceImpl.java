package com.mindtree.wehealu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.wehealu.dao.PatientDetailsDao;
import com.mindtree.wehealu.entity.UploadHistory;
import com.mindtree.wehealu.entity.User;
import com.mindtree.wehealu.service.PatientDetailsService;

@Repository
public class PatientDetailsServiceImpl implements PatientDetailsService {

	@Autowired
	PatientDetailsDao patientDetailsDao;
	@Override
	public void uploadHistory(User user) {
		
		patientDetailsDao.uploadHistory(user);
	}
	
	public List<UploadHistory> getUploadHistory(User user)
	{
		return patientDetailsDao.getUploadHistory(user);
	}

	public void deleteUploadHistory(User user)
	{
		patientDetailsDao.deleteUploadHistory(user);
	}
}
