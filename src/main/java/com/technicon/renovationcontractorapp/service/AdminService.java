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

	boolean addUser( final User user);
	boolean addProperty( final Property property);
	boolean addPropertyRepair( final PropertyRepair propertyRepair);
	
	boolean updateUserAddress( final User user, final String address);
	boolean updateUserEmail( final User user, final String email);
	boolean updateUserPassword( final User user, final String password);
		
	boolean updatePropertyAddress( final Property property, final String address);
	boolean updatePropertyConstructionYear( final Property property, final LocalDate constructionYear);
	boolean updatePropertyType( final Property property, final PropertyType propertyType);
	boolean updatePropertyVatNumber( final Property property, final String vatNumber);
	
	boolean updatePropertyRepairDateTime( final Property propertyRepair, final LocalDate dateTime);
	boolean updatePropertyRepairSummary( final Property propertyRepair, final String summary);
	boolean updatePropertyRepairType( final Property propertyRepair, final RepairType repairType);
	boolean updatePropertyRepairStatusType( final Property propertyRepair, final StatusType statusType);
	boolean updatePropertyRepairCost( final Property propertyRepair, final BigDecimal cost);
	boolean updatePropertyRepairVatNumber( final Property propertyRepair, final String vatNumber);
	boolean updatePropertyRepairDesc( final Property propertyRepair, final String repairDesc);
	
	boolean deleteUser( final User user);
	boolean deleteProperty( final Property property);
	boolean deletePropertyRepair( final PropertyRepair propertyRepair);
	
	User readUserWithVatNumber( final String vatNumber);
	User readUserWithEmail( final String email);
}
