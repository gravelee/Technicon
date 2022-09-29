package com.technicon.renovationcontractorapp.repository.impl;

import java.util.List;

import com.technicon.renovationcontractorapp.domain.User;
import com.technicon.renovationcontractorapp.repository.UserRepository;

/**
 * 	This class extends the functionality if the repository 
 * 	implementation and adds the more specific update methods
 * 	that the user repository needs.
 * 
 * 	@author Grproth, skroutzzz, Chris394
 */
public class UserRepositoryImpl extends RepositoryImpl<User> implements UserRepository {

	public UserRepositoryImpl(List<User> userList) {
        super(userList);
    }
	
	@Override
	public User readByVatNumber(String vatNumber) {
		for(User user:read()) {
			if(user.getVatNumber().equals(vatNumber)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean updateAddress(String vatNumber, String newAddress) {
		User user = readByVatNumber(vatNumber);
		if( user == null) return false;
		user.setAddress(newAddress); 
		return true;
	}

	@Override
	public boolean updateEmail(String vatNumber, String newEmail) {
		User user = readByVatNumber(vatNumber);
		if( user == null) return false;
		user.setEmail(newEmail); 
		return true;
	}

	@Override
	public boolean updatePassword(String vatNumber, String newPassword) {
		User user = readByVatNumber(vatNumber);
		if( user == null) return false;
		user.setPassword(newPassword); 
		return true;
	}
	
}
