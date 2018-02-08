package com.mindtree.wehealu.entity;

import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UploadHistory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int UploadHistoryId;
	
	@ManyToOne
	@JoinColumn(name="userLoginId",nullable=true)
	private User user;
	
	private String file;

	public int getUploadHistoryId() {
		return UploadHistoryId;
	}

	@Override
	public String toString() {
		return "UploadHistory [UploadHistoryId=" + UploadHistoryId + ", user=" + user + ", file=" + file + "]";
	}

	public void setUploadHistoryId(int uploadHistoryId) {
		UploadHistoryId = uploadHistoryId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
	
	
}
