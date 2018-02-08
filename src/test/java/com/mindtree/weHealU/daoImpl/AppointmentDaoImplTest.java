/**
 * 
 */
package com.mindtree.weHealU.daoImpl;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mindtree.wehealu.dao.AppointmentDao;
import com.mindtree.wehealu.dao.DoctorDao;
import com.mindtree.wehealu.dao.UserDao;
import com.mindtree.wehealu.daoImpl.AppointmentDaoImpl;
import com.mindtree.wehealu.entity.Appointment;
import com.mindtree.wehealu.entity.Doctor;
import com.mindtree.wehealu.entity.User;

/**
 * @author M1042945
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-beans.xml")

public class AppointmentDaoImplTest {

	@Autowired
	AppointmentDao appointmentDao;
	
	@Autowired
	DoctorDao doctorDao;
	
	@Autowired
	UserDao userDao;
	
	SessionFactory sessionFactory;
	
	@Autowired
	AppointmentDaoImpl appointmentDaoImpl;
	
	Appointment appointment= new Appointment();
	Doctor doctor= new Doctor();
	User user = new User();
	
	public AppointmentDao getAppointmentDao() {
		return appointmentDao;
	}

	public void setAppointmentDao(AppointmentDao appointmentDao) {
		this.appointmentDao = appointmentDao;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.daoImpl.AppointmentDaoImpl#getSessionFactory()}.
	 */
	
    //@Test
	public final void testGetSessionFactory() {
		sessionFactory=appointmentDaoImpl.getSessionFactory();
		assertEquals(true, sessionFactory!=null);
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.daoImpl.AppointmentDaoImpl#setSessionFactory(org.hibernate.SessionFactory)}.
	 */
	//@Test
	public final void testSetSessionFactory() {
		appointmentDaoImpl.setSessionFactory(sessionFactory);
		assertEquals(sessionFactory, appointmentDaoImpl.getSessionFactory());
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.daoImpl.AppointmentDaoImpl#getAppointment(int)}.
	 */
	@Test
	public final void testGetAppointment() {
	//	fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.daoImpl.AppointmentDaoImpl#addAppointment(com.mindtree.weHealU.entity.Appointment)}.
	 */
	@Test
	public final void testAddAppointment() {
		//appointment.setAppointmentId(2);
		appointment.setAppointmentDate("2018-01-09");
		appointment.setAppointmentSlot("3-3");
		appointment.setAppointmentStatus(1);
		doctor.setUserLoginId(5);
		appointment.setDoctor(doctor);
		user.setUserLoginId(1);
		appointment.setUser(user);
		assertEquals(true, appointmentDao.addAppointment(appointment));
	}
	
	//@Test
	public final void testCancelAppointment()
	{
		appointment=appointmentDao.getAppointment(1);
		assertEquals(true,appointmentDao.cancelAppointment(appointment));
	}
	
	//@Test
	public final void testGetAppointmentList()
	{
		
		assertSame(appointmentDao.getAppointmentList(1),appointmentDao.getAppointmentList(1));
	}
	

	//@Test
	public final void testUpcomingAppointment()
	{
		
	}
}
