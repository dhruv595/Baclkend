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

import com.mindtree.wehealu.dao.UserDao;
import com.mindtree.wehealu.entity.Login;
import com.mindtree.wehealu.entity.User;

/**
 * @author M1042945
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-beans.xml")
public class UserDaoImplTest {

	@Autowired
	UserDao userDao;
	/**
	 * @throws java.lang.Exception
	 */
	//@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.daoImpl.UserDaoImpl#getSessionFactory()}.
	 */
	//@Test
	public final void testGetSessionFactory() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.daoImpl.UserDaoImpl#setSessionFactory(org.hibernate.SessionFactory)}.
	 */
	//@Test
	public final void testSetSessionFactory() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.daoImpl.UserDaoImpl#addUser(com.mindtree.weHealU.entity.User)}.
	 */
	//@Test
	public final void testAddUser() {
		 // TODO
		User user=new User();
		Login login=new Login();
		user.setUserAadhar("308411252221");
		user.setUserContact("9879879876");
		user.setUserName("siddesh");
		login.setAccountStatus(1);
		login.setEmail("ani@gmail.com");
		login.setPassword("siddesh@123");
		login.setUser_type(0);
		user.setUserLogin(login);
		assertEquals(true,userDao.addUser(user));
		
		
		
	}
	
	@Test
	public final void testGetUser() {
		 System.out.println(userDao.getUser(1));
	}

}
