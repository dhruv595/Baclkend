package com.mindtree.wehealu.daoImpl;

import java.util.List;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.management.Query;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.wehealu.dao.UserDao;
import com.mindtree.wehealu.entity.Doctor;
import com.mindtree.wehealu.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// -------------------------------------------------------------------

	public boolean addUser(User user) {

		boolean ret;
		try {
			Session session = sessionFactory.openSession();
			Transaction trx = session.beginTransaction();

			session.save(user);
			final String from = "wehealyouhelp@gmail.com";
			final String password = "wehealyou";
			String to = user.getUserLogin().getEmail();
			String sub = "Welcome to We Heal U";
			String msg = "Hi" + " " + user.getUserName() + "," + "\nWelcome to We Heal U.\n"
					+ "You have successfully registered with our platform..\n" + "\nThanks and regards,"
					+ "\nWe Heal U";
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			// get Session

			javax.mail.Session sessions = javax.mail.Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, password);
				}
			});
			// compose message
			try {
				MimeMessage message = new MimeMessage(sessions);
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject(sub);
				message.setText(msg);
				// send message
				Transport.send(message);
				System.out.println("message sent successfully");
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			trx.commit();
			ret = true;
			session.close();

		} catch (Exception ex) {
			ret = false;
		}

		return ret;

	}

	// --------------------------------------------------------------------
	public User getUser(int userId) {
		Session session = this.sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		String hql = "From User where userLoginId=:id";
		org.hibernate.query.Query<?> query = session.createQuery(hql);
		query.setParameter("id", userId);
		User u = new User();
		u = (User) query.uniqueResult();
		trx.commit();
		session.close();
		return u;

	}

	// --------------------------------------------------------------------------
	@Override
	public List<User> getUserList() {
		Session session = this.sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		String hql="from User";
		org.hibernate.query.Query query = session.createQuery(hql);
		List user = query.list();
		session.close();
		return user;

	}

	// ----------------- ANIMESH ----------------------------------------------
	@Override
	public boolean updateUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		session.saveOrUpdate(user);
		trx.commit();
		session.close();
		return true;
	}

}
