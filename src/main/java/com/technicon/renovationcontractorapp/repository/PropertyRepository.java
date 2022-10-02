package com.technicon.renovationcontractorapp.repository;

import java.time.LocalDate;

import com.technicon.renovationcontractorapp.model.Property;
import com.technicon.renovationcontractorapp.model.PropertyType;

/**
 * 	A more specific interface that extends the repository.
 * 	It represents the property repository with the specific
 * 	update & read methods of all of its attributes.
 * 
 * 	@author Grproth, skroutzzz, Chris394
 */
public interface PropertyRepository extends Repository<Property, Long>{
    /*
	// read based on vatNumber, pIdNumber
	Property readByVatNumber(String vatNumber);
	
	// updates for pIdNumber, address, constructionYears, propertyType, ownersVatNumber
	boolean updatePidNumber(long pIdNumber, long newPidNumber);
	boolean updateAddress(long pIdNumber, String address);
	boolean updateConstructionYears(long pIdNumber, LocalDate constructionYears);
	boolean updatePropertyType(long pIdNumber, PropertyType propertyType);
	boolean updateOwnersVatNumber(long pIdNumber, String ownersVatNumber);
	*/
}
