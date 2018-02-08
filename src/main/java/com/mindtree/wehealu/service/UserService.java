package com.mindtree.wehealu.service;

import com.mindtree.wehealu.dto.LoginUserdto;

import com.mindtree.wehealu.entity.User;

public interface UserService {

	public boolean logincheck(LoginUserdto loginuser);
	public boolean updateUserData(User user);
}
