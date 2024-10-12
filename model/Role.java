package com.venturingdigital.security.rbac.model;

import java.util.HashSet;
import java.util.Set;

import com.venturingdigital.security.rbac.security.Action;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String roleName;

	    @ManyToMany(mappedBy = "roles")
	    private Set<User> users = new HashSet<>();

	    @ElementCollection(fetch = FetchType.EAGER)
	    @Enumerated(EnumType.STRING)
	    private Set<Action> permissions = new HashSet<>();

	    // Default constructor
	    public Role() {}

	    public Role(String roleName, Set<Action> permissions) {
	        this.roleName = roleName;
	        this.permissions = permissions != null ? permissions : new HashSet<>();
	    }

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getRoleName() {
	        return roleName;
	    }

	    public void setRoleName(String roleName) {
	        this.roleName = roleName;
	    }

	    public Set<User> getUsers() {
	        return users;
	    }

	    public void setUsers(Set<User> users) {
	        this.users = users != null ? users : new HashSet<>();
	    }

	    public Set<Action> getPermissions() {
	        return permissions;
	    }

	    public void setPermissions(Set<Action> permissions) {
	        this.permissions = permissions != null ? permissions : new HashSet<>();
	    }

	    public boolean hasPermission(Action action) {
	        return permissions.contains(action);
	    }

	    @Override
	    public String toString() {
	        return "Role{id=" + id + ", roleName='" + roleName + '\'' + ", permissions=" + permissions + '}';
	    }
}
	

