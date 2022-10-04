package com.technicon.renovationcontractorapp.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.technicon.renovationcontractorapp.exception.InappropriateDateValueException;
import com.technicon.renovationcontractorapp.exception.InappropriatePropertyIdValueException;
import com.technicon.renovationcontractorapp.exception.InappropriateVatNumberValueException;
import com.technicon.renovationcontractorapp.model.Property;
import com.technicon.renovationcontractorapp.model.PropertyRepair;
import com.technicon.renovationcontractorapp.model.User;
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
 * 	@author Grproth, skroutzzz, Chris394
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
		
		if( !isPropertyIdValid(propertyId)) {
			
			Logger.getLogger( UserServiceImpl.class.getName())
			.log( Level.SEVERE, null, 
				new InappropriatePropertyIdValueException(
					"Error, inappropriate property id value! ("
						+ propertyId + ")"));
			
			return null;
		}
		
		Property property = propertyRepository.readByPropertyId(propertyId);
		
		if( property == null) {
			
			Logger.getLogger( UserServiceImpl.class.getName())
			.log( Level.SEVERE, null, "Error, "
				+ "there are no results that asserts that query!");
			
			return null;
		}
		
		return property;
	}

	/**
	 * 	Returns the property with the specific vat 
	 * 	number, otherwise returns null.
	 */
	@Override
	public Property readPropertyWithVatNumber( String vatNumber) {
		
		if( !isVatNumberValid(vatNumber)) {
			
			Logger.getLogger( UserServiceImpl.class.getName())
			.log( Level.SEVERE, null, 
				new InappropriateVatNumberValueException(
					"Error, inappropriate vat number value! ("
						+ vatNumber + ")"));
			
			return null;
		}
		
		Property property = propertyRepository.readByVatNumber(vatNumber);
		
		if( property == null) {
			
			Logger.getLogger( UserServiceImpl.class.getName())
			.log( Level.SEVERE, null, "Error, "
				+ "there are no results that asserts that query!");
			
			return null;
		}
		
		return property;
	}

	/**
	 * 	Returns the property repair with the specific date 
	 * 	or repair, otherwise returns null.
	 */
	@Override
	public List<PropertyRepair> readPropertyRepairWithDate(
			LocalDate dateTime) {
		
		if( !isDateTimeValid(dateTime)) {
			
			Logger.getLogger( UserServiceImpl.class.getName())
			.log( Level.SEVERE, null, 
				new InappropriateDateValueException(
					"Error, inappropriate date value! ("
						+ dateTime + ")"));
			
			return null;
		}
		
		List<PropertyRepair> propertyRepair = 
			propertyRepairRepository.readByDate(dateTime);
		
		if( propertyRepair == null) {
			
			
			
			Logger.getLogger( UserServiceImpl.class.getName())
			.log( Level.SEVERE, null, "Error, "
				+ "there are no results that asserts that query!");
			
			return null;
		}
		
		return propertyRepair;
	}

	/**
	 * 	Returns the property repair within the specific range
	 * 	of dates, otherwise returns null.
	 */
	@Override
	public List<PropertyRepair> readPropertyRepairWithDates(
			LocalDate dateTimeFirst, LocalDate dateTimeSecond) {
		
		if( !isDateTimeValid(dateTimeFirst) || 
				!isDateTimeValid(dateTimeSecond)) {
			
			Logger.getLogger( UserServiceImpl.class.getName())
			.log( Level.SEVERE, null, 
				new InappropriateDateValueException(
					"Error, inappropriate date value(s)! ("
						+ dateTimeFirst + "," + dateTimeFirst + ")"));
			
			return null;
		}
		
		List<PropertyRepair> propertyRepair = 
				propertyRepairRepository.readByDates(
					dateTimeFirst,dateTimeSecond);
		
		if( propertyRepair == null) {
			
			Logger.getLogger( UserServiceImpl.class.getName())
			.log( Level.SEVERE, null, "Error, "
				+ "there are no results that asserts that query!");
			
			return null;
		}
		
		return propertyRepair;
	}

	/**
	 * 	Returns the property repair with the specific 
	 * 	owners vat number, otherwise returns null.
	 */
	@Override
	public List<PropertyRepair> readPropertyRepairWithVatNumber(
			String vatNumber) {
		
		if( !isVatNumberValid(vatNumber)) {
			
			Logger.getLogger( UserServiceImpl.class.getName())
			.log( Level.SEVERE, null, 
				new InappropriateVatNumberValueException(
					"Error, inappropriate vat number value! ("
						+ vatNumber + ")"));
			
			return null;
		}
		
		List<PropertyRepair> propertyRepair = 
				propertyRepairRepository.readByVatNumber(
						vatNumber);
		
		if( propertyRepair == null) {
			
			Logger.getLogger( UserServiceImpl.class.getName())
			.log( Level.SEVERE, null, "Error, "
				+ "there are no results that asserts that query!");
			
			return null;
		}
		
		return propertyRepair;
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
		
		return (vatNumber.length() == User.VAT_NUMBER_LENGTH);
	}

	/**
	 * 	Returns if the date is valid.
	 */
	@Override
	public boolean isDateTimeValid( LocalDate dateTime) {
		
		return true;
	}
}
