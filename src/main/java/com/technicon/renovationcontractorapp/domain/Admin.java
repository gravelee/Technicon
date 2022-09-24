package com.technicon.renovationcontractorapp.domain;

/**
 * 	Here we separate the administrator user from other types.
 * 	There are no more attributes to be added to this class
 * 	other than the ones we have in the User class. But we
 * 	extend the functionality of the administrator based
 * 	on the interpretation of the data our client asked.
 * 
 * 	@author Grproth
 */
public class Admin extends User {

	public Admin( final String name, final String surname, final String address, 
			final String phoneNumber, final String email, final String username,
			final String password) {
		
		super(name, surname, address, phoneNumber, 
				email, username, password);
	}
	
	@Override
	public String header() {
		
		return super.header();
	}
	
	@Override
	public String toString() {
		
		return super.toString();
	}
}
