package com.mindtree.wehealu.entity;


import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mindtree.wehealu.entity.User;

@Entity
@Table(name="UserFeedback")
public class FeedbackEntity
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int feedbackId;
	

	@ManyToOne
	@JoinColumn(nullable=false,name="userLoginId")
	private User user;
	
	@Column(nullable=false,length=200)
	private String feedbackStatement;
	
	
	@Column(nullable=true,length=200)
	private String feedbackService;
	
	@Column(nullable=true,length=200)
	private String feedbackSuggestion;
	
	
	@Column(nullable=false,length=1)
	private int feedbackRating;


	public String getFeedbackService() {
		return feedbackService;
	}

	public void setFeedbackService(String feedbackService) {
		this.feedbackService = feedbackService;
	}

	public String getFeedbackSuggestion() {
		return feedbackSuggestion;
	}

	public void setFeedbackSuggestion(String feedbackSuggestion) {
		this.feedbackSuggestion = feedbackSuggestion;
	}

	@ManyToOne
	@JoinColumn(name="doctorId",nullable=true)
	private Doctor doctor;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public int getFeedbackId()
	{
		return feedbackId;
	}
	
	public void setFeedbackId(int feedbackId)
	{
		this.feedbackId = feedbackId;
	}
	
	public String getFeedbackStatement()
	{
		return feedbackStatement;
	}
	
	public void setFeedbackStatement(String feedbackStatement)
	{
		this.feedbackStatement = feedbackStatement;
	}
	
	public int getFeedbackRating()
	{
		return feedbackRating;
	}
	
	public void setFeedbackRating(int feedbackRating)
	{
		this.feedbackRating = feedbackRating;
	}

	@Override
	public String toString() {
		return "FeedbackEntity [feedbackId=" + feedbackId + ", user=" + user + ", feedbackStatement="
				+ feedbackStatement + ", feedbackRating=" + feedbackRating + ", doctor=" + doctor + ",feedbackService="+feedbackService+",feedbackSuggestion="+feedbackSuggestion+"]";
	}
}
