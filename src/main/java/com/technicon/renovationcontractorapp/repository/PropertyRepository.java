package com.technicon.renovationcontractorapp.repository;

import java.time.LocalDate;
import java.util.List;

import com.technicon.renovationcontractorapp.domain.PropertyType;
import com.technicon.renovationcontractorapp.model.Property;

/**
 * 	A more specific interface that extends the repository.
 * 	It represents the property repository with the specific
 * 	update & read methods of all of its attributes.
 * 
 * 	@author Grproth, skroutzzz, Chris394
 */
public interface PropertyRepository extends Repository<Property, Long>{
    
	
	List<Property> readByVatNumber(String vatNumber);
	
	// updates for pIdNumber, address, constructionYears, propertyType, ownersVatNumber
	boolean updateAddress(long pIdNumber, String address);
	boolean updateConstructionYear(long pIdNumber, LocalDate constructionYears);
	boolean updatePropertyType(long pIdNumber, PropertyType propertyType);
	boolean updateVatNumber(long pIdNumber, String ownersVatNumber);
}
