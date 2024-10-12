package com.venturingdigital.security.rbac.security;

public enum  Action {

	 CREATE_USER("createUser"),
	    DELETE_USER("deleteUser"),
	    VIEW_REPORTS("viewReports"),
	    ASSIGN_ROLE("assignRole");

	    private final String actionName;

	    // Constructor
	    Action(String actionName) {
	        this.actionName = actionName;
	    }

	    // Getter for actionName
	    public String getActionName() {
	        return actionName;
	    }
	}
	


