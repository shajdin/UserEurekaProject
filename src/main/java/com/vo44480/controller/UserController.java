package com.vo44480.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vo44480.model.User;
import com.vo44480.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path="/test", method=RequestMethod.GET)
	public String test(){
		return "Hello worlddd";
	}
	
	@RequestMapping(path="/hello", method=RequestMethod.GET)
	public User hello() {
		User u = new User();
		u.setFirstName("ime");
		u.setLastName("prezime");
		u.setNumOfDogs(5);
		u.setUsername("bbb");
		return userService.saveUser(u);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.GET)
	public User findById(long id) {
		return userService.findById(id);
	}

	@RequestMapping(path="/firstNameLike/{firstName}", method=RequestMethod.GET)
	public List<User> findByFirstNameLike(String firstName) {
		return userService.findByFirstNameLike(firstName);
	}

	@RequestMapping(path="/firstName/{firstName}", method=RequestMethod.GET)
	public User findByFirstName(String firstName) {
		return userService.findByFirstName(firstName);
	}

	@RequestMapping(path="/lastNameLike/{lastName}", method=RequestMethod.GET)
	public List<User> findByLastNameLike(String lastName) {
		return userService.findByLastNameLike(lastName);
	}

	@RequestMapping(path="/lastName/{lastName}", method=RequestMethod.GET)
	public User findByLastName(String lastName) {
		return userService.findByLastName(lastName);
	}

	@RequestMapping(path="/username/{username}", method=RequestMethod.GET)
	public User findByUsername(String username) {
		return userService.findByUsername(username);
	}

	@RequestMapping(method=RequestMethod.POST)
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

}
