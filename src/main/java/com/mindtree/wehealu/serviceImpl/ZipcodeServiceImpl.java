package com.mindtree.wehealu.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.wehealu.dao.ZipcodeDao;
import com.mindtree.wehealu.entity.Zipcode;
import com.mindtree.wehealu.service.ZipcodeService;

@Service
public class ZipcodeServiceImpl implements ZipcodeService {

	@Autowired
	ZipcodeDao zipcodeDao;

	public ZipcodeDao getZipcodeDao() {
		return zipcodeDao;
	}

	public void setZipcodeDao(ZipcodeDao zipcodeDao) {
		this.zipcodeDao = zipcodeDao;
	}
	
	//-----------------------------------------------------------------------------------------------

	public List<Zipcode> getAddressList() {
		
		return zipcodeDao.getAddressList();
	}
	
	
}
