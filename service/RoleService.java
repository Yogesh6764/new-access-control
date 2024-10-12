package com.venturingdigital.security.rbac.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.venturingdigital.security.rbac.model.Role;
import com.venturingdigital.security.rbac.repository.RoleRepository;
import com.venturingdigital.security.rbac.security.Action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
	

	@Autowired
	private RoleRepository roleRepository;
	    
	// Find a role by its name
	public Optional<Role> findByRoleName(String roleName) {
		// Update method to call findByRoleName instead of findByName
		return roleRepository.findByRoleName(roleName);
	}
	    
	// Find a role by its ID
	public Optional<Role> findRoleById(Long id) {
		return roleRepository.findById(id);
	}
	    
	// Save a role to the database
	public void saveRole(Role role) {
		roleRepository.save(role);
	}

	// Method to initialize roles with permissions
	public void initializeRoles() {
		// Create a set of permissions for the admin role
		Set<Action> adminPermissions = new HashSet<>();
		adminPermissions.add(Action.CREATE_USER);
		adminPermissions.add(Action.ASSIGN_ROLE);
		adminPermissions.add(Action.VIEW_REPORTS);

		// Create an Admin Role and assign permissions
		Role adminRole = new Role();
		adminRole.setRoleName("ADMIN");
		adminRole.setPermissions(adminPermissions);

		// Save the admin role
		roleRepository.save(adminRole);
		
		// Define permissions for the USER role
		Set<Action> userPermissions = new HashSet<>();
		userPermissions.add(Action.VIEW_REPORTS); // Only view permissions for regular users

		// Create and save the USER role
		Role userRole = new Role();
		userRole.setRoleName("USER");
		userRole.setPermissions(userPermissions);
		roleRepository.save(userRole);
	}
	}
