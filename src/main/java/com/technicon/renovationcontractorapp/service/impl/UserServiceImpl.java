package com.technicon.renovationcontractorapp.service.impl;

import java.time.LocalDate;

import com.technicon.renovationcontractorapp.domain.Property;
import com.technicon.renovationcontractorapp.domain.PropertyRepair;
import com.technicon.renovationcontractorapp.domain.User;
import com.technicon.renovationcontractorapp.repository.PropertyRepairRepository;
import com.technicon.renovationcontractorapp.repository.PropertyRepository;
import com.technicon.renovationcontractorapp.service.UserService;

/**
 * 	This is the implementation of the UserService
 * 	interface. We define a property and a property
 * 	repair repository. We inject them in the 
 * 	constructor. Then we implement the business
 * 	logic in the overridden methods. We check
 * 	data validity and then call the appropriate
 * 	repository's method.
 * 
 * 	@author Grproth
 */
public class UserServiceImpl implements UserService{
	
	protected PropertyRepository propertyRepository;
	protected PropertyRepairRepository propertyRepairRepository;
	
	public UserServiceImpl(PropertyRepository propertyRepository, 
			PropertyRepairRepository propertyRepairRepository) {
		
		this.propertyRepository = propertyRepository;
		this.propertyRepairRepository = propertyRepairRepository;
	}

	/**
	 * 	Returns the property with the specific property 
	 * 	id, otherwise returns null.
	 */
	@Override
	public Property readPropertyWithId( long propertyId) {
		
		if( !isPropertyIdValid(propertyId))
			return null;
		
		return propertyRepository.readByPropertyId(propertyId);
	}

	/**
	 * 	Returns the property with the specific vat 
	 * 	number, otherwise returns null.
	 */
	@Override
	public Property readPropertyWithVatNumber( String vatNumber) {
		
		if( !isVatNumberValid(vatNumber))
			return null;
		
		return propertyRepository.readByVatNumber(vatNumber);
	}

	/**
	 * 	Returns the property repair with the specific date 
	 * 	or repair, otherwise returns null.
	 */
	@Override
	public PropertyRepair readPropertyRepairWithDate(
			LocalDate dateTime) {
		
		if( !isDateTimeValid(dateTime))
			return null;
		
		return propertyRepairRepository.readByDate(dateTime);
	}

	/**
	 * 	Returns the property repair within the specific range
	 * 	of dates, otherwise returns null.
	 */
	@Override
	public PropertyRepair readPropertyRepairWithDates(
			LocalDate dateTimeFirst, LocalDate dateTimeSecond) {
		
		if( !isDateTimeValid(dateTimeFirst) || 
				!isDateTimeValid(dateTimeSecond))
			return null;
		
		return propertyRepairRepository.readByDates(
				dateTimeFirst,dateTimeSecond);
	}

	/**
	 * 	Returns the property repair with the specific 
	 * 	owners vat number, otherwise returns null.
	 */
	@Override
	public PropertyRepair readPropertyRepairWithVatNumber(
			String vatNumber) {
		
		if( !isVatNumberValid(vatNumber))
			return null;
		
		return propertyRepository.readByPropertyId(vatNumber);
	}

	/**
	 * 	Returns if the property id is valid.
	 */
	@Override
	public boolean isPropertyIdValid( long propertyId) {
		
		return (propertyId>0);
	}

	/**
	 * 	Returns if the vat number is valid.
	 */
	@Override
	public boolean isVatNumberValid( String vatNumber) {
		
		return (vatNumber.length() == User.vatNumberLength);
	}

	/**
	 * 	Returns if the date is valid.
	 */
	@Override
	public boolean isDateTimeValid( LocalDate dateTime) {
		
		return true;
	}
}
