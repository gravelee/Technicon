package com.technicon.renovationcontractorapp.domain;

/**
 * 	This is an abstract class that is the design of a general user.
 * 	There will be no objects of this class. The only objects will
 * 	be the children of this classes extender classes Admin & Owner.
 * 
 * 	@author Grproth, skroutzzz
 */
public class User {

	private final long userId;
	private final String name;
	private final String surname;
	private String address;
	private final String phoneNumber;
	private String email;
	private final String username;
	private String password;
	private final String vatNumber;
	private final boolean isAdmin;
	
	public User( long userId, String name, String surname, 
			String address, String phoneNumber, String email, 
			String username, String password, String vatNumber,
			boolean isAdmin) {
		
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.vatNumber = vatNumber;
		this.isAdmin = isAdmin;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public String header() {
	
		return "userId, name, surname, address, phoneNumber, "
				+ "email, username, password, vatNumber, isAdmin";
	}
	
	@Override
	public String toString() {
		
		return userId + ", " + name + ", " + surname + ", " 
			+ address + ", " + phoneNumber + ", " + email + ", "
			+ username + ", " + password + ", " + vatNumber + ", " + isAdmin;
	}
}
