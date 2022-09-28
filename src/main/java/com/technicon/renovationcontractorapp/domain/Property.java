package com.technicon.renovationcontractorapp.domain;

import java.time.LocalDate;

/**
 * 	This is the class that represents the property itself.
 * 	Properties are owned by the owners users of the system.
 * 
 * 	@author Grproth, skroutzzz
 */
public class Property {

	private long propertyId;
	private String address;
	private LocalDate constructionYear;
	private PropertyType propertyType;
	private String vatNumber;
	
	public Property( long pIdNumber, String address, 
			LocalDate constructionYear, PropertyType propertyType,
			String ownersVatNumber) {
		
		this.propertyId = pIdNumber;
		this.address = address;
		this.constructionYear = constructionYear;
		this.propertyType = propertyType;
		this.vatNumber = ownersVatNumber;
	}

	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId( long propertyId) {
		this.propertyId = propertyId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress( String address) {
		this.address = address;
	}

	public LocalDate getConstructionYear() {
		return constructionYear;
	}

	public void setConstructionYear( LocalDate constructionYear) {
		this.constructionYear = constructionYear;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType( PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber( String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public String header() {
		
		return "propertyId, address, constructionYear, "
				+ "propertyType, vatNumber";
	}
	
	@Override
	public String toString() {
		
		return propertyId + ", " + address + ", " 
			+ constructionYear + ", " + propertyType + ", " 
			+ vatNumber;
	}
}
