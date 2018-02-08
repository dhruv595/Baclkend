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

import com.mindtree.wehealu.controller.DoctorController;
import com.mindtree.wehealu.dto.LoginDoctorMaindto;
import com.mindtree.wehealu.dto.LoginDoctordto;
import com.mindtree.wehealu.entity.Category;
import com.mindtree.wehealu.entity.SubCategory;

/**
 * @author M1042945
 *
 */

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-beans.xml")
public class DoctorControllerTest {

	@Autowired
	DoctorController doctorController;
	
	static LoginDoctordto loginDoctor;
	static LoginDoctorMaindto loginDoctorMain;
	static SubCategory subCategory;
	static Category category;
	
	@Before
	public  void setUpBefore() throws Exception {
		loginDoctor=new LoginDoctordto();
		loginDoctor.setAccountStatus(1);
		loginDoctor.setDoctorEmail("a7678@gmail.com");
		loginDoctor.setDoctorName("abhinav");
		loginDoctor.setDoctorPassword("abhinav@123");
		loginDoctor.setUserStatus(0);
		loginDoctor.setUserType(1);
		
		
		loginDoctorMain=new LoginDoctorMaindto ();
		subCategory=new SubCategory();
		category=new Category(); 
		loginDoctorMain.setDoctorLoginId(84);
		loginDoctorMain.setDoctorArea("chandaka");
		loginDoctorMain.setDoctorCity("bhubaneshwar");
		loginDoctorMain.setDoctorContact("9879879870");
		loginDoctorMain.setDoctorExp("0-3");
		loginDoctorMain.setDoctorGender("M");
		loginDoctorMain.setDoctorMciid("m1043042");
		loginDoctorMain.setDoctorName("abhinav");
		loginDoctorMain.setDoctorQualification("MBBS");
		loginDoctorMain.setDoctorState("odisha");
		loginDoctorMain.setDoctorStatus(1);
		loginDoctorMain.setDoctorTime("18:00 - 20:00");
		loginDoctorMain.setDoctorWorkdays("MTThF");
		loginDoctorMain.setDoctorZip(789870);
		
		category.setCategory_name("Heart");
		category.setCategoryId(1);
		
		subCategory.setSubCategoryName("cardiologist");
		subCategory.setCategory(category);
		
		loginDoctorMain.setSubcategory(subCategory);
		
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.controller.DoctorController#getZipcodeService()}.
	 */
	@Test
	public final void testGetZipcodeService() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.controller.DoctorController#setZipcodeService(com.mindtree.weHealU.service.ZipcodeService)}.
	 */
	@Test
	public final void testSetZipcodeService() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.controller.DoctorController#getDoctorService()}.
	 */
	@Test
	public final void testGetDoctorService() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.controller.DoctorController#setDoctorSevice(com.mindtree.weHealU.service.DoctorService)}.
	 */
	@Test
	public final void testSetDoctorSevice() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.controller.DoctorController#getDoctorByCategory(int)}.
	 */
	@Test
	public final void testGetDoctorByCategory() {
		fail("Not yet implemented"); // TODO
	}

	

	/**
	 * Test method for {@link com.mindtree.weHealU.controller.DoctorController#postDoctor(com.mindtree.weHealU.dto.LoginDoctordto)}.
	 */
	@Test
	public final void testPostDoctorLoginDoctordto() {
		assertEquals(loginDoctor,doctorController.postDoctor(loginDoctor));
		
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.controller.DoctorController#postDoctorsecond(com.mindtree.weHealU.dto.LoginDoctorMaindto)}.
	 */
	@Test
	public final void testPostDoctorsecond() {
		assertEquals(loginDoctorMain,doctorController.postDoctorsecond(loginDoctorMain));
	}

	/**
	 * Test method for {@link com.mindtree.weHealU.controller.DoctorController#getAddressList()}.
	 */
	@Test
	public final void testGetAddressList() {
		fail("Not yet implemented"); // TODO
	}

}
