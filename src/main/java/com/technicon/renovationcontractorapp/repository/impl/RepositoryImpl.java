package com.technicon.renovationcontractorapp.repository.impl;

import java.util.List;

import com.technicon.renovationcontractorapp.domain.Record;
import com.technicon.renovationcontractorapp.repository.Repository;

/**
 * 	This is the implementation of the repository interface.
 * 	It is abstract cause we will never instantiate this class.
 * 	We will instantiate its children only.
 * 
 * 	@author Grproth, skroutzzz
 * 	@param 	<R>	Can be User, Property or PropertyRepair.
 */
public abstract class RepositoryImpl implements Repository {

	protected List<Record> list;
	
	RepositoryImpl( List<Record> list){
		
		this.list = list;
	}
	
	public boolean addRecord( Record record) {
		
		return list.add(record);
	}
	public boolean deleteRecord( Record record) {
		
		return list.remove(record);
	}
}
