package com.mindtree.wehealu.service;


import com.mindtree.wehealu.entity.FeedbackEntity;

import java.util.List;



public interface FeedbackService {

	public boolean addService(FeedbackEntity feedbackEntity);
	public List<FeedbackEntity> getFeedbackService();
	public List<FeedbackEntity> getDoctorFeedbackService();
	public List<FeedbackEntity> getLogFeedbackService(); 
	

}
