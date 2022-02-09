package com.example.demo.service;

import com.example.demo.pojo.User;

public interface UserService {

	public User getUser(Integer id);
	
	public Iterable<User> getAllUsers();
	
	public User updateUser(User user);
	
	public void deleteUser(Integer id);
	
	public User createUser(User user);
}
