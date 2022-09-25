package com.technicon.renovationcontractorapp.domain;

/**
 * 	This is the class that represents the property itself.
 * 	Properties are owned by the owners users of the system.
 * 
 * 	@author Grproth, skroutzzz
 */
public class Property {

	private long pIdNumber;
	private String address;
	private int constructionYears;
	private PropertyType propertyType;
	private String ownersVatNumber;
	
	public Property( final long pIdNumber, final String address, 
			final int constructionYears, final PropertyType propertyType,
			final String ownersVatNumber) {
		
		this.pIdNumber = pIdNumber;
		this.address = address;
		this.constructionYears = constructionYears;
		this.propertyType = propertyType;
		this.ownersVatNumber = ownersVatNumber;
	}

	public long getpIdNumber() {
		return pIdNumber;
	}

	public void setpIdNumber(long pIdNumber) {
		this.pIdNumber = pIdNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getConstructionYears() {
		return constructionYears;
	}

	public void setConstructionYears(int constructionYears) {
		this.constructionYears = constructionYears;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public String getOwnersVatNumber() {
		return ownersVatNumber;
	}

	public void setOwnersVatNumber(String ownersVatNumber) {
		this.ownersVatNumber = ownersVatNumber;
	}
	
	public String header() {
		
		return "pIdNumber, address, constructionYears, "
				+ "propertyType, ownersVatNumber";
	}
	
	@Override
	public String toString() {
		
		return pIdNumber + ", " + address + ", " 
			+ constructionYears + ", " + propertyType + ", " 
			+ ownersVatNumber;
	}
}
