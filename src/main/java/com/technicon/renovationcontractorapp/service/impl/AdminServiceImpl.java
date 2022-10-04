package com.technicon.renovationcontractorapp.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.technicon.renovationcontractorapp.domain.PropertyType;
import com.technicon.renovationcontractorapp.domain.RepairType;
import com.technicon.renovationcontractorapp.domain.StatusType;
import com.technicon.renovationcontractorapp.exception.InappropriateAddressValueException;
import com.technicon.renovationcontractorapp.exception.InappropriateConstructionYearValueException;
import com.technicon.renovationcontractorapp.exception.InappropriateCostValueException;
import com.technicon.renovationcontractorapp.exception.InappropriateDateValueException;
import com.technicon.renovationcontractorapp.exception.InappropriateDescriptionValueException;
import com.technicon.renovationcontractorapp.exception.InappropriateEmailValueException;
import com.technicon.renovationcontractorapp.exception.InappropriatePasswordValueException;
import com.technicon.renovationcontractorapp.exception.InappropriatePropertyException;
import com.technicon.renovationcontractorapp.exception.InappropriatePropertyRepairException;
import com.technicon.renovationcontractorapp.exception.InappropriatePropertyTypeValueException;
import com.technicon.renovationcontractorapp.exception.InappropriateRepairTypeValueException;
import com.technicon.renovationcontractorapp.exception.InappropriateSummaryValueException;
import com.technicon.renovationcontractorapp.exception.InappropriateUserException;
import com.technicon.renovationcontractorapp.exception.InappropriateVatNumberValueException;
import com.technicon.renovationcontractorapp.model.Property;
import com.technicon.renovationcontractorapp.model.PropertyRepair;
import com.technicon.renovationcontractorapp.model.User;
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
 * 	@author Grproth, skroutzzz, Chris394
 */
public class AdminServiceImpl extends UserServiceImpl 
		implements AdminService {

	private UserRepository userRepository;
	
	public AdminServiceImpl( UserRepository userRepository, 
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
		
		if( !isUserValid(user)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, new InappropriateUserException(
					"Error, inappropriate user value(s)!"));
			
			return false;
		}
		
		try( userRepository.add(user);) {
			
			return true;
			
		}catch( Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, ex);
			
			return false;
		}
	}

	/**
	 * 	Adds the property if it is valid,
	 * 	otherwise returns false.
	 */
	@Override
	public boolean addProperty(Property property) {

		if( !isPropertyValid(property)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, new InappropriatePropertyException(
					"Error, inappropriate property value(s)!"));
			
			return false;
		}
		
		try( propertyRepository.add(property);) {
			
			return true;
		
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, ex);
			
			return false;
		}
	}

	/**
	 * 	Adds the property repair if it is valid,
	 * 	otherwise returns false.
	 */
	@Override
	public boolean addPropertyRepair(PropertyRepair propertyRepair) {

		if( !isPropertyRepairValid(propertyRepair)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, new InappropriatePropertyRepairException(
					"Error, inappropriate property repair value(s)!"));
			
			return false;
		}
		
		try( propertyRepairRepository.add(propertyRepair);) {
			
			return true;
		
		}catch(Exception ex) {
		
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, ex);
			
			return false;
		}
	}

	/**
	 * 	Updates the user with the new address if 
	 * 	the user and the address are valid.
	 */
	@Override
	public boolean updateUserAddress(User user, String address) {
		
		if( !isUserValid(user) || !isAddressValid(address))
			return false;
		
		if( !userRepository.updateAddress( user.getVatNumber(), address)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, new InappropriateAddressValueException(
					"Error, inappropriate address value! (" + address + ")"));
			
			return false;
		}
		
		return true;
	}

	/**
	 * 	Updates the user with the new email if 
	 * 	the user and the email are valid.
	 */
	@Override
	public boolean updateUserEmail(User user, String email) {
		
		if( !isUserValid(user) || !isEmailValid(email))
			return false;
		
		if( !userRepository.updateEmail( user.getVatNumber(), email)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, new InappropriateEmailValueException(
					"Error, inappropriate email value! (" + email + ")"));
			
			return false;
		}
		
		return true;
	}

	/**
	 * 	Updates the user with the new password if 
	 * 	the user and the password are valid.
	 */
	@Override
	public boolean updateUserPassword(User user, String password) {
		
		if( !isUserValid(user) || !isPasswordValid(password))
			return false;
		
		if( !userRepository.updatePassword( user.getVatNumber(), password)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, new InappropriatePasswordValueException(
					"Error, inappropriate password value! (" + password + ")"));
			
			return false;
		}
		
		return true;
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
		
		if( !propertyRepository.updateAddress( 
				property.getPropertyId(), address)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, new InappropriateAddressValueException(
					"Error, inappropriate address value! (" + address + ")"));
			
			return false;
		}
		
		return true;
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
		
		if( !propertyRepository.updateConstructionYear( 
				property.getPropertyId(), constructionYear)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, 
				new InappropriateConstructionYearValueException(
					"Error, inappropriate construction year value! (" 
							+ constructionYear + ")"));
			
			return false;
		}
		
		return true;
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
		
		if( !propertyRepository.updatePropertyType( 
				property.getPropertyId(), propertyType)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, 
				new InappropriatePropertyTypeValueException(
					"Error, inappropriate property type value! (" 
							+ propertyType + ")"));
			
			return false;
		}
		
		return true;
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
		
		if( !propertyRepository.updateVatNumber( 
				property.getPropertyId(), vatNumber)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, 
				new InappropriateVatNumberValueException(
					"Error, inappropriate vat number value! (" 
							+ vatNumber + ")"));
			
			return false;
		}
		
		return true;
	}

	/**
	 * 	Updates the property repair with the new dateTime 
	 * 	if the property repair and the dateTime are valid.
	 */
	@Override
	public boolean updatePropertyRepairDateTime(
			PropertyRepair propertyRepair, LocalDate dateTime) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isDateTimeValid(dateTime))
			return false;
		
		if( !propertyRepairRepository.updateDateTime( 
				propertyRepair.getPropertyRepairId(), dateTime)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, 
				new InappropriateDateValueException(
					"Error, inappropriate date value! (" 
							+ dateTime + ")"));
			
			return false;
		}
		
		return true;
	}

	/**
	 * 	Updates the property repair with the new summary 
	 * 	if the property repair and the summary are valid.
	 */
	@Override
	public boolean updatePropertyRepairSummary(
			PropertyRepair propertyRepair, String summary) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isSummaryValid(summary))
			return false;
		
		if( !propertyRepairRepository.updateSummary( 
				propertyRepair.getPropertyRepairId(), summary)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, 
				new InappropriateSummaryValueException(
					"Error, inappropriate summary value! (" 
							+ summary + ")"));
			
			return false;
		}
		
		return true;
	}

	/**
	 * 	Updates the property repair with the new repairType 
	 * 	if the property repair and the repairType are valid.
	 */
	@Override
	public boolean updatePropertyRepairType(
			PropertyRepair propertyRepair, RepairType repairType) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isRepairTypeValid(repairType))
			return false;
		
		if( !propertyRepairRepository.updateRepairType( 
				propertyRepair.getPropertyRepairId(), repairType)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, 
				new InappropriateRepairTypeValueException(
					"Error, inappropriate repair type value! (" 
							+ repairType + ")"));
			
			return false;
		}
		
		return true;
	}

	/**
	 * 	Updates the property repair with the new statusType 
	 * 	if the property repair and the statusType are valid.
	 */
	@Override
	public boolean updatePropertyRepairStatusType(
			PropertyRepair propertyRepair, StatusType statusType) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isStatusTypeValid(statusType))
			return false;
		
		if( !propertyRepairRepository.updateStatusType( 
				propertyRepair.getPropertyRepairId(), statusType)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, 
				new InappropriateDateValueException(
					"Error, inappropriate status type value! (" 
							+ statusType + ")"));
			
			return false;
		}
		
		return true;
	}

	/**
	 * 	Updates the property repair with the new cost 
	 * 	if the property repair and the cost are valid.
	 */
	@Override
	public boolean updatePropertyRepairCost(
			PropertyRepair propertyRepair, BigDecimal cost) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isCostValid(cost))
			return false;
		
		if( !propertyRepairRepository.updateCost( 
				propertyRepair.getPropertyRepairId(), cost)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, 
				new InappropriateCostValueException(
					"Error, inappropriate cost value! (" 
							+ cost + ")"));
			
			return false;
		}
		
		return true;
	}

	/**
	 * 	Updates the property repair with the new vatNumber 
	 * 	if the property repair and the vatNumber are valid.
	 */
	@Override
	public boolean updatePropertyRepairVatNumber(
			PropertyRepair propertyRepair, String vatNumber) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isVatNumberValid(vatNumber))
			return false;
		
		if( !propertyRepairRepository.updateVatNumber( 
				propertyRepair.getPropertyRepairId(), vatNumber)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, 
				new InappropriateVatNumberValueException(
					"Error, inappropriate vat number value! (" 
							+ vatNumber + ")"));
			
			return false;
		}
		
		return true;
	}

	/**
	 * 	Updates the property repair with the new repairDesc 
	 * 	if the property repair and the repairDesc are valid.
	 */
	@Override
	public boolean updatePropertyRepairDesc(
			PropertyRepair propertyRepair, String repairDesc) {
		
		if( !isPropertyRepairValid(propertyRepair) || 
				!isRepairDescValid(repairDesc))
			return false;
		
		if( !propertyRepairRepository.updateRepairDesc( 
				propertyRepair.getPropertyRepairId(), repairDesc)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.SEVERE, null, 
				new InappropriateDescriptionValueException(
					"Error, inappropriate repair description value! (" 
							+ repairDesc + ")"));
			
			return false;
		}
		
		return true;
	}

	/**
	 * 	Deletes the user if he is valid,
	 * 	otherwise returns false.
	 */
	@Override
	public boolean deleteUser(User user) {

		if( !isUserValid(user))
			return false;
		
		return userRepository.delete(user.getUserId());
	}

	/**
	 * 	Deletes the property if it is valid,
	 * 	otherwise returns false.
	 */
	@Override
	public boolean deleteProperty(Property property) {

		if( !isPropertyValid(property))
			return false;
		
		return propertyRepository.delete(
			property.getPropertyId());
	}

	/**
	 * 	Deletes the property repair if it is valid,
	 * 	otherwise returns false.
	 */
	@Override
	public boolean deletePropertyRepair(PropertyRepair propertyRepair) {

		if( !isPropertyRepairValid(propertyRepair))
			return false;
		
		return propertyRepairRepository.delete(
			propertyRepair.getPropertyRepairId());
	}

	/**
	 * 	Returns the user with the specific vat number, 
	 * 	otherwise returns null.
	 */
	@Override
	public User readUserWithVatNumber(String vatNumber) {

		if( !isVatNumberValid(vatNumber)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.SEVERE, null, 
				new InappropriateVatNumberValueException(
					"Error, inappropriate vat number value! ("
						+ vatNumber + ")"));
			
			return null;
		}
		
		User user = userRepository.readByVatNumber(vatNumber);
		
		if( user == null) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.SEVERE, null, "Error, "
				+ "there are no results that asserts that query!");
			
			return null;
		}
		
		return user;
	}

	/**
	 * 	Returns the user with the specific email, 
	 * 	otherwise returns null.
	 */
	@Override
	public User readUserWithEmail(String email) {

		if( !isEmailValid(email)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.SEVERE, null, 
				new InappropriateEmailValueException(
					"Error, inappropriate email value! ("
						+ email + ")"));
			
			return null;
		}
		
		User user = userRepository.readByEmail(email);
		
		if( user == null) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.SEVERE, null, "Error, "
				+ "there are no results that asserts that query!");
			
			return null;
		}
		
		return user;
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
