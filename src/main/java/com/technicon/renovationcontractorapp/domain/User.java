package com.technicon.renovationcontractorapp.domain;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * 	This is an abstract class that is the design of a general user.
 * 	There will be no objects of this class. The only objects will
 * 	be the children of this classes extender classes Admin & Owner.
 * 
 * 	@author Grproth, skroutzzz
 */

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long userId;
	
	private String name;
	private String surname;
	private String address;
	private String phoneNumber;
	private String email;
	private String username;
	private String password;
	
	@Column(unique = true)
	private String vatNumber;

	private boolean isAdmin;
	
	@OneToMany(mappedBy="user")
	private List<Property> properties;
	
	
	public User() {
		
	}

	public User( String name, String surname, 
			String address, String phoneNumber, String email, 
			String username, String password, String vatNumber,
			boolean isAdmin) {
		
		
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
	

	
	public long getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
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
