package com.technicon.renovationcontractorapp.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import com.technicon.renovationcontractorapp.exception.InappropriateDateValueException;
import com.technicon.renovationcontractorapp.exception.InappropriateIdValueException;
import com.technicon.renovationcontractorapp.exception.InappropriateVatNumberValueException;
import com.technicon.renovationcontractorapp.model.Property;
import com.technicon.renovationcontractorapp.model.PropertyRepair;
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
		
		if( !isIdValid(propertyId)) {
			
			Logger.getLogger( UserServiceImpl.class.getName())
				.log( Level.WARNING, null, 
					new InappropriateIdValueException(
						"Error, inappropriate id value! ("
							+ propertyId + ")"));
			
			return null;
		}
		
		Optional<Property> property = null;
		
		try {
			
			property = propertyRepository.read(propertyId);
			
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, ex.getMessage(), ex);
			
			return null;
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
		
		List<Property> propertyList = new ArrayList<>();
		
		try {
			
			propertyList = propertyRepository.readByVatNumber(vatNumber);
			
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return null;
		}
		
		if( propertyList.isEmpty()) {
			
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
			System.out.println("date not valid");
			return null;
		}
		
		List<PropertyRepair> propertyRepairList = null;
		
		try {
			
			propertyRepairList = propertyRepairRepository.readByDate(date);
			
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			System.out.println("database error");
			return null;
		}
		
		if( propertyRepairList.isEmpty()) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "there are no results that assert that query!");
			System.out.println("empty result list");
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
			System.out.println("date not valid");
			return null;
		}
		
		if( !isDateValid(dateTimeSecond)) {
			
			Logger.getLogger( UserServiceImpl.class.getName())
				.log( Level.WARNING, null, 
					new InappropriateDateValueException(
						"Error, inappropriate date value! ("
							+ dateTimeSecond + ")"));
			System.out.println("date not valid");
			return null;
		}
		
		List<PropertyRepair> propertyRepairList = null;
		
		try {
			
			propertyRepairList = propertyRepairRepository
				.readByDates(dateTimeFirst,dateTimeSecond);
			
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			System.out.println("database error");
			return null;
		}
		
		if( propertyRepairList.isEmpty()) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "there are no results that assert that query!");
			System.out.println("empty resul list");
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
			System.out.println("vat number not valid");
			return null;
		}
		
		List<PropertyRepair> propertyRepairList = null;
		
		try {
			
			propertyRepairList = propertyRepairRepository
				.readByVatNumber(vatNumber);
			
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			System.out.println("database error");
			return null;
		}
		
		if( propertyRepairList.isEmpty()) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "there are no results that assert that query!");
			System.out.println("empty result list");
			return null;
		}
		
		return propertyRepairList;
	}
	
	/**
	 * 	Returns if the id is valid.
	 */
	public boolean isIdValid( long id) {
		
		return (id>0);
	}

	/**
	 * 	Returns if the vat number is valid.
	 */
	@Override
	public boolean isVatNumberValid( String vatNumber) {
		
		String regex = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regex);
        
        return pattern.matcher(vatNumber).matches();
	}

	/**
	 * 	Returns if the date is valid.
	 */
	@Override
	public boolean isDateValid( LocalDate dateTime) {
		
		return true;
	}
}
