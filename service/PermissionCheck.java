package com.venturingdigital.security.rbac.service;

import com.venturingdigital.security.rbac.model.Role;

import org.springframework.stereotype.Service;
@Service
public class PermissionCheck {
	 public boolean hasPermission(Role role, String action) {
	        // Check if the role's permissions contain the required action
	        return role.getPermissions() != null && role.getPermissions().contains(action);
	        // return role != null && role.hasPermission(action);
	    }
}
