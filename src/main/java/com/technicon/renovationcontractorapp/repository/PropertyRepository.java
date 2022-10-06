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
    
	//read all properties a user owns by its vat number
	List<Property> readByVatNumber(String vatNumber);
	
	// updates for pIdNumber, address, constructionYears, propertyType, ownersVatNumber
	boolean updateAddress(long pIdNumber, String address) throws Exception;
	boolean updateConstructionYear(long pIdNumber, LocalDate constructionYears) throws Exception;
	boolean updatePropertyType(long pIdNumber, PropertyType propertyType) throws Exception;
}
