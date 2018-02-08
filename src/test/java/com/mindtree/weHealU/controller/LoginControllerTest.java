/**
 * 
 */
package com.mindtree.weHealU.controller;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mindtree.wehealu.controller.LoginController;
import com.mindtree.wehealu.dto.LoginDto;

/**
 * @author M1042945
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-beans.xml")
public class LoginControllerTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**A
	 * Test method for {@link com.mindtree.weHealU.controller.LoginController#Log(com.mindtree.weHealU.dto.LoginDto)}.
	 */
	@Autowired
	LoginController login;
	LoginDto loginDto=new LoginDto();
	@Test
	public final void testLog() {
		loginDto.setEmail("amrutha@gmail.com");
		loginDto.setPassword("2Amrutha");
		Object o=login.Log(loginDto);
		System.out.println(o);
		assertNotNull(login.Log(loginDto)); // TODO
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.controller.LoginController#forgotpassword(com.mindtree.weHealU.dto.LoginDto)}.
	 */
	@Test
	public final void testForgotpassword() {
		loginDto.setEmail("amrutha@gmail.com");
		loginDto.setOtp("email");
		//fail("Not yet implemented"); // TODO
		assertNotNull(login.forgotpassword(loginDto));
		
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.controller.LoginController#hash(com.mindtree.weHealU.dto.LoginDto)}.
	 */
//	@Test
//	public final void testHash() {
//		fail("Not yet implemented"); // TODO
//	}

	/**
	 * Test method for {@link com.mindtree.weHealU.controller.LoginController#newpassword(com.mindtree.weHealU.dto.LoginDto)}.
	 */
	@Test
	public final void testNewpassword() {
		loginDto.setEmail("amrutha@gmail.com");
		loginDto.setNewpassword("2Amrutha");
		assertNotNull(login.newpassword(loginDto));
	}

}
