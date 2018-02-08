package com.mindtree.wehealu.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mindtree.wehealu.dao.LoginDao;
import com.mindtree.wehealu.dao.UserDao;
import com.mindtree.wehealu.dto.LoginUserdto;
import com.mindtree.wehealu.entity.Login;
import com.mindtree.wehealu.entity.User;
import com.mindtree.wehealu.service.LoginService;
import com.mindtree.wehealu.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Autowired
	LoginService loginService;
	
	

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//---------------------------------------------------------------------

	

	@Override
	public boolean logincheck(LoginUserdto loginuser) {
		// TODO Auto-generated method stub
		Login login=new Login();
		User user=new User();
		login.setAccountStatus(loginuser.getUserStatus());
		login.setEmail(loginuser.getUserEmail());
		String pass=loginuser.getUserPassword();
		String hashpass=loginService.PasswordEncoderGenerator(pass );
		login.setPassword(hashpass);
		login.setUser_type(loginuser.getUserType());
		user.setUserAadhar(loginuser.getUserAadhar());
		user.setUserContact(loginuser.getUserContact());
		user.setUserName(loginuser.getUserName());
		
		
		user.setUserLogin(login);
		
		return userDao.addUser(user);
	} 
	
	
	//---------------------ANIMESH --------------------------------------------------
	@Override
	public boolean updateUserData(User user) {
		return userDao.updateUser(user);
	} 
	
	
}
