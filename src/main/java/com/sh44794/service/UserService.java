package com.sh44794.service;

import java.util.List;

import com.sh44794.model.User;

public interface UserService {
	
	User findById(Long id);
	
	List<User> getAll();
	
	List<User> findByFirstNameLike(String firstName);
	User findByFirstName(String firstName);
	
	List<User> findByLastNameLike(String lastName);
	User findByLastName(String lastName);
	
	User findByUsername(String username);
	
	User saveUser(User user);

}
