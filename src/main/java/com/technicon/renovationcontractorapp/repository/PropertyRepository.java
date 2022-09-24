package com.technicon.renovationcontractorapp.repository;

/**
 * 	A more specific interface that extends the repository.
 * 	It represents the property repository with the specific
 * 	update & read methods of all its attributes.
 * 
 * 	@author Grproth, skroutzzz
 */
public interface PropertyRepository extends Repository{

	// read based on vatNumber, pIdNumber
	// updates for pIdNumber, address, constructionYears, propertyType, ownersVatNumber
}
