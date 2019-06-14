package com.spring.security.service;

import java.util.List;

import com.spring.security.model.User;

public interface UserService {

	public User getUser(String username);

	public List<User> getAllUsers();

	public String addUser(User user);

	public int updateUser(User user);

	public int deleteUser(String username);
}
