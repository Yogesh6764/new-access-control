package com.venturingdigital.security.rbac.model;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Username cannot be blank")
	    @Column(nullable = false, unique = true)
	    private String username;

	    @NotBlank(message = "Password cannot be blank")
	    @Column(nullable = false)
	    private String password;

	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(
	        name = "user_roles",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "role_id")
	    )
	    private Set<Role> roles;

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public Set<Role> getRoles() {
	        return roles;
	    }

	    public void setRoles(Set<Role> roles) {
	        this.roles = roles;
	    }

	    // Constructors
	    public User(Long id, String username, String password, Set<Role> roles) {
	        super();
	        this.id = id;
	        this.username = username;
	        this.password = password;
	        this.roles = roles;
	    }

	    public User() {
	        super();
	        // Default constructor
	    }

	    // Override toString method
	    @Override
	    public String toString() {
	        return "User{" +
	                "id=" + id +
	                ", username='" + username + '\'' +
	                ", roles=" + roles +
	                '}';
	    }
	}