package com.technicon.renovationcontractorapp.repository.impl;

import java.time.LocalDate;
import java.util.Optional;

import com.technicon.renovationcontractorapp.domain.PropertyType;
import com.technicon.renovationcontractorapp.model.Property;
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

	@Override
	public boolean updateAddress(long pIdNumber, String address) {
		Optional<Property> property = read(pIdNumber);
		if(property.isPresent()) {
			try {
				Property property2 = property.get();
				property2.setAddress(address);
				entityManager.getTransaction().begin();
				entityManager.merge(property2);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}


	@Override
	public boolean updateConstructionYear(long pIdNumber, LocalDate constructionYears) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePropertyType(long pIdNumber, PropertyType propertyType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateVatNumber(long pIdNumber, String ownersVatNumber) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
