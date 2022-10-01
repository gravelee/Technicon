package com.technicon.renovationcontractorapp.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 * 	This is the class that represents the property itself.
 * 	Properties are owned by the owners users of the system.
 * 
 * 	@author Grproth, skroutzzz
 */
@Entity
public class Property {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long propertyId;
	
	private String address;
	private LocalDate constructionYear;
	private PropertyType propertyType;
	private String vatNumber;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="property")
	private List<PropertyRepair> propertyRepairs;
	

	
	public Property() {
		
	}

	public Property( String address, 
			LocalDate constructionYear, PropertyType propertyType,
			String vatNumber) {
		
		
		this.address = address;
		this.constructionYear = constructionYear;
		this.propertyType = propertyType;
		this.vatNumber = vatNumber;
	}

	public long getPropertyId() {
		return propertyId;
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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PropertyRepair> getPropertyRepairs() {
		return propertyRepairs;
	}

	public void setPropertyRepairs(List<PropertyRepair> propertyRepairs) {
		this.propertyRepairs = propertyRepairs;
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
