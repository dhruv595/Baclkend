package com.mindtree.wehealu.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import com.mindtree.wehealu.dao.LoginDao;
import com.mindtree.wehealu.dto.LoginDto;
import com.mindtree.wehealu.entity.Login;
import com.mindtree.wehealu.service.LoginService;



@Repository
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;
	
	

	public LoginDao getLoginDao() {
		return loginDao;
	}



	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}


/////////////////////////////////////////////////////////////////////////////////////////////
	public Object check(LoginDto loginDto)
	{
		return loginDao.validate(loginDto);
	
	}


///////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Object emailotp(LoginDto loginDto) 
	{
		String otp=loginDto.getOtp();
		if(loginDto.getOtp().equals("email"))
			return loginDao.otpcheck(loginDto);
			 if(loginDto.getOtp().equals("phone"))
				return loginDao.phnotp(loginDto);
			return null;
		}
/////////////////////////////////genrate new code password///////////////////////////////////////////////////////
		
	public String newpassword(LoginDto loginDto) 
		    {

				 String  originalPassword = loginDto.getNewpassword();
			        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
			        System.out.println(generatedSecuredPasswordHash);
			        System.out.println(generatedSecuredPasswordHash.length());
			         
			       // boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
			        //System.out.println(matched);
			      return generatedSecuredPasswordHash;
				

			}
			 ///////////////////////////////////////password Check//////////////////////////////////////////
	public Object confirmPassword(LoginDto loginDto)
	{
		String hash=newpassword(loginDto);
		loginDto.setHash(hash);
		return loginDao.updatePassword(loginDto);
	}
	
	
	
	//------------------------ Siddesh -------------------------------------------------------------------------
	
	@Override
	public String PasswordEncoderGenerator( String pass) 
    {
		 String  originalPassword = pass;
	        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
	        System.out.println(generatedSecuredPasswordHash);
	        System.out.println(generatedSecuredPasswordHash.length());
	         
	       // boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
	        //System.out.println(matched);
	      return generatedSecuredPasswordHash;
		

	}



	@Override
	public Object updateStatus(Login login) {
		
	loginDao.updateStatus(login);
	return login;
		
	}
}
