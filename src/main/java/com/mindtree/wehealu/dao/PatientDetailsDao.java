package com.mindtree.wehealu.dao;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.mindtree.wehealu.entity.UploadHistory;
import com.mindtree.wehealu.entity.User;

public interface PatientDetailsDao {

	public void uploadHistory(User user);
	public List<UploadHistory> getUploadHistory(User user);
	public void deleteUploadHistory(User user);

}
