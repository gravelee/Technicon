package com.technicon.renovationcontractorapp.repository;

/**
 * 	A more specific interface that extends the repository.
 * 	It represents the property-repair repository with the 
 * 	specific update & read methods of all its attributes.
 * 
 * 	@author Grproth
 */
public interface PropertyRepairRepository extends Repository {

	// read based on dateTime, vatNumber
	// updates for datetime, summary, repairType, statusType, cost, ownerVatNumber, pIdNumber, repairDesc

}
