package com.venturingdigital.security.rbac.service;



import java.util.List;
import java.util.Optional;

import com.venturingdigital.security.rbac.model.User;
import com.venturingdigital.security.rbac.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	 @Autowired
	    private UserRepository userRepository;

	    public Optional<User> findByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }

	    public void saveUser(User user) {
	        userRepository.save(user);
	    }

	    // Add the findAllUsers() method here
	    public List<User> findAllUsers() {
	        return userRepository.findAll(); // Fetches all users from the database
	    }
	    
	 }

