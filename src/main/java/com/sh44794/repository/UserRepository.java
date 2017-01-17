package com.sh44794.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sh44794.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByFirstNameLike(String firstName);
	User findByFirstName(String firstName);
	
	List<User> findByLastNameLike(String lastName);
	User findByLastName(String lastName);
	
	User findByUsername(String username);

}
