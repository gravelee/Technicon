package com.technicon.renovationcontractorapp.repository.impl;

import java.time.LocalDate;
import java.util.List;

import com.technicon.renovationcontractorapp.domain.Property;
import com.technicon.renovationcontractorapp.domain.PropertyType;
import com.technicon.renovationcontractorapp.repository.PropertyRepository;

/**
 * 	This class extends the functionality if the repository 
 * 	implementation and adds the more specific update methods
 * 	that the property repository needs.
 * 
 * 	@author Grproth, skroutzzz, Chris394
 */
public class PropertyRepositoryImpl extends RepositoryImpl<Property> implements PropertyRepository {

	public PropertyRepositoryImpl(List<Property> propertyList) {
        super(propertyList);
    }


	@Override
	public Property readByVatNumber(String vatNumber) {
		for(Property property:read()) {
			if(property.getVatNumber().equals(vatNumber)) {
				return property;
			}
		}
		return null;
	}

	@Override
	public boolean updatePidNumber(long pIdNumber, long newPidNumber) {
		Property property = read(pIdNumber);
		if( property == null) return false;
		property.setPropertyId(newPidNumber); 
		return true;
	}

	@Override
	public boolean updateAddress(long pIdNumber, String newAddress) {
		Property property = read(pIdNumber);
		if( property == null) return false;
		property.setAddress(newAddress); 
		return true;
	}

	@Override
	public boolean updateConstructionYears(long pIdNumber,LocalDate newConstructionYears) {
		Property property = read(pIdNumber);
		if( property == null) return false;
		property.setConstructionYear(newConstructionYears); 
		return true;
	}

	@Override
	public boolean updatePropertyType(long pIdNumber, PropertyType propertyType) {
		Property property = read(pIdNumber);
		if( property == null) return false;
		property.setPropertyType(propertyType); 
		return true;
	}

	@Override
	public boolean updateOwnersVatNumber(long pIdNumber, String newOwnersVatNumber) {
		Property property = read(pIdNumber);
		if( property == null) return false;
		property.setVatNumber(newOwnersVatNumber); 
		return true;
	}	
	
}
