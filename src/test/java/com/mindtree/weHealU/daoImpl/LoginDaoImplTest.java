/**
 * 
 */
package com.mindtree.weHealU.daoImpl;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mindtree.wehealu.dao.LoginDao;
import com.mindtree.wehealu.dto.LoginDto;

/**
 * @author M1042945
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-beans.xml")
public class LoginDaoImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.daoImpl.LoginDaoImpl#getSessionFactory()}.
	 */
	@Test
	public final void testGetSessionFactory() {
//		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.daoImpl.LoginDaoImpl#setSessionFactory(org.hibernate.SessionFactory)}.
	 */
	@Test
	public final void testSetSessionFactory() {
//		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.daoImpl.LoginDaoImpl#validate(com.mindtree.weHealU.dto.LoginDto)}.
	 */
	@Autowired
	LoginDao loginDao;
	LoginDto loginDto=new LoginDto();
	@Test
	public final void testValidate() {
		loginDto.setEmail("amrutha@gmail.com");
		loginDto.setPassword("2Amrutha");
		
		assertNotNull(loginDao.validate(loginDto));
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.daoImpl.LoginDaoImpl#passwordcheck(com.mindtree.weHealU.dto.LoginDto)}.
	 */
	@Test
	public final void testPasswordcheck() {
		
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.daoImpl.LoginDaoImpl#otpcheck(com.mindtree.weHealU.dto.LoginDto)}.
	 */
	@Test
	public final void testOtpcheck() {
		
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.daoImpl.LoginDaoImpl#phnotp(com.mindtree.weHealU.dto.LoginDto)}.
	 */
	@Test
	public final void testPhnotp() {
		loginDto.setEmail("amrutha@gmail.com");
		loginDto.setUser_type(1);
		assertNotNull(loginDao.phnotp(loginDto));
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.daoImpl.LoginDaoImpl#updatePassword(com.mindtree.weHealU.dto.LoginDto)}.
	 */
	@Test
	public final void testUpdatePassword() {
		loginDto.setEmail("amrutha@gmail.com");
		loginDto.setPassword("2Amrutha");
		
		assertNotNull(loginDao.validate(loginDto));
		
	}

}
