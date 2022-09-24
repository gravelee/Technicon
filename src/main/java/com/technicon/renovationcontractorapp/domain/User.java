package com.technicon.renovationcontractorapp.domain;

/**
 * 	This is an abstract class that is the design of a general user.
 * 	There will be no objects of this class. The only objects will
 * 	be the children of this classes extender classes Admin & Owner.
 * 
 * 	@author Grproth, skroutzzz
 */
public abstract class User {

	private final static int userIdLength = 10;
	private static long numberOfUsers = 0;
	
	protected final String userId;
	protected final String name;
	protected final String surname;
	protected String address;
	protected final String phoneNumber;
	protected String email;
	protected final String username;
	protected String password;
	
	protected User( String name, String surname, String address, 
			String phoneNumber, String email, String username,
			String password) {
		
		
		userId = createNewUserId();
		
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	// getters
	
	protected long getNumberOfUsers() {
		
		return numberOfUsers;
	}
	
	/*
	public void setAddress( String address) {
		
		this.address = address;
	}
	
	public void setEmail( String email) {
		
		this.email = email;
	}
	
	public void setPassword( String password) {
		
		this.password = password;
	}
	*/
	
	protected String header() {
		
		return "userId, name, surname, address, phoneNumber, "
				+ "email, username, password";
	}
	
	@Override
	public String toString() {
		
		return userId + ", " + name + ", " + surname + ", " 
			+ address + ", " + phoneNumber + ", " + email + ", "
			+ username + ", " + password;
	}
	
	private String createNewUserId() {
		
		StringBuilder userId = 
			new StringBuilder( ( (Long) User.numberOfUsers).toString());
		
		if( userId.length() < userIdLength)
			for( int i = 0; i<userIdLength - userId.length(); i++)
				userId.insert(0,"0");
		
		numberOfUsers++;
		
		return userId.toString();
	}
	
	
}
