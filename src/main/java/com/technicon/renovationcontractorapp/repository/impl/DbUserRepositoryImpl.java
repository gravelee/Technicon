package com.technicon.renovationcontractorapp.repository.impl;

import com.technicon.renovationcontractorapp.model.User;
import com.technicon.renovationcontractorapp.repository.UserRepository;

import jakarta.persistence.EntityManager;

/**
* 	This is the implementation of the UserRepository interface.
* 	
* 	@author Grproth, skroutzzz, Chris394
*/
public class DbUserRepositoryImpl extends DbRepositoryImpl<User,Long> 
            implements UserRepository{

	public DbUserRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public String getEntityClassName() {
		return User.class.getName();
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}
		
}
