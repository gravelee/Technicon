package com.technicon.renovationcontractorapp.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.technicon.renovationcontractorapp.domain.Property;
import com.technicon.renovationcontractorapp.domain.PropertyRepair;
import com.technicon.renovationcontractorapp.domain.PropertyType;
import com.technicon.renovationcontractorapp.domain.RepairType;
import com.technicon.renovationcontractorapp.domain.StatusType;
import com.technicon.renovationcontractorapp.domain.User;

/**
 * 	This interface describes all the functionality
 * 	an administrator of the system will have. He can
 * 	also have the functionality of a regular user.
 * 
 * 	@author Grproth, skroutzzz
 */
public interface AdminService extends UserService {

	boolean addUser( User user);
	boolean addProperty( Property property);
	boolean addPropertyRepair( PropertyRepair propertyRepair);
	
	boolean updateUserAddress( User user, String address);
	boolean updateUserEmail( User user, String email);
	boolean updateUserPassword( User user, String password);
		
	boolean updatePropertyAddress( Property property, String address);
	boolean updatePropertyConstructionYear( Property property, LocalDate constructionYear);
	boolean updatePropertyType( Property property, PropertyType propertyType);
	boolean updatePropertyVatNumber( Property property, String vatNumber);
	
	boolean updatePropertyRepairDateTime( Property propertyRepair, LocalDate dateTime);
	boolean updatePropertyRepairSummary( Property propertyRepair, String summary);
	boolean updatePropertyRepairType( Property propertyRepair, RepairType repairType);
	boolean updatePropertyRepairStatusType( Property propertyRepair, StatusType statusType);
	boolean updatePropertyRepairCost( Property propertyRepair, BigDecimal cost);
	boolean updatePropertyRepairVatNumber( Property propertyRepair, String vatNumber);
	boolean updatePropertyRepairDesc( Property propertyRepair, String repairDesc);
	
	boolean deleteUser( User user);
	boolean deleteProperty( Property property);
	boolean deletePropertyRepair( PropertyRepair propertyRepair);
	
	User readUserWithVatNumber( String vatNumber);
	User readUserWithEmail( String email);
}
