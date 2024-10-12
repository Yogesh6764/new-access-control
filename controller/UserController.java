package com.venturingdigital.security.rbac.controller;

import java.util.List;
import java.util.Optional;

import com.venturingdigital.security.rbac.model.Role;
import com.venturingdigital.security.rbac.model.User;
import com.venturingdigital.security.rbac.service.PermissionCheck;
import com.venturingdigital.security.rbac.service.RoleService;
import com.venturingdigital.security.rbac.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
	 private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	    
	    private final UserService userService;
	    private final RoleService roleService;
	    private final PermissionCheck permissionCheck;

	    @Autowired
	    public UserController(UserService userService, RoleService roleService, PermissionCheck permissionCheck) {
	        this.userService = userService;
	        this.roleService = roleService;
	        this.permissionCheck = permissionCheck;
	    }

	    @PostMapping("/users/{username}/roles")
	    public ResponseEntity<String> assignRoleToUser(@PathVariable String username, @RequestBody String roleName) {
	        Optional<User> userOpt = userService.findByUsername(username);
	        Optional<Role> roleOpt = roleService.findByRoleName(roleName);

	        if (userOpt.isPresent() && roleOpt.isPresent()) {
	            User user = userOpt.get();
	            Role role = roleOpt.get();
	          
	            for (Role userRole : user.getRoles()) {
	                if (permissionCheck.hasPermission(userRole, "assignRole")) {
	                    user.getRoles().add(role);
	                    userService.saveUser(user);
	                    logger.info("Assigned role {} to user {}", roleName, username);
	                    return ResponseEntity.ok("Role assigned successfully");
	                }
	            }

	            logger.error("User {} does not have permission to assign roles", username);
	            return ResponseEntity.status(403).body("User does not have permission to assign roles");
	        } else {
	            logger.error("Invalid user or role for user: {} and role: {}", username, roleName);
	            return ResponseEntity.badRequest().body("Invalid user or role");
	        }
	    }

	    @GetMapping("/users")
	    public ResponseEntity<List<User>> getAllUsers() {
	        List<User> users = userService.findAllUsers(); // Fetch all users
	        return ResponseEntity.ok(users); // Return the list of users
	    }
}