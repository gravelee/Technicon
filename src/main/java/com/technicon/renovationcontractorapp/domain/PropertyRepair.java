package com.technicon.renovationcontractorapp.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 	This class represents the repairs that a property can have
 * 	(a property can have many repairs).
 * 
 * 	@author Grproth, skroutzzz
 */
public class PropertyRepair {

	private LocalDateTime dateTime;
	private String summary;
	private RepairType repairType;
	private StatusType statusType;
	private BigDecimal cost;
	private long ownerVatNumber;
	private long pIdNumber;
	private String repairDesc;
	
	public PropertyRepair( final LocalDateTime datetime, 
		final String summary, final RepairType repairType, 
		final StatusType statusType, final BigDecimal cost, 
		final long ownerVatNumber, final long pIdNumber, 
		final String repairDesc) {
		
		this.dateTime = datetime;
		this.summary = summary;
		this.repairType = repairType;
		this.statusType = statusType;
		this.cost = cost;
		this.ownerVatNumber = ownerVatNumber;
		this.pIdNumber = pIdNumber;
		this.repairDesc = repairDesc;
	}

	public LocalDateTime getDatetime() {
		return dateTime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.dateTime = datetime;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public RepairType getRepairType() {
		return repairType;
	}

	public void setRepairType(RepairType repairType) {
		this.repairType = repairType;
	}

	public StatusType getStatusType() {
		return statusType;
	}

	public void setStatusType(StatusType statusType) {
		this.statusType = statusType;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public long getOwnerVatNumber() {
		return ownerVatNumber;
	}

	public void setOwnerVatNumber(long ownerVatNumber) {
		this.ownerVatNumber = ownerVatNumber;
	}

	public long getpIdNumber() {
		return pIdNumber;
	}

	public void setpIdNumber(long pIdNumber) {
		this.pIdNumber = pIdNumber;
	}

	public String getRepairDesc() {
		return repairDesc;
	}

	public void setRepairDesc(String repairDesc) {
		this.repairDesc = repairDesc;
	}
	
	public String header() {
		
		return "datetime, summary, repairType, statusType, cost, "
				+ "ownerVatNumber, pIdNumber, repairDesc";
	}
	
	@Override
	public String toString() {
		
		return dateTime + ", " + summary + ", " + repairType + ", " 
				+ statusType + ", " + cost + ", " + ownerVatNumber + ", " 
				+ pIdNumber + ", " + repairDesc;
	}
}
