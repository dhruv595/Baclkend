package com.mindtree.wehealu.daoImpl;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.mindtree.wehealu.dao.AppointmentDao;
import com.mindtree.wehealu.entity.Appointment;
import com.mindtree.wehealu.entity.PatientDetails;
import com.mindtree.wehealu.entity.User;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// ------------------------------------------------------------------------------------------------

	public Appointment getAppointment(int appointmentId) {
		Session session = this.sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		String hql = "From Appointment where AppointmentId=:id";
		org.hibernate.query.Query<?> query = session.createQuery(hql);
		query.setParameter("id", appointmentId);
		Appointment a = new Appointment();
		a = (Appointment) query.uniqueResult();
		trx.commit();
		session.close();
		return a;

	}

	public ArrayList<Appointment> getAppointmentList(int userLoginId) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String s = formatter.format(new Date());
		Session session = sessionFactory.openSession();
		String hql = "from Appointment where userLoginId = :id and appointmentStatus=1 and appointmentDate < :appointmentDate";
		Query<?> query = session.createQuery(hql);
		query.setParameter("id", userLoginId);
		query.setParameter("appointmentDate", s);
		List<Appointment> appointmentList = (List) query.getResultList();
		session.close();
		return (ArrayList<Appointment>) appointmentList;

	}

	public ArrayList<Appointment> getUpcomingAppointmentList(int userLoginId) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String s = formatter.format(new Date());
		Session session = sessionFactory.openSession();
		String hql = "from Appointment where userLoginId = :id and appointmentStatus=1 and appointmentDate >= :appointmentDate";
		Query<?> query = session.createQuery(hql);
		query.setParameter("id", userLoginId);
		query.setParameter("appointmentDate", s);
		List<Appointment> appointmentList = (List) query.getResultList();
		session.close();
		return (ArrayList<Appointment>) appointmentList;

	}

	public boolean cancelAppointment(Appointment appointment) {
		boolean ret = true;
		try {
			Session session = sessionFactory.openSession();
			Transaction trx = session.beginTransaction();
			appointment.setAppointmentStatus(0);
			session.saveOrUpdate(appointment);
			trx.commit();
			ret = true;
			session.close();

		} catch (Exception ex) {
			ret = false;
		}
		final String from = "wehealyouhelp@gmail.com";
		final String password = "wehealyou";
		String to = appointment.getUser().getUserLogin().getEmail();
		String sub = "Cancel Appointment";
		String msg = "Your appointment has been successfully cancelled\n" + "\nAppointment Details\n"
				+ "\nAppointment Id:\n" + appointment.getAppointmentId() + "" + "\nAppointment Date\n:"
				+ appointment.getAppointmentDate() + "" + "\nDoctor:\n" + appointment.getDoctor().getDoctorName()
				+ "\nPlace:\n" + appointment.getDoctor().getZipCode().getCity();
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
		return ret;
	}

	@Override
	public boolean addPatient(PatientDetails patient) {
		// sessionFactory.getCurrentSession().saveOrUpdate(patient);
		Session session = this.sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		System.out.println(patient);
		session.saveOrUpdate(patient);
		trx.commit();
		session.close();

		return true;

	}

	public boolean addAppointment(Appointment appointment) {
		// sessionFactory.getCurrentSession().saveOrUpdate(appointment);
		Session session = this.sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		String time = appointment.getAppointmentDate().split("T")[0];
		String[] time2 = time.split("-");
		int increment = Integer.parseInt(time2[2]);
		int month = Integer.parseInt(time2[1]);
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			if (increment == 31) {
				increment = 1;
			} else {

				increment = increment + 1;
				month=month+1;
			}
		} else {
			if (increment == 30) {
				increment = 1;
				month=month+1;
			} else {
				increment = increment + 1;
			}
		}

		String str = time2[0] + "-" + month + "-" + increment;
		appointment.setAppointmentDate(str);

		session.saveOrUpdate(appointment);
		trx.commit();
		session.close();
		return true;
	}

	public List<Appointment> getDoctorUpcomingAppointmentList(int userLoginId) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String s = formatter.format(new Date());
		Session session = sessionFactory.openSession();
		String hql = "from Appointment where doctorId = :id and appointmentStatus=1 and appointmentDate >= :appointmentDate";
		Query<?> query = session.createQuery(hql);
		query.setParameter("id", userLoginId);
		query.setParameter("appointmentDate", s);
		List<Appointment> appointmentList = (List) query.getResultList();
		session.close();
		return (ArrayList<Appointment>) appointmentList;
	}

}
