package com.technicon.renovationcontractorapp.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.technicon.renovationcontractorapp.domain.PropertyType;
import com.technicon.renovationcontractorapp.domain.RepairType;
import com.technicon.renovationcontractorapp.domain.StatusType;
import com.technicon.renovationcontractorapp.model.Property;
import com.technicon.renovationcontractorapp.model.PropertyRepair;
import com.technicon.renovationcontractorapp.model.User;

/**
 * 	This interface describes all the functionality
 * 	an administrator of the system will have. He can
 * 	also have the functionality of a regular user.
 * 
 * 	@author Grproth, skroutzzz, Chris394
 */
public interface AdminService extends UserService {

	boolean addUser( final User user);
	boolean addProperty( final Property property);
	boolean addPropertyRepair( final PropertyRepair propertyRepair);
	
	boolean updateUserAddress( final User user, final String address);
	boolean updateUserEmail( final User user, final String email);
	boolean updateUserPassword( final User user, final String password);
		
	boolean updatePropertyAddress( final Property property, final String address);
	boolean updatePropertyConstructionYear( final Property property, final LocalDate constructionYear);
	boolean updatePropertyType( final Property property, final PropertyType propertyType);
	
	boolean updatePropertyRepairDateTime( final PropertyRepair propertyRepair, final LocalDate dateTime);
	boolean updatePropertyRepairSummary( final PropertyRepair propertyRepair, final String summary);
	boolean updatePropertyRepairType( final PropertyRepair propertyRepair, final RepairType repairType);
	boolean updatePropertyRepairStatusType( final PropertyRepair propertyRepair, final StatusType statusType);
	boolean updatePropertyRepairCost( final PropertyRepair propertyRepair, final BigDecimal cost);
	boolean updatePropertyRepairDesc( final PropertyRepair propertyRepair, final String repairDesc);
	
	boolean deleteUser( final User user);
	boolean deleteProperty( final Property property);
	boolean deletePropertyRepair( final PropertyRepair propertyRepair);
	
	User readUserWithVatNumber( final String vatNumber);
	User readUserWithEmail( final String email);
}
