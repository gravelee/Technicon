package com.technicon.renovationcontractorapp.repository.impl;

import java.util.Optional;

import com.technicon.renovationcontractorapp.model.User;
import com.technicon.renovationcontractorapp.repository.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

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
	public Optional<User> readByVatNumber(String vatNumber) {
		String selectString = "select * from user where vatNumber=?1";
		Query sqlQuery = entityManager.createNativeQuery(selectString, User.class);
		sqlQuery.setParameter(1, vatNumber);
		try {
			User user = (User) sqlQuery.getSingleResult();
			return Optional.of(user);
		} catch (Exception NoResultException) {
			return Optional.empty();
		}
	}

	@Override
	public Optional<User> readByEmail(String email) {
		String selectString = "select * from user where email=?1";
		Query sqlQuery = entityManager.createNativeQuery(selectString, User.class);
		sqlQuery.setParameter(1, email);
		try {
			User user = (User) sqlQuery.getSingleResult();
			return Optional.of(user);
		} catch (Exception NoResultException) {
			return Optional.empty();
		}
	}
	
	@Override
	public boolean updateAddress(String vatNumber, String newAddress) {
		Optional<User> user = readByVatNumber(vatNumber);
		if(user.isPresent()) {
			try {
				User user2 = user.get();
				user2.setAddress(newAddress);
				entityManager.getTransaction().begin();
				entityManager.merge(user2);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEmail(String vatNumber, String newEmail) {
		Optional<User> user = readByVatNumber(vatNumber);
		if(user.isPresent()) {
			try {
				User user2 = user.get();
				user2.setEmail(newEmail);
				entityManager.getTransaction().begin();
				entityManager.merge(user2);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePassword(String vatNumber, String newPassword) {
		Optional<User> user = readByVatNumber(vatNumber);
		if(user.isPresent()) {
			try {
				User user2 = user.get();
				user2.setPassword(newPassword);
				entityManager.getTransaction().begin();
				entityManager.merge(user2);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
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
