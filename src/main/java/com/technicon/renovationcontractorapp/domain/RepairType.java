package com.technicon.renovationcontractorapp.domain;

/**
 *  An enum helper type that represents the different apartment types.
 * 
 *  @author Grproth
 */
public enum RepairType {

	PAINTING("Painting"),
	INSULATION("Insulation"),
	FRAMES("Frames"),
	PLUMBING("Plumbing"),
	ELECTRICAL_WORK("Electrical work");
	
	private final String description;
	
	private RepairType( String description) {
		
		this.description = description;
	}
	
	@Override
	public String toString() {
		
		return description;
	}
}
