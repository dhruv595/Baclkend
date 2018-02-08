/**
 * 
 */
package com.mindtree.weHealU.controller;


import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mindtree.weHealU.serviceImpl.UserServiceImplTest;
import com.mindtree.wehealu.controller.UserController;
import com.mindtree.wehealu.dto.LoginUserdto;
import com.mindtree.wehealu.service.UserService;





/**
 * @author M1043042
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-beans.xml")
public class UserControllerTest {
	
	
	 @Autowired
	 private UserController userController;
	 
	
	
	
	
	
	@Test
	public final void testAddUser() {
		LoginUserdto loginuser=new LoginUserdto();
		loginuser.setUserAadhar("123412341234");
		loginuser.setUserContact("9092909090");
		loginuser.setUserEmail("dida1@gmail.com");
		loginuser.setUserName("siddesh");
		loginuser.setUserPassword("Siddesh@123");
		loginuser.setUserStatus(1);
		loginuser.setUserType(0);
		
		assertEquals(loginuser,userController.addUser(loginuser));
	}
}
