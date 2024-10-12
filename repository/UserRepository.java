package com.venturingdigital.security.rbac.repository;

import java.util.Optional;

import com.venturingdigital.security.rbac.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	  Optional<User> findByUsername(String username);
	  
	  

}
