package com.technicon.renovationcontractorapp.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.technicon.renovationcontractorapp.exception.InappropriateDateValueException;
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
		
		Optional<Property> property = null;
		
		try {
			
			property = propertyRepository.read(propertyId);
			
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
		}
		
		if( !property.isPresent()) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "there are no results that assert that query!");
			
			return null;
		}
		
		return property.get();
	}

	/**
	 * 	Returns the properties with the specific vat 
	 * 	number, otherwise returns null.
	 */
	@Override
	public List<Property> readPropertyWithVatNumber( String vatNumber) {
		
		if( !isVatNumberValid(vatNumber)) {
			
			Logger.getLogger( UserServiceImpl.class.getName())
				.log( Level.WARNING, null, 
					new InappropriateVatNumberValueException(
						"Error, inappropriate vat number value! ("
							+ vatNumber + ")"));
			
			return null;
		}
		
		List<Property> propertyList = null;
		
		try {
			
			propertyList = propertyRepository.readByVatNumber(vatNumber);
			
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
		}
		
		if( !propertyList.isEmpty()) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "there are no results that assert that query!");
			
			return null;
		}
		
		return propertyList;
	}

	/**
	 * 	Returns the property repair with the specific date 
	 * 	or repair, otherwise returns null.
	 */
	@Override
	public List<PropertyRepair> readPropertyRepairWithDate(
			LocalDate date) {
		
		if( !isDateValid(date)) {
			
			Logger.getLogger( UserServiceImpl.class.getName())
				.log( Level.WARNING, null, 
					new InappropriateDateValueException(
						"Error, inappropriate date value! ("
							+ date + ")"));
			
			return null;
		}
		
		List<PropertyRepair> propertyRepairList = null;
		
		try {
			
			propertyRepairList = propertyRepairRepository.readByDate(date);
			
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
		}
		
		if( propertyRepairList.isEmpty()) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "there are no results that assert that query!");
			
			return null;
		}
		
		return propertyRepairList;
	}

	/**
	 * 	Returns the property repair within the specific range
	 * 	of dates, otherwise returns null.
	 */
	@Override
	public List<PropertyRepair> readPropertyRepairWithDates(
			LocalDate dateTimeFirst, LocalDate dateTimeSecond) {

		if( !isDateValid(dateTimeFirst)) {
			
			Logger.getLogger( UserServiceImpl.class.getName())
				.log( Level.WARNING, null, 
					new InappropriateDateValueException(
						"Error, inappropriate date value! ("
							+ dateTimeFirst + ")"));
			
			return null;
		}
		
		if( !isDateValid(dateTimeSecond)) {
			
			Logger.getLogger( UserServiceImpl.class.getName())
				.log( Level.WARNING, null, 
					new InappropriateDateValueException(
						"Error, inappropriate date value! ("
							+ dateTimeSecond + ")"));
			
			return null;
		}
		
		List<PropertyRepair> propertyRepairList = null;
		
		try {
			
			propertyRepairList = propertyRepairRepository
				.readByDates(dateTimeFirst,dateTimeSecond);
			
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
		}
		
		if( propertyRepairList.isEmpty()) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "there are no results that assert that query!");
			
			return null;
		}
		
		return propertyRepairList;
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
				.log( Level.WARNING, null, 
					new InappropriateVatNumberValueException(
						"Error, inappropriate vat number value! ("
							+ vatNumber + ")"));
			
			return null;
		}
		
		List<PropertyRepair> propertyRepairList = null;
		
		try {
			
			propertyRepairList = propertyRepairRepository
				.readByVatNumber(vatNumber);
			
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
		}
		
		if( propertyRepairList.isEmpty()) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "there are no results that assert that query!");
			
			return null;
		}
		
		return propertyRepairList;
	}

	/**
	 * 	Returns if the vat number is valid.
	 */
	@Override
	public boolean isVatNumberValid( String vatNumber) {
		
		try{
			
			Integer.parseInt(vatNumber);
			return (vatNumber.length() == User.VAT_NUMBER_LENGTH);
		
		}catch(NumberFormatException ex) {
			
			Logger.getLogger( UserServiceImpl.class.getName())
				.log( Level.WARNING, null, new NumberFormatException(
					"Error, incorrect format of vat number! ("
						+ vatNumber + ")"));
			
			return false;
		}
	}

	/**
	 * 	Returns if the date is valid.
	 */
	@Override
	public boolean isDateValid( LocalDate dateTime) {
		
		return true;
	}
}
