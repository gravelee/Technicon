package com.technicon.renovationcontractorapp.service;

/**
 * 	This interface describes all the functionality
 * 	an administrator of the system will have.
 * 
 * 	@author Grproth, skroutzzz
 */
public interface RenovationContractorAdminService {

	// can add admins
	// can add owners
	// can add properties
	// can add propertyRepairs
	
	// can change the status of admins		
	//		->	password, email, address 
	//( afou den valame to delete admin tote oute auth h leitourgia exei noima)
	
	// can change the status of owners		->	password, email, address
	
	// can change the status of properties		
	//		->  pIdNumber, address, constructionYears, propertyType, ownersVatNumber
	
	// can change the status of propertyRepairs	
	//		->	datetime, summary, repairType, statusType, cost, ownerVatNumber, 
	//		->	pIdNumber, repairDesc
	
	// can delete owners
	// can delete properties
	// can delete propertyRepairs
	
	// search admins			-> email
	// search owners			-> email, vat
	// search properties		-> pId, vat
	// search propertiesRepair	-> date, two dates, vat
}
