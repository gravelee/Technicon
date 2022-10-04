package com.technicon.renovationcontractorapp.repository.impl;

import com.technicon.renovationcontractorapp.model.PropertyRepair;
import com.technicon.renovationcontractorapp.repository.PropertyRepairRepository;

import jakarta.persistence.EntityManager;

/**
* 	This is the implementation of the PropertyRepairRepository interface.
* 	
* 	@author Grproth, skroutzzz, Chris394
*/
public class DbPropertyRepairRepositoryImpl extends DbRepositoryImpl<PropertyRepair,Long> 
            implements PropertyRepairRepository{

	public DbPropertyRepairRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public String getEntityClassName() {
		return PropertyRepair.class.getName();
	}

	@Override
	public Class<PropertyRepair> getEntityClass() {
		return PropertyRepair.class;
	}
	
}
