package com.mindtree.wehealu.service;

import org.springframework.stereotype.Service;


import com.mindtree.wehealu.dto.LoginDto;
import com.mindtree.wehealu.entity.Login;

@Service
public interface LoginService {

	public Object check(LoginDto loginDto);
	public Object emailotp(LoginDto loginDto);
	public Object newpassword(LoginDto loginDto);
	public Object confirmPassword(LoginDto loginDto);
	public String PasswordEncoderGenerator( String pass) ;
	public Object updateStatus(Login login);
}
