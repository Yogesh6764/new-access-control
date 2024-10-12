package com.venturingdigital.security.rbac;

import com.venturingdigital.security.rbac.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoleBasedAccessControlStarterApplication implements CommandLineRunner {

	 @Autowired
	    private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(RoleBasedAccessControlStarterApplication.class, args);
	}
	@Override
    public void run(String... args) throws Exception {
        // Initialize roles
        roleService.initializeRoles();
    }

}
