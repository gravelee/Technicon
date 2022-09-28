package com.technicon.renovationcontractorapp.service.impl;

import java.time.LocalDate;

import com.technicon.renovationcontractorapp.domain.Property;
import com.technicon.renovationcontractorapp.domain.PropertyRepair;
import com.technicon.renovationcontractorapp.repository.PropertyRepairRepository;
import com.technicon.renovationcontractorapp.repository.PropertyRepository;
import com.technicon.renovationcontractorapp.service.UserService;

public class UserServiceImpl implements UserService{

	protected PropertyRepository propertyRepository;
	protected PropertyRepairRepository propertyRepairRepository;
	
	public UserServiceImpl(PropertyRepository propertyRepository, 
			PropertyRepairRepository propertyRepairRepository) {
		
		this.propertyRepository = propertyRepository;
		this.propertyRepairRepository = propertyRepairRepository;
	}

	@Override
	public Property readPropertyWithId(long propertyId) {
		
		return null;
	}

	@Override
	public Property readPropertyWithVatNumber(String vatNumber) {
		
		return null;
	}

	@Override
	public PropertyRepair readPropertyRepairWithDate(LocalDate dateTime) {
		
		return null;
	}

	@Override
	public PropertyRepair readPropertyRepairWithDates(LocalDate dateTimeFirst, LocalDate dateTimeSecond) {
		
		return null;
	}

	@Override
	public PropertyRepair readPropertyRepairWithVatNumber(String vatNumber) {
		
		return null;
	}
}
