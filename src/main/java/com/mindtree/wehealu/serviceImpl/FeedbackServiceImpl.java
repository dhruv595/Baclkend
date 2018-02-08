package com.mindtree.wehealu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.mindtree.wehealu.dao.FeedbackDao;
import com.mindtree.wehealu.entity.FeedbackEntity;
import com.mindtree.wehealu.service.FeedbackService;



@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	@Qualifier("feedbackdao")
	FeedbackDao feedbackDao;
	
	public boolean addService(FeedbackEntity feedbackEntity)
	{
		feedbackDao.addReview(feedbackEntity);
		return true;
	}
	
	public List<FeedbackEntity> getFeedbackService(){
		
		return (List)feedbackDao.getFeedback();
	}
	
	public List<FeedbackEntity> getDoctorFeedbackService(){
		
		return (List)feedbackDao.getDoctorFeedback();
	}
	 
	public List<FeedbackEntity> getLogFeedbackService()
		{
			return (List)feedbackDao.getLogFeedback();
		} 

	
}
