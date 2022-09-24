package com.technicon.renovationcontractorapp.domain;

/**
 * 	Here we separate the owner user from other types.
 * 	There is one more attribute to be added (VAT number)
 *  other than the ones we have in the User class. And we
 * 	extend the functionality of the owner based on the 
 * 	services or client wants us to implement.
 * 
 * 	@author Grproth
 */
public class Owner extends User {

	private final long vatNumber;
	
	public Owner( final String name, final String surname, 
		final String address, final String phoneNumber, final String email, 
		final String username, final String password, final long vatNumber) {
		
		super(name, surname, address, phoneNumber, 
				email, username, password);
		
		this.vatNumber = vatNumber;
	}

	@Override
	public String header() {
		
		return super.header() + ", vatNumber";
	}
	
	@Override
	public String toString() {
		
		return super.toString() + ", " + vatNumber;
	}
}
