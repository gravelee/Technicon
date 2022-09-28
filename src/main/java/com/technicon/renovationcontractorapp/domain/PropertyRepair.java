package com.technicon.renovationcontractorapp.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 	This class represents the repairs that a property can have
 * 	(a property can have many repairs).
 * 
 * 	@author Grproth, skroutzzz
 */
public class PropertyRepair {

	private long propertyRepairId;
	private LocalDate dateTime;
	private String summary;
	private RepairType repairType;
	private StatusType statusType;
	private BigDecimal cost;
	private String vatNumber;
	private long propertyId;
	private String repairDesc;
	
	public PropertyRepair( long propertyRepairId, 
		LocalDate dateTime, String summary, 
		RepairType repairType, StatusType statusType, 
		BigDecimal cost, String vatNumber, 
		long propertyId, String repairDesc) {
		
		this.propertyRepairId = propertyRepairId;
		this.dateTime = dateTime;
		this.summary = summary;
		this.repairType = repairType;
		this.statusType = statusType;
		this.cost = cost;
		this.vatNumber = vatNumber;
		this.propertyId = propertyId;
		this.repairDesc = repairDesc;
	}

	public long getPropertyRepairId() {
		return propertyRepairId;
	}

	public void setPropertyRepairId( long propertyRepairId) {
		this.propertyRepairId = propertyRepairId;
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

	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	public String getRepairDesc() {
		return repairDesc;
	}

	public void setRepairDesc( String repairDesc) {
		this.repairDesc = repairDesc;
	}

	public String header() {
		
		return "propertyRepairId, dateTime, summary, repairType, statusType, cost, "
				+ "vatNumber, propertyId, repairDesc";
	}

	@Override
	public String toString() {
		return "propertyRepairId=" + propertyRepairId + ", dateTime=" + dateTime + ", summary="
				+ summary + ", repairType=" + repairType + ", statusType=" + statusType + ", cost=" + cost
				+ ", vatNumber=" + vatNumber + ", propertyId=" + propertyId + ", repairDesc=" + repairDesc;
	}
	
	
}
