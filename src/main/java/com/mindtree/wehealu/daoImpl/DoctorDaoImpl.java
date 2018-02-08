package com.mindtree.wehealu.daoImpl;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.wehealu.dao.DoctorDao;
import com.mindtree.wehealu.dto.LoginDto;
import com.mindtree.wehealu.entity.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// ------------------------------------------------------------------------------------------------

	public Doctor getDoctor(int doctorId) {
		Session session = getSessionFactory().openSession();
		String hql = "from Doctor where userLoginId = :id";
		Query<?> query = session.createQuery(hql);
		query.setParameter("id", doctorId);
		Doctor doctor = (Doctor) query.uniqueResult();
		session.close();
		return doctor;
	}

    //M1043042
    //Siddesh
	public boolean addDoctor(Doctor doctor) {

		boolean ret;
		try {
			Session session = sessionFactory.openSession();
			Transaction trx = session.beginTransaction();

			session.saveOrUpdate(doctor);
			trx.commit();
			ret = true;
			session.close();

		} catch (Exception ex) {
			ret = false;
		}
		final String from = "wehealyouhelp@gmail.com";
		final String password = "wehealyou";
		String to = doctor.getUserLogin().getEmail();
		String sub = "Welcome to We Heal U";
		String msg = "Hi" + " " + doctor.getDoctorName() + "," + "\nWelcome to We Heal U.\n"
				+ "You have successfully registered with our platform..\n" + "\nThanks and regards," + "\nWe Heal U";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		// get Session

		javax.mail.Session session = javax.mail.Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		return true;

	}

	public List<Doctor> getDoctorByCategory(int categoryId) {
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("select subCategoryId from SubCategory where categoryId = :id");
		query.setParameter("id", categoryId);
		List<Integer> subCategoryIdList = (List<Integer>) query.getResultList();
		query = session.createQuery("from Doctor where subCategoryId in (:ids) and status=2");
		query.setParameter("ids", subCategoryIdList);
		List<Doctor> doctorList = (List<Doctor>) query.getResultList();
		session.close();
		return doctorList;
	}

	@Override
	public boolean addDoctorSecond(Doctor doctor) {
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		session.saveOrUpdate(doctor);
		trx.commit();
		session.close();
		return true;
	}


	public List<Doctor> getDoctorList(String doctorName, String contact) {
		System.out.println(doctorName);
		Session session = sessionFactory.openSession();
		Query<?> query = session.createQuery("from Doctor where status!=0");

		List<Doctor> doctorList = (List<Doctor>) query.getResultList();
		session.close();
		return doctorList;
	}

	

	@Override
	public List<Doctor> getDoctorList() {
		
		Session session=sessionFactory.openSession();
		Transaction trx=session.beginTransaction();
		String hql="from Doctor";
		Query<?> query = session.createQuery(hql);
		List<Doctor> doctor = (List<Doctor>)query.list();
		session.close();
		return doctor;

	}

	////////////////////////////////////////////////verify doctor///////////////////////
	@Override
	public int updateDoctor(LoginDto loginDto)
	{
		Session session = this.sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		  Query qry = session.createQuery("update Doctor  set status=:st where userLoginId=:id");
				           qry.setParameter("st",loginDto.getStatus());
				           qry.setParameter("id",loginDto.getUserLoginId());
				           int res = qry.executeUpdate();
				           session.close();
		return res;
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		session.saveOrUpdate(doctor);
		trx.commit();
		session.close();

		return false;

	}
	
	public void activateDoctor(Doctor doctor) {
		doctor.setStatus(1);
		System.out.println(doctor);
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		session.saveOrUpdate(doctor);
		trx.commit();
		session.close();

	}
	public void deactivateDoctor(Doctor doctor) {
		doctor.setStatus(2);
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		session.saveOrUpdate(doctor);
		trx.commit();
		session.close();
	}
}
