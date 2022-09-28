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
public interface AdminService extends UserService {

	boolean addUser( User user);
	boolean addProperty( Property property);
	boolean addPropertyRepair( PropertyRepair propertyRepair);
	
	boolean updateUserAddress( long userId, String address);
	boolean updateUserEmail( long userId, String email);
	boolean updateUserPassword( long userId, String password);
		
	boolean updatePropertyAddress( long propertyId, String address);
	boolean updatePropertyConstructionYear( long propertyId, LocalDate constructionYear);
	boolean updatePropertyType( long propertyId, PropertyType propertyType);
	boolean updatePropertyVatNumber( long propertyId, String vatNumber);
	
	boolean updatePropertyRepairDateTime( long propertyRepairId, LocalDate dateTime);
	boolean updatePropertyRepairSummary( long propertyRepairId, String summary);
	boolean updatePropertyRepairType( long propertyRepairId, RepairType repairType);
	boolean updatePropertyRepairStatusType( long propertyRepairId, StatusType statusType);
	boolean updatePropertyRepairCost( long propertyRepairId, BigDecimal cost);
	boolean updatePropertyRepairVatNumber( long propertyRepairId, String vatNumber);
	boolean updatePropertyRepairDesc( long propertyRepairId, String repairDesc);
	
	boolean deleteUser( User user);
	boolean deleteProperty( Property property);
	boolean deletePropertyRepair( PropertyRepair propertyRepair);
	
	User readUserWithVatNumber( String vatNumber);
	User readUserWithEmail( String email);
}
