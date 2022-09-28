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
 * 	an administrator of the system will have.
 * 
 * 	@author Grproth, skroutzzz
 */
public interface AdminService {

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
	
	boolean updatePropertyRepairDateTime( Property property, LocalDate dateTime);
	boolean updatePropertyRepairSummary( Property property, String summary);
	boolean updatePropertyRepairType( Property property, RepairType repairType);
	boolean updatePropertyRepairStatusType( Property property, StatusType statusType);
	boolean updatePropertyRepairCost( Property property, BigDecimal cost);
	boolean updatePropertyRepairVatNumber( Property property, String vatNumber);
	boolean updatePropertyRepairDesc( Property property, String repairDesc);
	
	boolean deleteUser( User user);
	boolean deleteProperty( Property property);
	boolean deletePropertyRepair( PropertyRepair propertyRepair);
	
	User readUserWithVatNumber( String vatNumber);
	User readUserWithEmail( String email);
}
