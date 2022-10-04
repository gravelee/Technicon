package com.technicon.renovationcontractorapp.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.technicon.renovationcontractorapp.domain.RepairType;
import com.technicon.renovationcontractorapp.domain.StatusType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * 	This class represents the repairs that a property can have
 * 	(a property can have many repairs).
 * 
 *  @author Grproth, skroutzzz, Chris394
 */

@Entity
public class PropertyRepair {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long propertyRepairId;
	private LocalDate dateTime;
	private String summary;
	
	@Column(columnDefinition = "enum('PAINTING','INSULATION', 'FRAMES', 'PLUMBING', 'ELECTRICAL_WORK')")
	@Enumerated(EnumType.STRING)
	private RepairType repairType;
	
	@Column(columnDefinition = "enum('PENDING','IN_PROGRESS', 'COMPLETE')")
	@Enumerated(EnumType.STRING)
	private StatusType statusType;
	private BigDecimal cost;
	@Column(length = 10)
	private String vatNumber;
	//private long propertyId;
	private String repairDesc;
	
	@ManyToOne
	private Property property;
	
	
	public PropertyRepair() {
		
	}

	public PropertyRepair( LocalDate dateTime, String summary, 
		RepairType repairType, StatusType statusType, 
		BigDecimal cost, String vatNumber,  String repairDesc) {
		
		this.dateTime = dateTime;
		this.summary = summary;
		this.repairType = repairType;
		this.statusType = statusType;
		this.cost = cost;
		this.vatNumber = vatNumber;
		
		this.repairDesc = repairDesc;
	}

	public long getPropertyRepairId() {
		return propertyRepairId;
	}

	public LocalDate getDateTime() {
		return dateTime;
	}

	public void setDateTime( LocalDate dateTime) {
		this.dateTime = dateTime;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary( String summary) {
		this.summary = summary;
	}

	public RepairType getRepairType() {
		return repairType;
	}

	public void setRepairType( RepairType repairType) {
		this.repairType = repairType;
	}

	public StatusType getStatusType() {
		return statusType;
	}

	public void setStatusType( StatusType statusType) {
		this.statusType = statusType;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost( BigDecimal cost) {
		this.cost = cost;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber( String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public String getRepairDesc() {
		return repairDesc;
	}

	public void setRepairDesc( String repairDesc) {
		this.repairDesc = repairDesc;
	}
	
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public String header() {
		
		return "propertyRepairId, dateTime, summary, repairType, statusType, cost, "
				+ "vatNumber,  repairDesc";
	}

	@Override
	public String toString() {
		return "propertyRepairId=" + propertyRepairId + ", dateTime=" + dateTime + ", summary="
				+ summary + ", repairType=" + repairType + ", statusType=" + statusType + ", cost=" + cost
				+ ", vatNumber=" + vatNumber + ", repairDesc=" + repairDesc;
	}
}
