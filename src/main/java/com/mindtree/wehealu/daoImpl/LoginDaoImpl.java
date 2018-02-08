package com.mindtree.wehealu.daoImpl;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import com.mindtree.wehealu.dao.LoginDao;
import com.mindtree.wehealu.dto.LoginDto;
import com.mindtree.wehealu.entity.Doctor;
import com.mindtree.wehealu.entity.Login;
import com.mindtree.wehealu.entity.User;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
int userid;
	public Object validate(LoginDto loginDto) {
		Session session = this.sessionFactory.openSession();
		Transaction trx = session.beginTransaction();		
		String hql = "from " + Login.class.getName() + "  where email=:un ";
		Query<Login> query = session.createQuery(hql);
		query.setParameter("un", loginDto.getEmail());
		List<Login> list = query.list();
		System.out.println(list.size());
		if(list.size()==0)
		{
			session.close();
			return true;
		}
		for(Login ld : list)
		{
			System.out.println(ld.getEmail());
			loginDto.setUser_type(ld.getUserType());
		loginDto.setHash(ld.getPassword());
		}
		
		boolean flag=passwordcheck(loginDto);
		//System.out.println(flag);
		if(flag)
		{
		for (Login l : list) {
			
				switch (l.getUserType()) {
				case 0:
					String sql = "from User where userLoginId=" + (l.getUserLoginId());
					User users = (User) session.createQuery(sql).getSingleResult();
					session.close();
					return users;
				case 1:
					System.out.println(l.getUserLoginId());
					String sql1 = "from Doctor where userLoginId=" + l.getUserLoginId();
					Doctor doctor = (Doctor) session.createQuery(sql1).getSingleResult();
					session.close();
					return doctor;
				case 2:
					String sql2 = "from Login where userLoginId=" + (l.getUserLoginId());
					Login login= (Login) session.createQuery(sql2).getSingleResult();
					session.close();
					
					return login;

				default:
					return null;
				}
		}

		session.close();
		}
		return false;
	}
	//////////////////////////////hashcode check/////////////////////////////////
	public boolean passwordcheck(LoginDto loginDto) 
    {
			
       String originalPassword = loginDto.getPassword();
      // System.out.println(originalPassword);
       String generatedSecuredPasswordHash =loginDto.getHash();
       //System.out.println(generatedSecuredPasswordHash);
       if(generatedSecuredPasswordHash!=null){
	        boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
	        System.out.println(matched);
	      return matched;
	      }
       return false;
	}
/////////////////////////////////////////email OTP//////////////////////////
	public Object otpcheck(LoginDto loginDto) {
		Random r = new Random();
		String j=""+r.nextInt(9999);
    	if(j.length()==3)
    	{
    		j="0"+j;
    	} 
		
		final String from="wehealyouhelp@gmail.com";
		final String password="wehealyou";
		String to=loginDto.getEmail();
		String sub="Forgot Password";
		String msg="OTP:"+j;
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
		return j;
	}
/////////////phone otp/////////////////////////////
	public Object phnotp(LoginDto loginDto)
	{
		String phone=" ";
		Session session = this.sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		if(loginDto.getUser_type()==1)
		{
		
		String hql = "select u.userContact from User u inner join Login l on u.userLoginId=l.userLoginId   WHERE l.email=:un";
		Query query = session.createQuery(hql);
		query.setParameter("un", loginDto.getEmail());
		 phone=(String) query.getSingleResult();
		}
		else if(loginDto.getUser_type()==0)
		{
		String hql = "select d.contact from Doctor d inner join Login l on d.userLoginId=l.userLoginId   WHERE l.email=:un";
		Query query = session.createQuery(hql);
		query.setParameter("un", loginDto.getEmail());
		 phone=(String) query.getSingleResult();
		}
		Random r = new Random();

        String j = "" + r.nextInt(9999);
        if (j.length() == 3)
        {
              j = "0" + j;
        }
        
        String msgs = "Here%20is%20your%20otp%20for%20verification:" + j + "%0ADon't%20share%20with%20anyone";

        
try {
              HttpClient client = new DefaultHttpClient();

              HttpGet request = new HttpGet("http://msg.msgclub.net/rest/services/sendSMS/sendGroupSms?AUTH_KEY=97a852e97e6976d4c8de66865715c59&message="+msgs+"&senderId=Dhruvs&routeId=7&mobileNos="+phone+"&smsContentType=english");

              HttpResponse response = client.execute(request);

              BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

              String line = "";

              while ((line = rd.readLine()) != null) {

                    System.out.println(line);

              }
}

catch (Exception ex) {
              ex.printStackTrace();

        }


		session.close();
		return j;
	}
	/////////////////////////////////////////////////
	
	
	/////////////////update password///////////////////////
	public Object updatePassword(LoginDto loginDto) {
		Session session = this.sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		  Query qry = session.createQuery("update Login  set password=:pw where email=:email");
				           qry.setParameter("pw",loginDto.getHash());
				           qry.setParameter("email",loginDto.getEmail());
				           int res = qry.executeUpdate();
				           session.close();
		return res;
	}
	///////////////////////////////////////////////////////////////////

	@Override
	public Object updateStatus(Login login) {
		
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		session.saveOrUpdate(login);		
		trx.commit();
		session.close();
		return login;
	}

}
