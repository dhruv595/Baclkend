package com.mindtree.wehealu.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mindtree.wehealu.dto.LoginDto;
import com.mindtree.wehealu.service.LoginService;
//@Component
//@CrossOrigin
@RestController
@EnableWebMvc
public class LoginController {

	
	@Autowired
	LoginService loginService;
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST,consumes="application/json")
	@ResponseBody
	public Object Log(@RequestBody LoginDto loginDto)
	{
		
		 return loginService.check(loginDto);
	}
	
	
	@RequestMapping(value="/forgot",method=RequestMethod.POST,consumes="application/json")
	@ResponseBody
	public Object forgotpassword(@RequestBody LoginDto loginDto)
	{
	System.out.println(loginDto.getOtp());
		
	return loginService.emailotp(loginDto);
	
	}

	@RequestMapping(value="/hash",method=RequestMethod.POST,consumes="application/json")
	@ResponseBody
	public Object hash(@RequestBody LoginDto loginDto)
	{				
		String  originalPassword =loginDto.getPassword();
				        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
				        System.out.println(generatedSecuredPasswordHash);
				        System.out.println(generatedSecuredPasswordHash.length());
				         
				       // boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
				        //System.out.println(matched);
				      return generatedSecuredPasswordHash;
	}
	////////////////new password set/////////////
	@RequestMapping(value="/newpassword",method=RequestMethod.POST,consumes="application/json")
	@ResponseBody
	public Object newpassword(@RequestBody LoginDto loginDto)
	{
		return loginService.confirmPassword(loginDto);
	}
	
}
