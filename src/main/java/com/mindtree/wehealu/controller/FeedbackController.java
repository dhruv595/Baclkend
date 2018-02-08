package com.mindtree.wehealu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mindtree.wehealu.entity.FeedbackEntity;
import com.mindtree.wehealu.service.FeedbackService;

// shalini 

@Controller
@EnableWebMvc
@RequestMapping(value = "/feedback")
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;
		
	@RequestMapping(value="/review",method=RequestMethod.POST)
	@ResponseBody
	public Object review(@RequestBody FeedbackEntity feedbackEntity)		
	{
		feedbackService.addService(feedbackEntity);	
		return feedbackEntity.getFeedbackStatement();	
	}
	//returns all the feedbacks
	@ResponseBody
	@RequestMapping(value="/servicereview",method=RequestMethod.GET)
	public List<FeedbackEntity> servicereview(){
		return feedbackService.getFeedbackService();	
	}
	
	
	// returns only two
	@ResponseBody
	@RequestMapping(value="/reviewlog",method=RequestMethod.GET)
	public List<FeedbackEntity> reviewlog(){
		return feedbackService.getLogFeedbackService();	
	} 
	
	@ResponseBody
	@RequestMapping(value="/doctorreview",method=RequestMethod.GET)
	public List<FeedbackEntity> doctorreview(){
		return feedbackService.getDoctorFeedbackService();
	}
}