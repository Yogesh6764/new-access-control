package com.venturingdigital.security.rbac.repository;



import com.venturingdigital.security.rbac.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.venturingdigital.security.rbac.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByRoleName(String roleName); 
}	