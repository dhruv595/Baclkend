/**
 * 
 */
package com.mindtree.weHealU.serviceImpl;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mindtree.wehealu.dao.UserDao;
import com.mindtree.wehealu.dto.LoginUserdto;
import com.mindtree.wehealu.entity.Login;
import com.mindtree.wehealu.entity.User;
import com.mindtree.wehealu.service.LoginService;
import com.mindtree.wehealu.service.UserService;


/**
 * @author M1043042
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-beans.xml")
public class UserServiceImplTest {
	

	@Autowired
	UserService userService;
	
	
	
	
	@Test
	public final void testLogincheck() {
		System.out.println(userService);
		
		LoginUserdto loginUser= new LoginUserdto();
		loginUser.setUserAadhar("308411252221");
		loginUser.setUserContact("9876543210");
		loginUser.setUserEmail("sany@gmail.com");
		loginUser.setUserName("sanjay");
		loginUser.setUserPassword("sanjay@123");
		loginUser.setUserStatus(1);
		loginUser.setUserType(0);
		
		assertEquals(true,userService.logincheck(loginUser));
		

		
		
		 
	}

}
