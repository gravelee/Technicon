package com.technicon.renovationcontractorapp.repository;

import java.util.List;
import java.util.Optional;

/**
 * 	This is the interface that defines the CRUD
 * 	methods that a repository needs to be implemented.
 * 	update & read functionality will be added into the
 * 	interfaces that extend this one cause they are
 * 	more specific.
 * 
 * 	@author Grproth, skroutzzz, Chris394
 */
public interface Repository<T, K> {

	Optional<T> add(T t);
	List<T> read(int pageNumber, int pageSize);
	Optional<T> read(K tId);
	boolean delete(K tId);
}
