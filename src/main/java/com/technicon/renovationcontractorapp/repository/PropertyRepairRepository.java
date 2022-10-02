package com.technicon.renovationcontractorapp.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.technicon.renovationcontractorapp.model.PropertyRepair;
import com.technicon.renovationcontractorapp.model.RepairType;
import com.technicon.renovationcontractorapp.model.StatusType;

/**
 * 	A more specific interface that extends the repository.
 * 	It represents the property-repair repository with the 
 * 	specific update & read methods of all its attributes.
 * 
 * 	@author Grproth, skroutzzz, Chris394
 */
public interface PropertyRepairRepository extends Repository<PropertyRepair, Long> {

	/*
	// read based on dateTime, vatNumber
	List<PropertyRepair> readByDates(LocalDate dateTime1,LocalDate dateTime2);
	List<PropertyRepair> readByDate(LocalDate dateTime);
	List<PropertyRepair> readByVatNumber(String vatNumber);
	
	// updates for datetime, summary, repairType, statusType, cost, ownerVatNumber, pIdNumber, repairDesc
	boolean updateDateTime(long propertyRepairId,LocalDate dateTime);
	boolean updateSummary(long propertyRepairId,String summary);
	boolean updateRepairType(long propertyRepairId,RepairType repairType);
	boolean updateStatusType(long propertyRepairId,StatusType statusType);
	boolean updateCost(long propertyRepairId,BigDecimal cost);
	boolean updateOwnerVatNumber(long propertyRepairId,String ownerVatNumber);
	boolean updatePidNumber(long propertyRepairId,long pIdNumber);
	boolean updateRepairDesc(long propertyRepairId,String repairDesc);
    */
}
