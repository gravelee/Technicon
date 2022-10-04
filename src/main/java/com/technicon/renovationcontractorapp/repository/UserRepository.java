package com.technicon.renovationcontractorapp.repository;

import com.technicon.renovationcontractorapp.model.User;

/**
 * 	A more specific interface that extends the repository.
 * 	It represents the user repository with the specific
 * 	update & read methods of some of its attributes.
 * 
 * 	@author Grproth, skroutzzz, Chris394
 */
public interface UserRepository extends Repository<User, Long>{
	
	// read based on email, vatNumber
	User readByVatNumber(String vatNumber);
	User readByEmail(String email);
	
	// updates for address, email, password
	boolean updateAddress(String vatNumber, String newAddress);
	boolean updateEmail(String vatNumber, String newEmail);
	boolean updatePassword(String vatNumber, String newPassword);
}