package com.mindtree.wehealu.daoImpl;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindtree.wehealu.dao.FeedbackDao;
import com.mindtree.wehealu.entity.FeedbackEntity;

@Repository("feedbackdao")
public class FeedbackDaoImpl implements FeedbackDao{

	@Autowired
	private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean addReview(FeedbackEntity feedbackEntity)
	{
    	Session session = sessionFactory.openSession();
    	Transaction tx = null;
    	try
    	{
    		tx = session.beginTransaction();
    		session.save(feedbackEntity);
    		tx.commit();
    	}
    	catch(Exception e)
    	{ 
            if(tx!=null)
            {
              tx.rollback();
              throw e;
            }
    	}
    	finally
    	{
    		session.close();
    	}
		return true;
	}
	
	public List<FeedbackEntity> getFeedback(){
		
		if(getSessionFactory()==null)
			System.out.println("its null");
		Session session = getSessionFactory().openSession(); 
		String hql = "select u.userName,f.feedbackRating,f.feedbackStatement,f.feedbackService from FeedbackEntity f "
				+ "inner join f.user u";
		Query query = session.createQuery(hql);
		List feedback = query.list();
		session.close();
		return feedback;
	}
		
		
	public List<FeedbackEntity> getDoctorFeedback(){
		
		if(getSessionFactory()==null)
			System.out.println("its null");
		Session session = getSessionFactory().openSession();
		String hql = "select f.feedbackStatement from FeedbackEntity f "
				+ "inner join f.doctor d"
				+ "inner join f.user u where u.user_login_id=1";
		Query query = session.createQuery(hql); 
		List feedback = query.list();
		session.close();
		return feedback;
	}
	
	
	public List<FeedbackEntity> getLogFeedback()
	{
		if(getSessionFactory()==null)
			System.out.println("its null");
		Session session = getSessionFactory().openSession(); 
		String hql = "select u.userName,f.feedbackRating,f.feedbackStatement,f.feedbackService from FeedbackEntity f "
				+ "inner join f.user u order by feedbackId desc";
		Query query = session.createQuery(hql);
		query.setMaxResults(2);
		List feedback = query.list();
		session.close();
		return feedback;
	} 
	
	
	
}
