package com.technicon.renovationcontractorapp.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.technicon.renovationcontractorapp.domain.Property;
import com.technicon.renovationcontractorapp.domain.PropertyRepair;
import com.technicon.renovationcontractorapp.domain.PropertyType;
import com.technicon.renovationcontractorapp.domain.RepairType;
import com.technicon.renovationcontractorapp.domain.StatusType;
import com.technicon.renovationcontractorapp.domain.User;
import com.technicon.renovationcontractorapp.repository.PropertyRepairRepository;
import com.technicon.renovationcontractorapp.repository.PropertyRepository;
import com.technicon.renovationcontractorapp.repository.UserRepository;
import com.technicon.renovationcontractorapp.service.AdminService;

/**
 * 	This is the implementation of the administrators 
 * 	services. Same pattern here as UserServiceImpl. 
 * 	We check validity and then we parse the actual 
 * 	search to the appropriate repository.
 * 
 * 	@author Grproth, skroutzzz
 */
public class AdminServiceImpl extends UserServiceImpl 
		implements AdminService {

	private UserRepository userRepository;
	
	AdminServiceImpl( UserRepository userRepository, 
			PropertyRepository properyRepository,
			PropertyRepairRepository properyRepairRepository) {

		super(properyRepository, properyRepairRepository);
		this.userRepository = userRepository;
	}

	@Override
	public boolean addUser(User user) {
		
		if( !isUserValid(user))
			return false;
		
		return userRepository.add(user);
	}

	@Override
	public boolean addProperty(Property property) {

		if( !isPropertyValid(property))
			return false;
		
		return propertyRepository.add(property);
	}

	@Override
	public boolean addPropertyRepair(PropertyRepair propertyRepair) {

		if( !isPropertyRepairValid(propertyRepair))
			return false;
		
		return propertyRepairRepository.add(propertyRepair);
	}

	@Override
	public boolean updateUserAddress(User user, String address) {
		
		if( !isUserValid(user) || !isAddressValid(address))
			return false;
		
		return userRepository.updateAddress(address);
	}

	@Override
	public boolean updateUserEmail(User user, String email) {
		
		if( !isUserValid(user) || !isEmailValid(email))
			return false;
		
		return userRepository.updateEmail(email);
	}

	@Override
	public boolean updateUserPassword(User user, String password) {
		
		if( !isUserValid(user) || !isPasswordValid(password))
			return false;
		
		return userRepository.updatePassword(password);
	}

	@Override
	public boolean updatePropertyAddress(
			Property property, String address) {
		
		if( !isPropertyValid(property) || !isAddressValid(address))
			return false;
		
		return propertyRepository.updateAddress(address);
	}

	@Override
	public boolean updatePropertyConstructionYear(
			Property property, LocalDate constructionYear) {
		
		if( !isPropertyValid(property) || 
				!isConstructionYearValid(constructionYear))
			return false;
		
		return propertyRepository.updateConstructionYear(
				constructionYear);
	}

	@Override
	public boolean updatePropertyType(Property property, 
			PropertyType propertyType) {
		
		if( !isPropertyValid(property) || 
				!isPropertyTypeValid(propertyType))
			return false;
		
		return propertyRepository.updatePropertyType(
				propertyType);
	}

	@Override
	public boolean updatePropertyVatNumber(
			Property property, String vatNumber) {
		
		if( !isPropertyValid(property) || 
				!isVatNumberValid(vatNumber))
			return false;
		
		return propertyRepository.updateVatNumber(
				vatNumber);
	}

	@Override
	public boolean updatePropertyRepairDateTime(
			Property propertyRepair, LocalDate dateTime) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isDateTimeValid(dateTime))
			return false;
		
		return propertyRepairRepository.updateDateTime(
				dateTime);
	}

	@Override
	public boolean updatePropertyRepairSummary(
			Property propertyRepair, String summary) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isSummaryValid(summary))
			return false;
		
		return propertyRepairRepository.updateSummary(
				summary);
	}

	@Override
	public boolean updatePropertyRepairType(
			Property propertyRepair, RepairType repairType) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isRepairTypeValid(repairType))
			return false;
		
		return propertyRepairRepository.updateRepairType(
				repairType);
	}

	@Override
	public boolean updatePropertyRepairStatusType(
			Property propertyRepair, StatusType statusType) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isStatusTypeValid(statusType))
			return false;
		
		return propertyRepairRepository.updateStatusType(
				statusType);
	}

	@Override
	public boolean updatePropertyRepairCost(
			Property propertyRepair, BigDecimal cost) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isCostValid(cost))
			return false;
		
		return propertyRepairRepository.updateCost(
				cost);
	}

	@Override
	public boolean updatePropertyRepairVatNumber(
			Property propertyRepair, String vatNumber) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isVatNumberValid(vatNumber))
			return false;
		
		return propertyRepairRepository.updateVatNumber(
				vatNumber);
	}

	@Override
	public boolean updatePropertyRepairDesc(
			Property propertyRepair, String repairDesc) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isRepairDescValid(repairDesc))
			return false;
		
		return propertyRepairRepository.updateRepairDesc(
				repairDesc);
	}

	@Override
	public boolean deleteUser(User user) {

		if( !isUserValid(user))
			return false;
		
		return userRepository.delete(user);
	}

	@Override
	public boolean deleteProperty(Property property) {

		if( !isPropertyValid(property))
			return false;
		
		return propertyRepository.delete(property);
	}

	@Override
	public boolean deletePropertyRepair(PropertyRepair propertyRepair) {

		if( !isPropertyRepairValid(propertyRepair))
			return false;
		
		return propertyRepairRepository.delete(propertyRepair);
	}

	@Override
	public User readUserWithVatNumber(String vatNumber) {

		if( !isVatNumberValid(vatNumber))
			return null;
		
		return userRepository.readByVatNumber(vatNumber);
	}

	@Override
	public User readUserWithEmail(String email) {

		if( !isEmailValid(email))
			return null;
		
		return userRepository.readByEmail(email);
	}
	
	private boolean isUserValid(User user) {
		// business logic
		return false;
	}

	private boolean isPropertyValid(Property property) {
		// business logic
		return false;
	}

	private boolean isPropertyRepairValid(
			PropertyRepair propertyRepair) {
		// business logic
		return false;
	}

	private boolean isAddressValid(String address) {
		// business logic
		return false;
	}
	
	private boolean isEmailValid(String email) {
		// business logic
		return false;
	}

	private boolean isPasswordValid(String password) {
		// business logic
		return false;
	}

	private boolean isConstructionYearValid(
			LocalDate constructionYear) {
		// business logic
		return false;
	}

	private boolean isPropertyTypeValid(
			PropertyType propertyType) {
		// business logic
		return false;
	}

	private boolean isPropertyRepairValid(
			Property propertyRepair) {
		// business logic
		return false;
	}

	private boolean isSummaryValid(String summary) {
		// business logic
		return false;
	}

	private boolean isRepairTypeValid(RepairType repairType) {
		// business logic
		return false;
	}

	private boolean isStatusTypeValid(StatusType statusType) {
		// business logic
		return false;
	}

	private boolean isCostValid(BigDecimal cost) {
		// business logic
		return false;
	}

	private boolean isRepairDescValid(String repairDesc) {
		// business logic
		return false;
	}
}
