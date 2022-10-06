package com.technicon.renovationcontractorapp.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import com.technicon.renovationcontractorapp.domain.PropertyType;
import com.technicon.renovationcontractorapp.domain.RepairType;
import com.technicon.renovationcontractorapp.domain.StatusType;
import com.technicon.renovationcontractorapp.exception.InappropriateAddressValueException;
import com.technicon.renovationcontractorapp.exception.InappropriateCostValueException;
import com.technicon.renovationcontractorapp.exception.InappropriateDateValueException;
import com.technicon.renovationcontractorapp.exception.InappropriateEmailValueException;
import com.technicon.renovationcontractorapp.exception.InappropriatePasswordValueException;
import com.technicon.renovationcontractorapp.exception.InappropriatePropertyException;
import com.technicon.renovationcontractorapp.exception.InappropriatePropertyRepairException;
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
				.log( Level.WARNING, null, new InappropriateUserException(
					"Error, inappropriate user value(s)! ("
						+ user.toString() + ")"));
			
			return false;
		}
		
		Optional<User> result;
		
		try {
		
			result = userRepository.add(user);
		
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if( !result.isPresent()) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "there are no results that assert that query!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "user has been added successfully!");
		
		return true;
	}

	/**
	 * 	Adds the property if it is valid,
	 * 	otherwise returns false.
	 */
	@Override
	public boolean addProperty(Property property) {

		if( !isPropertyValid(property)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, new InappropriatePropertyException(
					"Error, inappropriate property value(s)! ("
						+ property.toString() + ")"));
			
			return false;
		}
		
		Optional<Property> result;
		
		try {
		
			result = propertyRepository.add(property);
		
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if( !result.isPresent()) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "there are no results that assert that query!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "property has been added successfully!");
		
		return true;
	}

	/**
	 * 	Adds the property repair if it is valid,
	 * 	otherwise returns false.
	 */
	@Override
	public boolean addPropertyRepair(PropertyRepair propertyRepair) {

		if( !isPropertyRepairValid(propertyRepair)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, new InappropriatePropertyRepairException(
					"Error, inappropriate property repair value(s)! ("
						+ propertyRepair.toString() + ")"));
			
			return false;
		}
		
		Optional<PropertyRepair> result;
		
		try {
		
			result = propertyRepairRepository.add(propertyRepair);
		
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if( !result.isPresent()) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "there are no results that assert that query!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "property repair has been added successfully!");
		
		return true;
	}

	/**
	 * 	Updates the user with the new address if 
	 * 	the user and the address are valid.
	 */
	@Override
	public boolean updateUserAddress(User user, String address) {
		
		if( !isAddressValid(address)){
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, 
					new InappropriateAddressValueException(
						"Error, inappropriate address value! ("
							+ address + ")"));
			
			return false;
		}
		
		boolean updated;
		
		try{
			
			updated =  userRepository.updateAddress(
				user.getVatNumber(),address);
		
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if(!updated) {

			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "something went wrong with update!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "user has been updated successfully!");
		
		return true;
	}

	/**
	 * 	Updates the user with the new email if 
	 * 	the user and the email are valid.
	 */
	@Override
	public boolean updateUserEmail(User user, String email) {
		
		if( !isEmailValid(email)){
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, 
					new InappropriateEmailValueException(
						"Error, inappropriate email value! ("
							+ email + ")"));
			
			return false;
		}
		
		boolean updated;
		
		try{
			
			updated =  userRepository.updateEmail(
				user.getVatNumber(),email);
			
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if(!updated) {

			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "something went wrong with update!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "user has been updated successfully!");
		
		return true;
	}

	/**
	 * 	Updates the user with the new password if 
	 * 	the user and the password are valid.
	 */
	@Override
	public boolean updateUserPassword(User user, String password) {
		
		if( !isPasswordValid(password)){
			
			Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.WARNING, null, 
				new InappropriatePasswordValueException(
					"Error, inappropriate password value! ("
						+ password + ")"));
			
			return false;
		}
		
		boolean updated;
		
		try {
			
			updated =  userRepository.updatePassword(
					user.getVatNumber(),password);
		
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if(!updated) {

			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "something went wrong with update!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "user has been updated successfully!");
		
		return true;
	}

	/**
	 * 	Updates the property with the new address if 
	 * 	the property and the address are valid.
	 */
	@Override
	public boolean updatePropertyAddress(
			Property property, String address) {
		
		if( !isAddressValid(address)){
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, 
					new InappropriateAddressValueException(
						"Error, inappropriate address value! ("
							+ address + ")"));
			
			return false;
		}
		
		boolean updated;
		
		try {
			
			updated =  propertyRepository.updateAddress(
					property.getPropertyId(),address);
		
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if(!updated) {

			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "something went wrong with update!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "porperty has been updated successfully!");
		
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

		if( !isDateValid(constructionYear)){
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, 
					new InappropriateDateValueException(
					"Error, inappropriate construction year value! ("
						+ constructionYear + ")"));
			
			return false;
		}
		
		boolean updated;
		
		try {
			
			updated =  propertyRepository.updateConstructionYear(
				property.getPropertyId(),constructionYear);
			
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if(!updated) {

			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "something went wrong with update!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "porperty has been updated successfully!");
		
		return true;
	}

	/**
	 * 	Updates the property with the new property type if 
	 * 	the property and the property type are valid.
	 */
	@Override
	public boolean updatePropertyType(Property property, 
			PropertyType propertyType) {

		boolean updated;
		
		try{
			
			updated =  propertyRepository.updatePropertyType(
				property.getPropertyId(),propertyType);
		
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if(!updated) {

			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "something went wrong with update!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "porperty has been updated successfully!");
		
		return true;
	}

	/**
	 * 	Updates the property repair with the new dateTime 
	 * 	if the property repair and the dateTime are valid.
	 */
	@Override
	public boolean updatePropertyRepairDateTime(
			PropertyRepair propertyRepair, LocalDate date) {
		
		if( !isDateValid(date)){
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, 
					new InappropriateDateValueException(
						"Error, inappropriate date value! ("
							+ date + ")"));
			
			return false;
		}
		
		boolean updated;
		
		try{
			
			updated =  propertyRepairRepository.updateDateTime(
				propertyRepair.getPropertyRepairId(),date);
		
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if(!updated) {

			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "something went wrong with update!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "porperty repair has been updated successfully!");
		
		return true;
	}

	/**
	 * 	Updates the property repair with the new summary 
	 * 	if the property repair and the summary are valid.
	 */
	@Override
	public boolean updatePropertyRepairSummary(
			PropertyRepair propertyRepair, String summary) {
		
		boolean updated;
		
		try{
			
			updated =  propertyRepairRepository.updateSummary(
				propertyRepair.getPropertyRepairId(),summary);
		
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if(!updated) {

			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "something went wrong with update!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "porperty repair has been updated successfully!");
		
		return true;
	}

	/**
	 * 	Updates the property repair with the new repairType 
	 * 	if the property repair and the repairType are valid.
	 */
	@Override
	public boolean updatePropertyRepairType(
			PropertyRepair propertyRepair, RepairType repairType) {
		
		boolean updated;
		
		try{
			
			updated =  propertyRepairRepository.updateRepairType(
				propertyRepair.getPropertyRepairId(),repairType);
		
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if(!updated) {

			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "something went wrong with update!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "porperty repair has been updated successfully!");
		
		return true;
	}

	/**
	 * 	Updates the property repair with the new statusType 
	 * 	if the property repair and the statusType are valid.
	 */
	@Override
	public boolean updatePropertyRepairStatusType(
			PropertyRepair propertyRepair, StatusType statusType) {

		boolean updated;
		
		try{
			
			updated =  propertyRepairRepository.updateStatusType(
				propertyRepair.getPropertyRepairId(),statusType);
		
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if(!updated) {

			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "something went wrong with update!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "porperty repair has been updated successfully!");
		
		return true;
	}

	/**
	 * 	Updates the property repair with the new cost 
	 * 	if the property repair and the cost are valid.
	 */
	@Override
	public boolean updatePropertyRepairCost(
			PropertyRepair propertyRepair, BigDecimal cost) {

		if( !isCostValid(cost)){
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, 
					new InappropriateCostValueException(
						"Error, inappropriate cost value! ("
							+ cost + ")"));
			
			return false;
		}
		
		boolean updated;
		
		try{
			
			updated =  propertyRepairRepository.updateCost(
				propertyRepair.getPropertyRepairId(),cost);
		
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if(!updated) {

			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "something went wrong with update!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "porperty repair has been updated successfully!");
		
		return true;
	}

	/**
	 * 	Updates the property repair with the new repairDesc 
	 * 	if the property repair and the repairDesc are valid.
	 */
	@Override
	public boolean updatePropertyRepairDesc(
			PropertyRepair propertyRepair, String repairDesc) {

		boolean updated;
		
		try{
			
			updated =  propertyRepairRepository.updateRepairDesc(
				propertyRepair.getPropertyRepairId(),repairDesc);
		
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if(!updated) {

			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "something went wrong with update!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "porperty repair has been updated successfully!");
		
		return true;
	}

	/**
	 * 	Deletes the user if he is valid,
	 * 	otherwise returns false.
	 */
	@Override
	public boolean deleteUser(User user) {

		boolean deleted;
		
		try {
			
			deleted =  userRepository.delete(
					user.getUserId());
		
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if(!deleted) {

			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "something went wrong with deletion!");
			
			return false;
		}

		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "user has been deleted successfully!");
		
		return true;
	}

	/**
	 * 	Deletes the property if it is valid,
	 * 	otherwise returns false.
	 */
	@Override
	public boolean deleteProperty(Property property) {

		boolean deleted;
		
		try {
			
			deleted =  propertyRepository.delete(
				property.getPropertyId());
			
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if(!deleted) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "something went wrong with deletion!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "preperty has been deleted successfully!");
	
		return true;
	}

	/**
	 * 	Deletes the property repair if it is valid,
	 * 	otherwise returns false.
	 */
	@Override
	public boolean deletePropertyRepair(PropertyRepair propertyRepair) {

		boolean deleted;
		
		try {
			
			deleted =  propertyRepairRepository.delete(
				propertyRepair.getPropertyRepairId());
			
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
			
			return false;
		}
		
		if(!deleted) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "something went wrong with deletion!");
			
			return false;
		}
		
		Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Success, "
				+ "preperty repair has been deleted successfully!");
		
		return true;
	}

	/**
	 * 	Returns the user with the specific vat number, 
	 * 	otherwise returns null.
	 */
	@Override
	public User readUserWithVatNumber(String vatNumber) {

		if( !isVatNumberValid(vatNumber)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, 
					new InappropriateVatNumberValueException(
						"Error, inappropriate vat number value! ("
							+ vatNumber + ")"));
			
			return null;
		}
		
		Optional<User> user = null;
		
		try {
			
			user = userRepository.readByVatNumber(vatNumber);
			
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
		}
		
		if( !user.isPresent()) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.INFO, null, "Error, "
					+ "there are no results that assert that query!");
			
			return null;
		}
		
		return user.get();
	}

	/**
	 * 	Returns the user with the specific email, 
	 * 	otherwise returns null.
	 */
	@Override
	public User readUserWithEmail(String email) {

		if( !isEmailValid(email)) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, 
					new InappropriateEmailValueException(
						"Error, inappropriate email value! ("
							+ email + ")"));
			
			return null;
		}
		
		Optional<User> user = null;
		
		try {
			
			user = userRepository.readByEmail(email);
			
		}catch(Exception ex) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
				.log( Level.WARNING, null, ex);
		}
		
		if( !user.isPresent()) {
			
			Logger.getLogger( AdminServiceImpl.class.getName())
			.log( Level.INFO, null, "Error, "
				+ "there are no results that assert that query!");
			
			return null;
		}
		
		return user.get();
	}
	
	/**
	 * 	Returns if the user is valid.
	 */
	private boolean isUserValid(User user) {
		
		if( isVatNumberValid(user.getVatNumber()) &&
			isAddressValid(user.getAddress()) &&
				isEmailValid(user.getEmail()) &&
					isPasswordValid(user.getPassword())){
			
			return true;
		}
		
		return false;
	}

	/**
	 * 	Returns if the property is valid.
	 */
	private boolean isPropertyValid(Property property) {
		
		if( isAddressValid(property.getAddress()) &&
			isDateValid(property.getConstructionYear())
			){
			
			return true;
		}
		
		return false;
	}

	/**
	 * 	Returns if the property repair is valid.
	 */
	private boolean isPropertyRepairValid(
			PropertyRepair propertyRepair) {
		
		if( isDateValid(propertyRepair.getDateTime()) &&
				isCostValid(propertyRepair.getCost())){
			
			return true;
		}
		
		return false;
	}

	/**
	 * 	Returns if the address is valid.
	 */
	private boolean isAddressValid(String address) {
		
		String regex = "[\\w\\s]*\\d*";
        Pattern pattern = Pattern.compile(regex);
        
        return pattern.matcher(address).matches();
	}
	
	/**
	 * 	Returns if the email is valid.
	 */
	private boolean isEmailValid(String email) {
		
		String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        
        return pattern.matcher(email).matches();
	}

	/**
	 * 	Returns if the password is valid.
	 */
	private boolean isPasswordValid(String password) {
		 
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])"
				+ "(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        
        return pattern.matcher(password).matches();
	}

	/**
	 * 	Returns if the cost is valid.
	 */
	private boolean isCostValid(BigDecimal cost) {
		
		return (cost.compareTo(BigDecimal.ZERO)>0);
	}

	@Override
	public boolean updatePropertyVatNumber(Property property, String vatNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePropertyRepairVatNumber(PropertyRepair propertyRepair, String vatNumber) {
		// TODO Auto-generated method stub
		return false;
	}
}
