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

	/**
	 * 	Adds the user if he is valid,
	 * 	otherwise returns false.
	 */
	@Override
	public boolean addUser(User user) {
		
		if( !isUserValid(user))
			return false;
		
		return userRepository.add(user);
	}

	/**
	 * 	Adds the property if it is valid,
	 * 	otherwise returns false.
	 */
	@Override
	public boolean addProperty(Property property) {

		if( !isPropertyValid(property))
			return false;
		
		return propertyRepository.add(property);
	}

	/**
	 * 	Adds the property repair if it is valid,
	 * 	otherwise returns false.
	 */
	@Override
	public boolean addPropertyRepair(PropertyRepair propertyRepair) {

		if( !isPropertyRepairValid(propertyRepair))
			return false;
		
		return propertyRepairRepository.add(propertyRepair);
	}

	/**
	 * 	Updates the user with the new address if 
	 * 	the user and the address are valid.
	 */
	@Override
	public boolean updateUserAddress(User user, String address) {
		
		if( !isUserValid(user) || !isAddressValid(address))
			return false;
		
		return userRepository.updateAddress(address);
	}

	/**
	 * 	Updates the user with the new email if 
	 * 	the user and the email are valid.
	 */
	@Override
	public boolean updateUserEmail(User user, String email) {
		
		if( !isUserValid(user) || !isEmailValid(email))
			return false;
		
		return userRepository.updateEmail(email);
	}

	/**
	 * 	Updates the user with the new password if 
	 * 	the user and the password are valid.
	 */
	@Override
	public boolean updateUserPassword(User user, String password) {
		
		if( !isUserValid(user) || !isPasswordValid(password))
			return false;
		
		return userRepository.updatePassword(password);
	}

	/**
	 * 	Updates the property with the new address if 
	 * 	the property and the address are valid.
	 */
	@Override
	public boolean updatePropertyAddress(
			Property property, String address) {
		
		if( !isPropertyValid(property) || !isAddressValid(address))
			return false;
		
		return propertyRepository.updateAddress(address);
	}

	/**
	 * 	Updates the property with the new construction 
	 * 	year if the property and the construction year 
	 * 	are valid.
	 */
	@Override
	public boolean updatePropertyConstructionYear(
			Property property, LocalDate constructionYear) {
		
		if( !isPropertyValid(property) || 
				!isConstructionYearValid(constructionYear))
			return false;
		
		return propertyRepository.updateConstructionYear(
				constructionYear);
	}

	/**
	 * 	Updates the property with the new property type if 
	 * 	the property and the property type are valid.
	 */
	@Override
	public boolean updatePropertyType(Property property, 
			PropertyType propertyType) {
		
		if( !isPropertyValid(property) || 
				!isPropertyTypeValid(propertyType))
			return false;
		
		return propertyRepository.updatePropertyType(
				propertyType);
	}

	/**
	 * 	Updates the property with the new vat number if 
	 * 	the property and the vat number are valid.
	 */
	@Override
	public boolean updatePropertyVatNumber(
			Property property, String vatNumber) {
		
		if( !isPropertyValid(property) || 
				!isVatNumberValid(vatNumber))
			return false;
		
		return propertyRepository.updateVatNumber(
				vatNumber);
	}

	/**
	 * 	Updates the property repair with the new dateTime 
	 * 	if the property repair and the dateTime are valid.
	 */
	@Override
	public boolean updatePropertyRepairDateTime(
			Property propertyRepair, LocalDate dateTime) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isDateTimeValid(dateTime))
			return false;
		
		return propertyRepairRepository.updateDateTime(
				dateTime);
	}

	/**
	 * 	Updates the property repair with the new summary 
	 * 	if the property repair and the summary are valid.
	 */
	@Override
	public boolean updatePropertyRepairSummary(
			Property propertyRepair, String summary) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isSummaryValid(summary))
			return false;
		
		return propertyRepairRepository.updateSummary(
				summary);
	}

	/**
	 * 	Updates the property repair with the new repairType 
	 * 	if the property repair and the repairType are valid.
	 */
	@Override
	public boolean updatePropertyRepairType(
			Property propertyRepair, RepairType repairType) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isRepairTypeValid(repairType))
			return false;
		
		return propertyRepairRepository.updateRepairType(
				repairType);
	}

	/**
	 * 	Updates the property repair with the new statusType 
	 * 	if the property repair and the statusType are valid.
	 */
	@Override
	public boolean updatePropertyRepairStatusType(
			Property propertyRepair, StatusType statusType) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isStatusTypeValid(statusType))
			return false;
		
		return propertyRepairRepository.updateStatusType(
				statusType);
	}

	/**
	 * 	Updates the property repair with the new cost 
	 * 	if the property repair and the cost are valid.
	 */
	@Override
	public boolean updatePropertyRepairCost(
			Property propertyRepair, BigDecimal cost) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isCostValid(cost))
			return false;
		
		return propertyRepairRepository.updateCost(
				cost);
	}

	/**
	 * 	Updates the property repair with the new vatNumber 
	 * 	if the property repair and the vatNumber are valid.
	 */
	@Override
	public boolean updatePropertyRepairVatNumber(
			Property propertyRepair, String vatNumber) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isVatNumberValid(vatNumber))
			return false;
		
		return propertyRepairRepository.updateVatNumber(
				vatNumber);
	}

	/**
	 * 	Updates the property repair with the new repairDesc 
	 * 	if the property repair and the repairDesc are valid.
	 */
	@Override
	public boolean updatePropertyRepairDesc(
			Property propertyRepair, String repairDesc) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isRepairDescValid(repairDesc))
			return false;
		
		return propertyRepairRepository.updateRepairDesc(
				repairDesc);
	}

	/**
	 * 	Deletes the user if he is valid,
	 * 	otherwise returns false.
	 */
	@Override
	public boolean deleteUser(User user) {

		if( !isUserValid(user))
			return false;
		
		return userRepository.delete(user);
	}

	/**
	 * 	Deletes the property if it is valid,
	 * 	otherwise returns false.
	 */
	@Override
	public boolean deleteProperty(Property property) {

		if( !isPropertyValid(property))
			return false;
		
		return propertyRepository.delete(property);
	}

	/**
	 * 	Deletes the property repair if it is valid,
	 * 	otherwise returns false.
	 */
	@Override
	public boolean deletePropertyRepair(PropertyRepair propertyRepair) {

		if( !isPropertyRepairValid(propertyRepair))
			return false;
		
		return propertyRepairRepository.delete(propertyRepair);
	}

	/**
	 * 	Returns the user with the specific vat number, 
	 * 	otherwise returns null.
	 */
	@Override
	public User readUserWithVatNumber(String vatNumber) {

		if( !isVatNumberValid(vatNumber))
			return null;
		
		return userRepository.readByVatNumber(vatNumber);
	}

	/**
	 * 	Returns the user with the specific email, 
	 * 	otherwise returns null.
	 */
	@Override
	public User readUserWithEmail(String email) {

		if( !isEmailValid(email))
			return null;
		
		return userRepository.readByEmail(email);
	}
	
	/**
	 * 	Returns if the user is valid.
	 */
	private boolean isUserValid(User user) {
		// business logic
		return false;
	}

	/**
	 * 	Returns if the property is valid.
	 */
	private boolean isPropertyValid(Property property) {
		// business logic
		return false;
	}

	/**
	 * 	Returns if the property repair is valid.
	 */
	private boolean isPropertyRepairValid(
			PropertyRepair propertyRepair) {
		// business logic
		return false;
	}

	/**
	 * 	Returns if the address is valid.
	 */
	private boolean isAddressValid(String address) {
		// business logic
		return false;
	}
	
	/**
	 * 	Returns if the email is valid.
	 */
	private boolean isEmailValid(String email) {
		// business logic
		return false;
	}

	/**
	 * 	Returns if the password is valid.
	 */
	private boolean isPasswordValid(String password) {
		// business logic
		return false;
	}

	/**
	 * 	Returns if the constructionYear is valid.
	 */
	private boolean isConstructionYearValid(
			LocalDate constructionYear) {
		// business logic
		return false;
	}

	/**
	 * 	Returns if the propertyType is valid.
	 */
	private boolean isPropertyTypeValid(
			PropertyType propertyType) {
		// business logic
		return false;
	}

	/**
	 * 	Returns if the propertyRepair is valid.
	 */
	private boolean isPropertyRepairValid(
			Property propertyRepair) {
		// business logic
		return false;
	}

	/**
	 * 	Returns if the summary is valid.
	 */
	private boolean isSummaryValid(String summary) {
		// business logic
		return false;
	}

	/**
	 * 	Returns if the repairType is valid.
	 */
	private boolean isRepairTypeValid(RepairType repairType) {
		// business logic
		return false;
	}

	/**
	 * 	Returns if the statusType is valid.
	 */
	private boolean isStatusTypeValid(StatusType statusType) {
		// business logic
		return false;
	}

	/**
	 * 	Returns if the cost is valid.
	 */
	private boolean isCostValid(BigDecimal cost) {
		// business logic
		return false;
	}

	/**
	 * 	Returns if the repairDesc is valid.
	 */
	private boolean isRepairDescValid(String repairDesc) {
		// business logic
		return false;
	}
}
