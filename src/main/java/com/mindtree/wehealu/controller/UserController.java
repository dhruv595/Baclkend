package com.mindtree.wehealu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.wehealu.dto.LoginUserdto;
import com.mindtree.wehealu.entity.User;
import com.mindtree.wehealu.service.UserService;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//--------------- Siddesh --------------------------------------------------
	
	@RequestMapping(value="/signupuser",method=RequestMethod.POST)
	public Object addUser(@RequestBody LoginUserdto loginuser){
		//System.out.println(userService==null);
		if(userService.logincheck(loginuser))
		{
			return loginuser;
		}
		return null;
	
	}
	
	//-------------- ANIMESH -------------------------------------------------
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public boolean updateUser(@RequestBody User user){
		System.out.println(user);
		return userService.updateUserData(user);
	}
	

}
