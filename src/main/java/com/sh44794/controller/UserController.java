package com.sh44794.controller;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sh44794.model.User;
import com.sh44794.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.OPTIONS }, allowedHeaders = { "Content-Type", "X-Requested-With", "accept", "Origin",
				"Access-Control-Request-Method", "Access-Control-Request-Headers" })
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private Environment environment;

	@Autowired
	private DataSource dataSource;

	@RequestMapping(path = "/info", method = RequestMethod.GET)
	public String test() {
		StringBuilder sb = new StringBuilder();
		sb.append("Profili: ").append(String.join(", ", environment.getActiveProfiles()));
		sb.append(System.lineSeparator());
		try {
			sb.append("DataSource; ").append(dataSource.getConnection().getMetaData().getURL().toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

	@RequestMapping(path = "/hello", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public User hello() {
		User u = new User();
		u.setFirstName("ime");
		u.setLastName("prezime");
		u.setUsername("bbb");
		return userService.saveUser(u);
	}

	@RequestMapping(path = "/hello2", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public User hello2() {
		User u = new User();
		u.setId(2L);
		u.setFirstName("ime2");
		u.setLastName("prezime2");
		u.setUsername("bbb2");
		return userService.saveUser(u);
	}

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<User> getAllUsers() {
		return userService.getAll();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public User findById(@PathVariable long id) {
		return userService.findById(id);
	}

	@RequestMapping(path = "/firstNameLike/{firstName}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<User> findByFirstNameLike(String firstName) {
		return userService.findByFirstNameLike(firstName);
	}

	@RequestMapping(path = "/firstName/{firstName}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public User findByFirstName(String firstName) {
		return userService.findByFirstName(firstName);
	}

	@RequestMapping(path = "/lastNameLike/{lastName}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<User> findByLastNameLike(String lastName) {
		return userService.findByLastNameLike(lastName);
	}

	@RequestMapping(path = "/lastName/{lastName}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public User findByLastName(String lastName) {
		return userService.findByLastName(lastName);
	}

	@RequestMapping(path = "/username/{username}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public User findByUsername(String username) {
		return userService.findByUsername(username);
	}

	@RequestMapping(method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@RequestMapping(path="/postTest", method = RequestMethod.POST,
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<User> saveUserAndReturnAll(@RequestBody User user) {
		userService.saveUser(user);
		return getAllUsers();
	}

}
