package org.mike.biblioteca;

import java.util.ArrayList;

/**
 * El modelo que contiene a los usuarios
 */
public class UserDatabase {
	
	private ArrayList<User> users = new ArrayList<User>();
	
	public UserDatabase() {
		
	}
	
	public ArrayList<User> getUsers() {
		return this.users;
	}
}
