package com.technicon.renovationcontractorapp.repository.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.technicon.renovationcontractorapp.domain.PropertyType;
import com.technicon.renovationcontractorapp.model.Property;
import com.technicon.renovationcontractorapp.repository.PropertyRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

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
	public List<Property> readByVatNumber(String vatNumber) {
		String selectString = "select * from Property p inner join user u on p.user_userId=u.userId where u.vatNumber=?1";
		Query sqlQuery = entityManager.createNativeQuery(selectString, Property.class);
		sqlQuery.setParameter(1, vatNumber);
		return sqlQuery.getResultList();
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
