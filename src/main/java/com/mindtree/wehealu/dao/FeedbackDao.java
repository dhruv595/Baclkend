package com.mindtree.wehealu.dao;


import com.mindtree.wehealu.entity.FeedbackEntity;

import java.util.List;



public interface FeedbackDao {

	public boolean addReview(FeedbackEntity feedbackEntity);
	public List<FeedbackEntity> getFeedback();
	public List<FeedbackEntity> getDoctorFeedback();
	public List<FeedbackEntity> getLogFeedback(); 
}
