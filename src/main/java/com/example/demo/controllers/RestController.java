package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.Publication;
import com.example.demo.pojo.User;
import com.example.demo.service.PublicationService;
import com.example.demo.service.PublicationsWrapper;
import com.example.demo.service.UserService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class RestController {

	@Autowired
	UserService userService;
	
	@Autowired
	PublicationService pubService;

	@GetMapping("/users")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	/*
	 * @GetMapping("/users") public @ResponseBody Iterable<User> getAllUsers() {
	 * return userService.getAllUsers(); }
	 */

	@GetMapping("/user")
	public @ResponseBody User getUser(@RequestParam String id) {
		return userService.getUser(Integer.parseInt(id));
	}

//	@GetMapping("/user/add")
//	public @ResponseBody User addUser(@RequestParam String firstName, @RequestParam String lastName,
//			@RequestParam String email) {
//		return userService.createUser(firstName, lastName, email);
//	}
	
	@PostMapping("/user/add")
	public @ResponseBody User addUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	

	@PostMapping("publication/add")
	public void addPublications(@RequestParam String studentId,
			@RequestBody PublicationsWrapper publication) {
		User user = userService.getUser(Integer.parseInt(studentId));
		Publication pub = new Publication(user, publication.title, publication.year);
		user.getPublications().add(pub);
		userService.updateUser(user);
	}
}
