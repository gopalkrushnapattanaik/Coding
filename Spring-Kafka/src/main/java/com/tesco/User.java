package com.tesco;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2883124743889646613L;
	public String userId;
	public String firstName;
	public String lastName;

	public User() {

	}

	public User(String userId, String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
	}

	
	 @Override
	    public String toString() {
	        return userId + ", " + firstName + lastName+"!";
	    }
}
