package com.technicon.renovationcontractorapp.repository.impl;

import com.technicon.renovationcontractorapp.model.Property;
import com.technicon.renovationcontractorapp.repository.PropertyRepairRepository;
import com.technicon.renovationcontractorapp.repository.PropertyRepository;

import jakarta.persistence.EntityManager;

/**
* 	This is the implementation of the PropertyRepository interface.
* 	
* 	@author Grproth, skroutzzz, Chris394
*
*/

public class DbPropertyRepositoryImpl extends DbRepositoryImpl<Property,Long> 
            implements PropertyRepository{
	
	public DbPropertyRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public String getEntityClassName() {
		return Property.class.getName();
	}

	@Override
	public Class<Property> getEntityClass() {
		return Property.class;
	}
	
	
}
