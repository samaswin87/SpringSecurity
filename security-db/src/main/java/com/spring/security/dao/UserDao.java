package com.spring.security.dao;

import java.util.List;

import com.spring.security.model.User;

public interface UserDao {

	public User getUser(String username);

	public List<User> getAllUsers();

	public String addUser(User user);

	public int updateUser(User user);

	public int deleteUser(String username);
	
}
