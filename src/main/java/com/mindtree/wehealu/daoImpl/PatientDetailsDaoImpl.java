package com.mindtree.wehealu.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.wehealu.dao.PatientDetailsDao;
import com.mindtree.wehealu.dao.UserDao;
import com.mindtree.wehealu.entity.UploadHistory;
import com.mindtree.wehealu.entity.User;

@Repository
@Transactional
public class PatientDetailsDaoImpl implements PatientDetailsDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private UserDao userDao;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void uploadHistory(User user) 
	{
		
		Session session = this.sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		UploadHistory uploadHistory=new UploadHistory();
		uploadHistory.setUser(userDao.getUser(user.getUserLoginId()));
		uploadHistory.setFile(user.getUserName());
		session.saveOrUpdate(uploadHistory);
		trx.commit();
		session.close();

	}
	public List<UploadHistory> getUploadHistory(User user)
	{
		Session session = sessionFactory.openSession();
		String hql = "from UploadHistory where userLoginId = :id ";
		Query<?> query = session.createQuery(hql);
		query.setParameter("id", user.getUserLoginId());
		List<UploadHistory> fileList = (List) query.getResultList();
		session.close();
		return (ArrayList<UploadHistory>) fileList;
	}
	
	public UploadHistory getObject(User user)
	{
		Session session = sessionFactory.openSession();
		String hql = "from UploadHistory where userLoginId = :id and file= :file ";
		Query<?> query = session.createQuery(hql);
		query.setParameter("id", user.getUserLoginId());
		query.setParameter("file", user.getUserName());
		UploadHistory uploadHistory =  (UploadHistory)query.getSingleResult();
		session.close();
		return uploadHistory;
	}
	
	public void deleteUploadHistory(User user)
	{
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		UploadHistory uploadHistory=this.getObject(user);
		System.out.println(uploadHistory);
		session.delete(uploadHistory);
		trx.commit();
		session.close();

	}

}
