package com.technicon.renovationcontractorapp.service;

import java.time.LocalDate;

import com.technicon.renovationcontractorapp.domain.Property;
import com.technicon.renovationcontractorapp.domain.PropertyRepair;

/**
 * 	This is the UserService interface. Here we define
 * 	all the things a regular user of the system can do.
 * 	He can read property data based on his vatNumber 
 *  and based on propertyId. He can also read property 
 *  repairs based on the date of repair by giving a
 *  date or a range of dates. He can also read property
 *  repairs based on vatNumber.
 * 
 * 	@author Grproth
 */
public interface UserService {

	Property readPropertyWithId( final long propertyId);
	Property readPropertyWithVatNumber( final String vatNumber);
	PropertyRepair readPropertyRepairWithDate( final LocalDate dateTime);
	PropertyRepair readPropertyRepairWithDates( 
			final LocalDate dateTimeFirst, final LocalDate dateTimeSecond);
	PropertyRepair readPropertyRepairWithVatNumber( final String vatNumber);
	
	boolean isPropertyIdValid( final long propertyId);
	boolean isVatNumberValid( final String vatNumber);
	boolean isDateTimeValid( final LocalDate dateTime);
}
