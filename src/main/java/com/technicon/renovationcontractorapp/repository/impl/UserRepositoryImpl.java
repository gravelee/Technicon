package com.technicon.renovationcontractorapp.repository.impl;

import java.util.List;

import com.technicon.renovationcontractorapp.domain.Owner;
import com.technicon.renovationcontractorapp.domain.Record;
import com.technicon.renovationcontractorapp.domain.User;
import com.technicon.renovationcontractorapp.repository.UserRepository;

/**
 * 	This class extends the functionality if the repository 
 * 	implementation and adds the more specific update methods
 * 	that the user repository needs.
 * 
 * 	@author Grproth, skroutzzz
 */
public class UserRepositoryImpl extends RepositoryImpl implements UserRepository {
	
	UserRepositoryImpl( List<Record> list) {
		
		super(list);
	}

	@Override
	public boolean addRecord( Record record) {
		
		return super.addRecord(record);
	}
	
	public User readUser( String string, boolean isVatNumber) {
		
		if(isVatNumber) {
			
			for( Record record : list) {
				
				Owner owner = (Owner) record;
				
				if( owner.getVatNumber().equals(string)) {
					
					return owner;
				}
			}
			
			return null;
		}
		
		for( Record record : list) {
			
			User user = (User) record;
			
			if( user.getEmail().equals(string)) {
				
				return user;
			}
		}
		
		return null;
	}
	
	public boolean updateAddress( 
			User userToBeUpdated, String address) {
		
		for( Record record : list) {
			
			User user = (User) record;
			
			if( userToBeUpdated.getUserId()
					.equals( user.getUserId())) {
				
				user.setAddress(address);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean updateEmail( 
			User userToBeUpdated, String email) {
		
		for( Record record : list) {
			
			User user = (User) record;
			
			if( userToBeUpdated.getUserId()
					.equals( user.getUserId())) {
				
				user.setEmail(email);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean updatePassword( 
			User userToBeUpdated, String password) {
		
		for( Record record : list) {
			
			User user = (User) record;
			
			if( userToBeUpdated.getUserId()
					.equals( user.getUserId())) {
				
				user.setPassword(password);
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean deleteRecord( Record record) {
		
		return super.deleteRecord(record);
	}
}
