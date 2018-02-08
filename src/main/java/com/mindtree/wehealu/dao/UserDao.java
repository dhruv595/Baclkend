package com.mindtree.wehealu.dao;

import java.util.List;

import com.mindtree.wehealu.entity.User;

public interface UserDao {
	
	public boolean addUser(User user);
	public User getUser(int userId);
	public List<User> getUserList();
	public boolean updateUser(User user);

}
