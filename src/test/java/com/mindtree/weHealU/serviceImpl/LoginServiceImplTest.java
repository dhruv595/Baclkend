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

import com.mindtree.wehealu.dto.LoginDto;
import com.mindtree.wehealu.service.LoginService;
import com.mindtree.wehealu.serviceImpl.LoginServiceImpl;

/**
 * @author M1042945
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-beans.xml")
public class LoginServiceImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
	System.out.println("Before Class");	
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.serviceImpl.LoginServiceImpl#getLoginDao()}.
	 */
	
	@Test
	public final void testGetLoginDao() {
		
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.serviceImpl.LoginServiceImpl#setLoginDao(com.mindtree.weHealU.dao.LoginDao)}.
	 */
	@Test
	public final void testSetLoginDao() {
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.serviceImpl.LoginServiceImpl#check(com.mindtree.weHealU.dto.LoginDto)}.
	 */
	@Autowired
	LoginService loginService;
	LoginDto loginDto=new LoginDto();
	@Test
	public final void testCheck() {
		loginDto.setEmail("amrutha@gmail.com");
		loginDto.setPassword("2Amrutha");
		
		assertNotNull(loginService.check(loginDto));
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.serviceImpl.LoginServiceImpl#emailotp(com.mindtree.weHealU.dto.LoginDto)}.
	 */
	@Test
	public final void testEmailotp() {
		loginDto.setEmail("amrutha@gmail.com");
		loginDto.setOtp("email");
		//fail("Not yet implemented"); // TODO
		assertNotNull(loginService.emailotp(loginDto));
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.serviceImpl.LoginServiceImpl#newpassword(com.mindtree.weHealU.dto.LoginDto)}.
	 */
	@Test
	public final void testNewpassword() {
		loginDto.setEmail("amrutha@gmail.com");
		loginDto.setNewpassword("2Amrutha");
		assertNotNull(loginService.newpassword(loginDto));
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.serviceImpl.LoginServiceImpl#confirmPassword(com.mindtree.weHealU.dto.LoginDto)}.
	 */
	@Test
	public final void testConfirmPassword() {
		loginDto.setNewpassword("2Amrutha");
//		String hash=(String) (loginService.newpassword(loginDto));
//		loginDto.setHash(hash);
		assertNotNull(loginService.confirmPassword(loginDto));
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.serviceImpl.LoginServiceImpl#PasswordEncoderGenerator(java.lang.String)}.
	 */
	@Test
	public final void testPasswordEncoderGenerator() {
		assertNotNull(loginService.PasswordEncoderGenerator("2Amrutha"));
	}

}
