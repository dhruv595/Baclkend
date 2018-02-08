package com.mindtree.wehealu.dao;

import java.util.List;


import com.mindtree.wehealu.entity.Zipcode;

public interface ZipcodeDao {
	
	public List<Zipcode> getAddressList();
	public boolean addZipcode (Zipcode zipcode);

	

}
