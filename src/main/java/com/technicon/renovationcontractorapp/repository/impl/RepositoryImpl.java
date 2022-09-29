package com.technicon.renovationcontractorapp.repository.impl;

import java.util.List;

import com.technicon.renovationcontractorapp.domain.Entity;
import com.technicon.renovationcontractorapp.repository.Repository;

/**
 * 	This is the implementation of the repository interface.
 * 	It is abstract cause we will never instantiate this class.
 * 	We will instantiate its children only.
 * 
 * 	@author Grproth, skroutzzz, Chris394
 * 	@param 	<R>	Can be User, Property or PropertyRepair.
 */
public abstract class RepositoryImpl<T extends Entity> implements Repository<T> {
	
	private final List<T> list;
	
	public RepositoryImpl(List<T> list) {
        this.list = list;
   }
	
	public boolean add (T t){
	    if (t.isValid())
		       list.add(t);
	    return true;
	}
	
	public List<T> read(){
        return list;
    }
	
	public T read(long id){
		 
        for (T t:list){
            if (t.getId() == id){
                   return t;
            }
        }
        return null; 
    }
		
	 public boolean delete(long tId){
	        T t = read(tId);
	        if( t == null) return false;
	        list.remove(t);
	        return true;
	    }
}
