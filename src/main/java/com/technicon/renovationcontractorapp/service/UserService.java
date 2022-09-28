package com.technicon.renovationcontractorapp.service;

import java.time.LocalDate;

import com.technicon.renovationcontractorapp.domain.Property;
import com.technicon.renovationcontractorapp.domain.PropertyRepair;

public interface UserService {

	Property readPropertyWithId( long propertyId);
	Property readPropertyWithVatNumber( String vatNumber);
	PropertyRepair readPropertyRepairWithDate( LocalDate dateTime);
	PropertyRepair readPropertyRepairWithDates( 
			LocalDate dateTimeFirst, LocalDate dateTimeSecond);
	PropertyRepair readPropertyRepairWithVatNumber( String vatNumber);
}
