package com.mindtree.wehealu.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.mindtree.wehealu.entity.UploadHistory;
import com.mindtree.wehealu.entity.User;

public interface PatientDetailsService {

	public void uploadHistory( User user);
	public List<UploadHistory> getUploadHistory(User user);
	public void deleteUploadHistory(User user);

}
