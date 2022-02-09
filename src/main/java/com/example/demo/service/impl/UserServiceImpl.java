package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.User;
import com.example.demo.repositories.UserRepo;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public User getUser(Integer id) {
		return userRepo.findById(id).get();
	}

	@Override
	public Iterable<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User updateUser(User user) {
		User oldUser = userRepo.findById(user.getId()).get();
		userRepo.save(new User(oldUser.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPublications()));
		return userRepo.findById(oldUser.getId()).get();
	}

	@Override
	public void deleteUser(Integer id) {

	}

	@Override
	public User createUser(User user) {
		userRepo.save(user);
		return userRepo.findById(user.getId()).get();
	}

}
