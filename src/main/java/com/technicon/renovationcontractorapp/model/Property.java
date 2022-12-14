package com.technicon.renovationcontractorapp.model;

import java.time.LocalDate;
import java.util.List;

import com.technicon.renovationcontractorapp.domain.PropertyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 * 	This is the class that represents the property itself.
 * 	Properties are owned by the owners users of the system.
 * 
 * 	@author Grproth, skroutzzz, Chris394
 */
@Entity
public class Property {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long propertyId;
	
	@Column(name= "propertyAddress",length = 25)
	private String address;
	private LocalDate constructionYear;
	
	@Column(columnDefinition = "enum('DETACHED_HOUSE','MAISONETTE', 'APARTMENT_BUILDING')")
	@Enumerated(EnumType.STRING)
	private PropertyType propertyType;
	
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="property")
	private List<PropertyRepair> propertyRepairs;
	

	public Property() {
		
	}

	public Property( String address, 
			LocalDate constructionYear, PropertyType propertyType) {
		
		this.address = address;
		this.constructionYear = constructionYear;
		this.propertyType = propertyType;
		
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
				+ "propertyType";
	}
	
	@Override
	public String toString() {
		
		return "propertyId=" + propertyId + ", address=" + address + ", constructionYear=" 
			+ constructionYear + ", propertyType=" + propertyType;
	}
}
