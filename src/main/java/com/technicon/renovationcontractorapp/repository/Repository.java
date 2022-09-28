package com.technicon.renovationcontractorapp.repository;

import java.util.List;

import com.technicon.renovationcontractorapp.domain.Record;

/**
 * 	This is the interface that defines the CRUD
 * 	methods that a repository needs to be implemented.
 * 	update & read functionality will be added into the
 * 	interfaces that extend this one cause they are
 * 	more specific.
 * 
 * 	@author Grproth, skroutzzz
 */
public interface Repository {

	boolean addRecord( Record record);
	boolean deleteRecord( Record record);
}
