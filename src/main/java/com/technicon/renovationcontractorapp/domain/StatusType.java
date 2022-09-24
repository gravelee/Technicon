package com.technicon.renovationcontractorapp.domain;

/**
 *  An enum helper type that represents the different repair
 *  statuses types.
 * 
 *  @author Grproth
 */
public enum StatusType {

	PENDING("Pending"),
	IN_PROGRESS("In Progress"),
	COMPLETE("Complete");
	
	private final String description;
	
	private StatusType( String description) {
		
		this.description = description;
	}
	
	@Override
	public String toString() {
		
		return description;
	}
}
