package com.technicon.renovationcontractorapp.domain;

/**
 *  An enum helper type that represents the different apartment types.
 * 
 *  @author Grproth, skroutzzz
 */
public enum PropertyType {

	DETACHED_HOUSE("Detached House"),
	MAISONETTE("Maisonette"),
	APARTMENT_BUILDING("Apartment building");
	
	private final String description;
	
	private PropertyType( String description) {
		
		this.description = description;
	}
	
	@Override
	public String toString() {
		
		return description;
	}
}
