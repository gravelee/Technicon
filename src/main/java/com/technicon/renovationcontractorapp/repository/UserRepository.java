package com.technicon.renovationcontractorapp.repository;

import com.technicon.renovationcontractorapp.domain.User;

/**
 * 	A more specific interface that extends the repository.
 * 	It represents the user repository with the specific
 * 	update & read methods of some its attributes.
 * 
 * 	@author Grproth, skroutzzz
 */
public interface UserRepository extends Repository{

	User readUser( String string, boolean isVatNumber);
	boolean updateAddress( User user, String address);
	boolean updateEmail( User user, String email);
	boolean updatePassword( User user, String password);
}
