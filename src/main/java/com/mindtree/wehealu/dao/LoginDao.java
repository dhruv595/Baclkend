package com.mindtree.wehealu.dao;

import com.mindtree.wehealu.dto.LoginDto;
import com.mindtree.wehealu.entity.Login;

public interface LoginDao 
{
public Object validate(LoginDto loginDto);
public Object otpcheck(LoginDto loginDto);
public Object updatePassword(LoginDto loginDto);
public Object phnotp(LoginDto loginDto);
public Object updateStatus(Login login);

}
